package com.olegel.chooseuser.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.olegel.chooseuser.R;
import com.olegel.chooseuser.presenter.interfaces.IMainPresentor;
import com.olegel.chooseuser.presenter.interfaces.IView;
import com.olegel.chooseuser.presenter.MainPresenter;
import com.olegel.chooseuser.ui.fragments.FragmentLauncher;

import butterknife.Unbinder;

public class RegistActivity extends AppCompatActivity implements IView{
    private IMainPresentor presenter;
    private Unbinder unbinder;
    private static final String TAG = RegistActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        if(presenter == null){
            presenter = new MainPresenter(this);
        }
      //  presenter.onRegisterClick();
    }

    @Override
    protected void onStart() {
        new FragmentLauncher(getSupportFragmentManager()).setChooseFragment(false);
        super.onStart();
    }

    @Override
    public void onLoginClick() {
        Log.d(TAG, "onLoginClick: ");
        new FragmentLauncher(getSupportFragmentManager()).setAuthorizationFragment(false);
    }

    @Override
    public void onRegisterClick() {
        Log.d(TAG, "onRegisterClick: ");
    }

    public IMainPresentor getPresenter(){
        return presenter;
    }
}
