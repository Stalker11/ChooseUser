package com.olegel.chooseuser.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.olegel.chooseuser.R;
import com.olegel.chooseuser.models.UserModel;
import com.olegel.chooseuser.ui.activities.UserActivity;
import com.olegel.chooseuser.util.AppConstants;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Oleg on 26.08.2017.
 */

public class UserDetailFragment extends BaseFragment {
    private View view;
    private Unbinder unbinder;
    private UserActivity act;
    private UserModel user;
    @BindView(R.id.user_details_avatar)
    ImageView userAvatar;
    @BindView(R.id.user_details_name)
    TextView userName;
    @BindView(R.id.user_details_last_name)
    TextView userLastName;
    private static final String TAG = UserDetailFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_user_detail, null);
        unbinder = ButterKnife.bind(this, view);
        user = getArguments().getParcelable(AppConstants.PUT_USER);
        Log.d(TAG, "onCreateView: " + user);
        if (user != null) {
            Picasso.with(getContext())
                    .load(user.getImageLink())
                    .fit()
                    .centerCrop()
                    .into(userAvatar);
            userName.setText(user.getName());
            userLastName.setText(user.getLastName());
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}
