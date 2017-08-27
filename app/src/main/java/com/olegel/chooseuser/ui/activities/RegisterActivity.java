package com.olegel.chooseuser.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.olegel.chooseuser.R;
import com.olegel.chooseuser.models.RegistrationModel;
import com.olegel.chooseuser.models.SignInModel;
import com.olegel.chooseuser.presenter.interfaces.IMainPresentor;
import com.olegel.chooseuser.presenter.interfaces.IView;
import com.olegel.chooseuser.presenter.MainPresenter;
import com.olegel.chooseuser.ui.fragments.FragmentLauncher;

import butterknife.Unbinder;

public class RegisterActivity extends BaseActivity implements IView {
    private IMainPresentor presenter;
    private Unbinder unbinder;
    private static final String TAG = RegisterActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
    }

    @Override
    protected void onResume() {
        if (presenter == null) {
            presenter = new MainPresenter();
        }
        presenter.bind(this);
        new FragmentLauncher(getSupportFragmentManager()).showChooseFragment(false);
        super.onResume();
    }

    @Override
    public void onLoginClick() {
        Log.d(TAG, "onLoginClick: ");
        new FragmentLauncher(getSupportFragmentManager()).showAuthorizationFragment(false);
    }

    @Override
    public void onRegisterClick() {
        Log.d(TAG, "onRegisterClick: ");
        new FragmentLauncher(getSupportFragmentManager()).showRegistrationFragment(false);
    }

    @Override
    public void logIn(SignInModel model) {
        startActivity(new Intent(this, UserActivity.class));
        finish();
    }

    @Override
    public void register(RegistrationModel model) {
        startActivity(new Intent(this, UserActivity.class));
        finish();
    }

    @Override
    protected void onPause() {
        presenter.unbind();
        super.onPause();
    }

    /**
     * Get presenter for fragments
     */
    public IMainPresentor getPresenter() {
        return presenter;
    }
}
