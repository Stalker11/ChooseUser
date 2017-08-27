package com.olegel.chooseuser.ui.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.olegel.chooseuser.R;
import com.olegel.chooseuser.models.UserModel;
import com.olegel.chooseuser.util.AppConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 24.08.2017.
 */

public class FragmentLauncher {
    private FragmentManager manager;

    public FragmentLauncher(FragmentManager manager) {
        this.manager = manager;
    }

    private void launch(BaseFragment fragment, String tag, boolean addToBackStack) {
        FragmentTransaction trans = manager.beginTransaction();
        trans.replace(R.id.fragment_container, fragment);
        if (addToBackStack) {
            trans.addToBackStack(tag);
        }
        trans.commit();
    }

    public void showChooseFragment(boolean addToBackStack) {
        launch(new ChooseFragment(), ChooseFragment.class.getSimpleName(), addToBackStack);
    }

    public void showAuthorizationFragment(boolean addToBackStack) {
        launch(new SignInFragment(), SignInFragment.class.getSimpleName(), addToBackStack);
    }

    public void showRegistrationFragment(boolean addToBackStack) {
        launch(new RegistrationFragment(), RegistrationFragment.class.getSimpleName(), addToBackStack);
    }

    public void showUserListFragment(List<UserModel> userModels, boolean addToBackStack) {
        UsersListFragment fragment = new UsersListFragment();
        if (userModels != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(AppConstants.PUT_USERS_LIST, (ArrayList<? extends Parcelable>) userModels);
            fragment.setArguments(bundle);
        }
        launch(fragment, UsersListFragment.class.getSimpleName(), addToBackStack);
    }

    public void showUserDetailFragment(UserModel user, boolean addToBackStack) {
        UserDetailFragment fragment = new UserDetailFragment();
        if (user != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(AppConstants.PUT_USER, user);
            fragment.setArguments(bundle);
        }
        launch(fragment, UsersListFragment.class.getSimpleName(), addToBackStack);
    }

    public void showErrorFragment(String error, boolean addToBackStack) {
        ErrorFragment fragment = new ErrorFragment();
        if (error != null) {
            Bundle bundle = new Bundle();
            bundle.putString(AppConstants.PUT_ERROR, error);
            fragment.setArguments(bundle);
        }
        launch(fragment, ErrorFragment.class.getSimpleName(), addToBackStack);
    }
}
