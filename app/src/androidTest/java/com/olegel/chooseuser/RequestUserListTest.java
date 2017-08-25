package com.olegel.chooseuser;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.olegel.chooseuser.models.UsersListModel;
import com.olegel.chooseuser.network.RequestsRetrofit;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Oleg on 25.08.2017.
 */
@RunWith(AndroidJUnit4.class)
public class RequestUserListTest {
    private Disposable disposable;
    private CountDownLatch lock = new CountDownLatch(1);
    private static final String TAG = RequestUserListTest.class.getSimpleName();

    @Test
    public void testUsersList() {
        disposable = RequestsRetrofit.getInstance().getUsersInfo().getUsersList(1)
                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::users);
        try {
            lock.await(10000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void dispose() {
        disposable.dispose();
    }

    private void users(UsersListModel model) {
        Log.d(TAG, "users: " + model.getUsers().get(0).getName());
    }
}
