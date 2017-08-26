package com.olegel.chooseuser.presenter.interfaces;

import com.olegel.chooseuser.models.RegistrationModel;
import com.olegel.chooseuser.models.SignInModel;

/**
 * Created by Oleg on 23.08.2017.
 */

public interface IView {
    void onLoginClick();

    void onRegisterClick();

    void logIn(SignInModel model);

    void register(RegistrationModel model);
}
