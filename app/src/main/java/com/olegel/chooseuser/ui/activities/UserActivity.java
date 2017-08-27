package com.olegel.chooseuser.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.olegel.checkinternet.Checking;
import com.olegel.checkinternet.ICallBack;
import com.olegel.chooseuser.R;
import com.olegel.chooseuser.models.UserModel;
import com.olegel.chooseuser.presenter.UsersPresentor;
import com.olegel.chooseuser.presenter.interfaces.IUsersPresenter;
import com.olegel.chooseuser.presenter.interfaces.IViewUsers;
import com.olegel.chooseuser.ui.fragments.FragmentLauncher;

import java.util.List;

/**
 * Created by Oleg on 24.08.2017.
 */

public class UserActivity extends BaseActivity implements IViewUsers<UserModel>, ICallBack {
    private IUsersPresenter presenter;
    private boolean internet = false;
    private static final String TAG = UserActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_user);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        new Checking(this);
        super.onResume();
    }

    @Override
    public void onItemClick(UserModel user) {
        new FragmentLauncher(getSupportFragmentManager()).showUserDetailFragment(user, true);
    }

    @Override
    public void setUsersList(List<UserModel> users) {
        hideProgressDialog();
        new FragmentLauncher(getSupportFragmentManager()).showUserListFragment(users, true);
    }

    @Override
    protected void onPause() {
        presenter.unBind();
        super.onPause();
    }

    /**
     * Call fragments from backstack
     */
    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            Log.d(TAG, "onBackPressed: " + getSupportFragmentManager().getBackStackEntryCount());
            getSupportFragmentManager().popBackStackImmediate();
        } else {
            finish();
        }

    }

    @Override
    public void onError(String error) {
        new FragmentLauncher(getSupportFragmentManager()).showErrorFragment(error, false);
    }

    /**
     * Get presenter for fragments
     */
    public IUsersPresenter getPresenter() {
        return presenter;
    }

    private void setPresenter() {
        if (presenter == null && internet) {
            presenter = new UsersPresentor();
            showProgressDialog();
        }
        presenter.bind(this);
    }

    @Override
    public void requestCallBack(boolean b, int i) {
        if (b) {
            internet = b;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    setPresenter();
                }
            });

        } else {
            new FragmentLauncher(getSupportFragmentManager())
                    .showErrorFragment(getResources().getString(R.string.not_internet_connection), false);
        }
    }


}
