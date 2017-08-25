package com.olegel.chooseuser.network;

import com.olegel.chooseuser.util.AppConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Oleg on 25.08.2017.
 */

public class RequestsRetrofit {
    private static Retrofit retrofit;
    private static RequestsRetrofit requestSingltone;
    private IUsersInfo usersInfo;
    private static final String TAG = RequestsRetrofit.class.getSimpleName();

    private RequestsRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.API)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        usersInfo = retrofit.create(IUsersInfo.class);
    }

    public static RequestsRetrofit getInstance() {
        if (retrofit == null) {
            requestSingltone = new RequestsRetrofit();
            return requestSingltone;
        }
        return requestSingltone;
    }

    public IUsersInfo getUsersInfo() {
        return usersInfo;
    }

}
