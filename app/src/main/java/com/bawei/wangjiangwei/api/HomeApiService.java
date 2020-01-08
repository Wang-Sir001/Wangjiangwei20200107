package com.bawei.wangjiangwei.api;

import com.bawei.wangjiangwei.model.HomeEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface HomeApiService {

    @GET("small/order/verify/v1/findShoppingCart")
    Observable<HomeEntity> getData();

}
