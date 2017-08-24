package com.olegel.chooseuser.presenter;

import com.olegel.chooseuser.presenter.interfaces.IMainPresentor;
import com.olegel.chooseuser.presenter.interfaces.IModel;
import com.olegel.chooseuser.presenter.interfaces.IView;

/**
 * Created by Oleg on 23.08.2017.
 */

public class MainPresenter implements IMainPresentor {
    private IView view;
    private IModel model;

    public MainPresenter(IView view) {
        this.view = view;
        model = new Model();
    }



    @Override
    public void onSignInChooseClick() {
        view.onLoginClick(); model.login();
    }

    @Override
    public void onRegisterChooseClick() {
        view.onRegisterClick(); model.password();
    }

    @Override
    public void onLogInClick() {

    }

    @Override
    public void onForgetPasswordClick() {

    }

    @Override
    public void onRegisterClick() {

    }
}
