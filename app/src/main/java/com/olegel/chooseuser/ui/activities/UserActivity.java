package com.olegel.chooseuser.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

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

public class UserActivity extends BaseActivity implements IViewUsers<UserModel> {
    private IUsersPresenter presenter;
    private static final String TAG = UserActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_user);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        if (presenter == null) {
            presenter = new UsersPresentor(this);
        }
        showProgressDialog();
        super.onResume();
    }

    @Override
    public void onItemClick(UserModel user) {
        new FragmentLauncher(getSupportFragmentManager()).setUserDetailFragment(user, true);
    }

    @Override
    public void setUsersList(List<UserModel> users) {
        hideProgressDialog();
        new FragmentLauncher(getSupportFragmentManager()).setUserListFragment(users, true);
    }

    @Override
    protected void onPause() {
        presenter.onBind();
        super.onPause();
    }

    /**
     * Call fragments from backstack
     */
    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            Log.d(TAG, "onBackPressed: "+getSupportFragmentManager().getBackStackEntryCount());
            getSupportFragmentManager().popBackStackImmediate();
        } else {
            finish();
        }

    }

    /**
     * Get presenter for fragments
     */
    public IUsersPresenter getPresenter() {
        return presenter;
    }
}
