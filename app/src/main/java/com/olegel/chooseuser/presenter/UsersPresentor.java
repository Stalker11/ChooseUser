package com.olegel.chooseuser.presenter;

import android.util.Log;

import com.olegel.checkinternet.ICallBack;
import com.olegel.chooseuser.models.UserModel;
import com.olegel.chooseuser.models.UsersListModel;
import com.olegel.chooseuser.network.RequestsRetrofit;
import com.olegel.chooseuser.presenter.interfaces.IUsersPresenter;
import com.olegel.chooseuser.presenter.interfaces.IViewUsers;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Oleg on 25.08.2017.
 */

public class UsersPresentor implements IUsersPresenter {
    private IViewUsers viewUsers;
    private Disposable disposable;
    public static final String TAG = UsersPresentor.class.getSimpleName();

    public UsersPresentor() {
        request();
    }

    private void request() {
        disposable = RequestsRetrofit.getInstance().getUsersInfo().getUsersList(1)
                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::users, this::error);
    }

    private void users(UsersListModel model) {
        viewUsers.setUsersList(model.getUsers());
    }

    private void error(Throwable throwable) {
        viewUsers.onError(throwable.getMessage());
    }

    @Override
    public void onItemClick(UserModel user) {
        viewUsers.onItemClick(user);
    }

    @Override
    public void unBind() {
        disposable.dispose();
        viewUsers = null;
    }

    @Override
    public void bind(IViewUsers viewUsers) {
        this.viewUsers = viewUsers;
    }
}
