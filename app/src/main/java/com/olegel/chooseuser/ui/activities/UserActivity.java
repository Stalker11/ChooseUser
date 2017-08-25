package com.olegel.chooseuser.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.olegel.chooseuser.R;
import com.olegel.chooseuser.models.UsersListModel;
import com.olegel.chooseuser.network.RequestsRetrofit;
import com.olegel.chooseuser.presenter.UsersPresentor;
import com.olegel.chooseuser.presenter.interfaces.IUsersPresenter;
import com.olegel.chooseuser.presenter.interfaces.IViewUsers;
import com.olegel.chooseuser.ui.activities.BaseActivity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Oleg on 24.08.2017.
 */

public class UserActivity extends BaseActivity implements IViewUsers{
    private Disposable disposable;
    private IUsersPresenter presenter;
    private static final String TAG = UserActivity.class.getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_user);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        presenter = new UsersPresentor(this);
        super.onResume();
    }

    @Override
    public void onItemClick(int position) {

    }
}
