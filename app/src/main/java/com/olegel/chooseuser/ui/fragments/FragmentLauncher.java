package com.olegel.chooseuser.ui.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.olegel.chooseuser.R;

/**
 * Created by Oleg on 24.08.2017.
 */

public class FragmentLauncher {
    private FragmentManager manager;

    public FragmentLauncher(FragmentManager manager) {
        this.manager = manager;
    }
    private void launch(BaseFragment fragment, String tag, boolean addToBackStack){
        FragmentTransaction trans = manager.beginTransaction();
        trans.replace(R.id.fragment_container, fragment);
        if(addToBackStack){
            trans.addToBackStack(tag);
        }
        trans.commit();
    }
    public void setChooseFragment(boolean addToBackStack){
        launch(new ChooseFragment(),ChooseFragment.class.getSimpleName(),addToBackStack);
    }
    public void setAuthorizationFragment(boolean addToBackStack){
        launch(new AuthorizationFragment(),AuthorizationFragment.class.getSimpleName(),addToBackStack);
    }

}
