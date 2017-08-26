package com.olegel.chooseuser.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.olegel.chooseuser.R;
import com.olegel.chooseuser.adapters.UsersAdapter;
import com.olegel.chooseuser.models.UserModel;
import com.olegel.chooseuser.ui.activities.UserActivity;
import com.olegel.chooseuser.util.AppConstants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Oleg on 25.08.2017.
 */

public class UsersListFragment extends BaseFragment {
    private View view;
    private Unbinder unbinder;
    private UserActivity act;
    private static final String TAG = UsersListFragment.class.getSimpleName();
    private List<UserModel> users;
    @BindView(R.id.user_recycler)
    RecyclerView recycler;
    private UsersAdapter adapter;
    private LinearLayoutManager manager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_user_list, null);
        users = getArguments().getParcelableArrayList(AppConstants.PUT_USERS_LIST);
        unbinder = ButterKnife.bind(this, view);
        act = (UserActivity) getActivity();
        Log.d(TAG, "onCreateView: " + users);
        if (users != null) {
            recycler.setLayoutManager(new LinearLayoutManager(getContext()));
            adapter = new UsersAdapter(users);
            adapter.setOnItemClickListener(model -> act.getPresenter().onItemClick(model));
            recycler.setAdapter(adapter);
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        if (adapter != null) {
            adapter.unbindButterKnife();
        }
        super.onDestroyView();
    }
}
