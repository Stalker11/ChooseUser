package com.olegel.chooseuser.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.olegel.chooseuser.R;
import com.olegel.chooseuser.ui.activities.RegisterActivity;

import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Oleg on 24.08.2017.
 */

public class RegistrationFragment extends BaseFragment {
    private View view;
    private Unbinder unbinder;
    @BindView(R.id.name_reg)
    EditText firstName;
    @BindView(R.id.family_reg)
    EditText lastName;
    @BindView(R.id.email_reg)
    EditText email;
    @BindView(R.id.pass_reg)
    EditText password;
    @BindView(R.id.pass_ver_reg)
    EditText confirmPassword;
    private RegisterActivity act;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_registration, null);
        unbinder = ButterKnife.bind(this, view);
        act = (RegisterActivity) getActivity();
        return view;
    }

    /**
     * Generate checking fields and request for creating user
     */
    @OnClick(R.id.regis_enter_reg)
    public void registration() {
        String nameFirst = firstName.getText().toString().trim();
        String nameLast = lastName.getText().toString().trim();
        String userMail = email.getText().toString().trim();
        String userPassword = password.getText().toString().trim();
        String confirmUserPassword = confirmPassword.getText().toString().trim();

        if (nameFirst.length() == 0 || nameLast.length() == 0 ||
                userMail.length() == 0 || userPassword.length() == 0 ||
                confirmUserPassword.length() == 0) {
            showShortToast(view.getResources().getString(R.string.all_fields_must_be_filled));
        } else if (!userPassword.equals(confirmUserPassword)) {
            confirmPassword.setError(view.getResources().getString(R.string.password_not_confirm));
        } else if (!isValidMail(userMail)) {
            email.setError(view.getResources().getString(R.string.incorrectly_email));
        } else if (isValidMobile(userMail) || isValidMail(userMail)) {
            act.getPresenter().onRegisterClick(nameFirst, nameLast, userMail, userPassword, confirmUserPassword);
        }
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) act.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /**
     * CLick to button back in toolbar
     */
    @OnClick(R.id.registration_btn_back)
    public void back() {
        new FragmentLauncher(act.getSupportFragmentManager()).showChooseFragment(false);
    }

    /**
     * Check mail
     */
    private boolean isValidMobile(String phone) {
        return (Pattern.matches("^\\+[0-9]{12}$", phone));
    }

    /**
     * Check phone number
     */
    private boolean isValidMail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}
