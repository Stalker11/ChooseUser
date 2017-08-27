package com.olegel.chooseuser.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.olegel.chooseuser.R;
import com.olegel.chooseuser.util.AppConstants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Oleg on 27.08.2017.
 */

public class ErrorFragment extends BaseFragment {
    private View view;
    private Unbinder unbinder;
    @BindView(R.id.error_message)
    TextView errorText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_error, null);
        unbinder = ButterKnife.bind(this,view);
        String error = getArguments().getString(AppConstants.PUT_ERROR);
        if(error != null){
            errorText.setText(error);
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}
