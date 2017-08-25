package com.olegel.chooseuser.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.olegel.chooseuser.R;
import com.olegel.chooseuser.ui.activities.RegisterActivity;
import com.olegel.chooseuser.ui.activities.UserActivity;

import butterknife.Unbinder;

/**
 * Created by Oleg on 25.08.2017.
 */

public class UsersListFragment extends BaseFragment {
    private View view;
    private Unbinder unbinder;
    private UserActivity act;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_user_list, null);

        return view;
    }
}
