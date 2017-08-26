package com.olegel.chooseuser.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
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

public class SignInFragment extends BaseFragment {
    private View view;
    private Unbinder unbinder;
    private RegisterActivity act;
    @BindView(R.id.edit_login_signin)
    EditText login;
    @BindView(R.id.password_edit_login)
    EditText password;
    @BindView(R.id.login_enter)
    Button enter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_authorization, null);
        unbinder = ButterKnife.bind(this, view);
        act = (RegisterActivity) getActivity();
        return view;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    /**
     * CLick to button back in toolbar
     */
    @OnClick(R.id.autoriz_btn_back)
    public void back() {
        new FragmentLauncher(act.getSupportFragmentManager()).setChooseFragment(false);
    }

    /**
     * React on click button push
     */
    @OnClick(R.id.login_enter)
    public void changeDetails() {
        String log = login.getText().toString();
        String pas = password.getText().toString();
        if (log.length() == 0 || pas.length() == 0) {
            showShortToast(act.getResources().getString(R.string.short_password));
        } else {
            if (isValidMobile(log.trim()) || isValidMail(log.trim())) { //uncomment after fixed regular expression
                //Requests.getInstance().autorization(log.trim(), pas.trim(), new AutorizationCallback());
                //enter.setClickable(false);
                act.getPresenter().onLogInClick(log.trim(), pas.trim());
            } else {
                login.setError(act.getResources().getString(R.string.wrong_login));
            }
        }

    }

    /**
     * Deleting keyboard after click on button
     */
    @OnClick({R.id.login_enter, R.id.but_restore_password, R.id.autoriz_btn_back})
    public void deleteKeyboard() {
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) act.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /**
     * Check phone number
     *
     * @param phone text from password field
     */
    private boolean isValidMobile(String phone) {
        return (Pattern.matches("^\\+[0-9]{12}$", phone));
    }

    /**
     * Check mail
     *
     * @param email text from password field
     */
    private boolean isValidMail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

}
