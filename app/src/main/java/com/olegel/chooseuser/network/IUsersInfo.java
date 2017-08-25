package com.olegel.chooseuser.network;

import com.olegel.chooseuser.models.UsersListModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Oleg on 25.08.2017.
 */

public interface IUsersInfo {
    @GET("/api/users")
    Observable<UsersListModel> getUsersList(@Query("pages") int pageNumber);
}
