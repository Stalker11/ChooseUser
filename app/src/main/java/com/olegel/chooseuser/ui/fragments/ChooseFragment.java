package com.olegel.chooseuser.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.olegel.chooseuser.R;
import com.olegel.chooseuser.ui.activities.RegisterActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Oleg on 23.08.2017.
 */

public class ChooseFragment extends BaseFragment {
    private Unbinder unbinder;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_choose, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.but_open_signin_page)
    public void signIn() {
        ((RegisterActivity) getActivity()).getPresenter().onSignInChooseClick();
    }

    @OnClick(R.id.but_open_registration_page)
    public void register() {
        ((RegisterActivity) getActivity()).getPresenter().onRegisterChooseClick();
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}
