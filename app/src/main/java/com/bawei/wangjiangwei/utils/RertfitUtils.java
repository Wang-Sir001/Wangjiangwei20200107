package com.bawei.wangjiangwei.utils;

import com.bawei.wangjiangwei.R;
import com.bawei.wangjiangwei.api.Api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RertfitUtils {
    private static RertfitUtils rertfitUtils;
    private final Retrofit retrofit;

    private RertfitUtils() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Api.BASE_URL)
                .build();
    }

    public static RertfitUtils getInstance() {
        if (rertfitUtils == null) {
            synchronized (RertfitUtils.class){
                if (rertfitUtils == null) {
                    rertfitUtils = new RertfitUtils();
                }
            }
        }
        return rertfitUtils;
    }

    public <T>T getclear(Class<T> tClass){
        return retrofit.create(tClass);
    }
}
