package com.olegel.chooseuser.presenter;

import com.olegel.chooseuser.models.RegistrationModel;
import com.olegel.chooseuser.models.SignInModel;
import com.olegel.chooseuser.presenter.interfaces.IMainPresentor;
import com.olegel.chooseuser.presenter.interfaces.IView;

/**
 * Created by Oleg on 23.08.2017.
 */

public class MainPresenter implements IMainPresentor {
    private IView view;
    private SignInModel signIn;
    private RegistrationModel registration;

    @Override
    public void onSignInChooseClick() {
        view.onLoginClick();
    }

    @Override
    public void onRegisterChooseClick() {
        view.onRegisterClick();
    }

    @Override
    public void onLogInClick(String login, String password) {
        signIn = new SignInModel();
        signIn.setLogin(login);
        signIn.setPassword(password);
        view.logIn(signIn);
    }

    @Override
    public void onForgetPasswordClick() {

    }

    @Override
    public void onRegisterClick(String name, String lastName, String email
            , String password, String confirmPassword) {
        registration = new RegistrationModel();
        registration.setName(name);
        registration.setLastName(lastName);
        registration.setEmail(email);
        registration.setPassword(password);
        registration.setConfirmPassword(confirmPassword);
        view.register(registration);
    }

    @Override
    public void unbind() {
        view = null;
    }

    @Override
    public void bind(IView view) {
        this.view = view;
    }
}
