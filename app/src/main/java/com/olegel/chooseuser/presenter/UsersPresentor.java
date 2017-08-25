package com.olegel.chooseuser.presenter;

import android.util.Log;

import com.olegel.chooseuser.models.UserModel;
import com.olegel.chooseuser.models.UsersListModel;
import com.olegel.chooseuser.network.RequestsRetrofit;
import com.olegel.chooseuser.presenter.interfaces.IUsersPresenter;
import com.olegel.chooseuser.presenter.interfaces.IViewUsers;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Oleg on 25.08.2017.
 */

public class UsersPresentor implements IUsersPresenter {
    private IViewUsers viewUsers;
    private Disposable disposable;
    public static final String TAG = UsersPresentor.class.getSimpleName();

    public UsersPresentor(IViewUsers viewUsers) {
        this.viewUsers = viewUsers;
        request();
    }
    private void request(){
        disposable = RequestsRetrofit.getInstance().getUsersInfo().getUsersList(1)
                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::users);
    }
    private void users(UsersListModel model){
        Log.d(TAG, "users: "+model.getUsers().get(0).getName());
    }
    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onBind() {

    }
}
