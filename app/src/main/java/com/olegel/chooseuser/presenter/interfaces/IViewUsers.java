package com.olegel.chooseuser.presenter.interfaces;

import com.olegel.chooseuser.models.UserModel;

import java.util.List;

/**
 * Created by Oleg on 25.08.2017.
 */

public interface IViewUsers<T> {
    void onItemClick(UserModel user);
    void onError(String error);
    void setUsersList(List<T> users);
}
