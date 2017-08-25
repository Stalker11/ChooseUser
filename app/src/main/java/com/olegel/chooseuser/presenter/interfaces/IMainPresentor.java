package com.olegel.chooseuser.presenter.interfaces;

/**
 * Created by Oleg on 23.08.2017.
 */

public interface IMainPresentor {
    void onSignInChooseClick();
    void onRegisterChooseClick();
    void onLogInClick(String login, String password);
    void onForgetPasswordClick();
    void onRegisterClick(String name, String lastName, String email
            , String password, String confirmPassword);
    void unbind();
}
