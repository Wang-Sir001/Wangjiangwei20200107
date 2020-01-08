package com.bawei.wangjiangwei.model;

import com.bawei.wangjiangwei.api.HomeApiService;
import com.bawei.wangjiangwei.contract.IHomeContract;
import com.bawei.wangjiangwei.utils.RertfitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeModel implements IHomeContract.IModel {
    @Override
    public void getData(ModelCallback modelCallback) {
        RertfitUtils.getInstance().getclear(HomeApiService.class)
                .getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeEntity homeEntity) {
                        modelCallback.success(homeEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        modelCallback.error(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
