package com.olegel.chooseuser.ui.fragments;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.widget.Toast;

/**
 * Created by Oleg on 23.08.2017.
 */

public class BaseFragment extends Fragment {
    private ProgressDialog progressDialog;

    public void showLongToast(String message) {
        Toast.makeText(getActivity(), message,
                Toast.LENGTH_LONG).show();
    }

    public void showShortToast(String message) {
        Toast.makeText(getActivity(), message,
                Toast.LENGTH_LONG).show();
    }

    public void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("Loading....");
        }
    }

    public void hideProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}
