package com.olegel.chooseuser.presenter.interfaces;

import com.olegel.chooseuser.models.UserModel;

/**
 * Created by Oleg on 25.08.2017.
 */

public interface IUsersPresenter {
    void onItemClick(UserModel user);

    void onBind();
}
