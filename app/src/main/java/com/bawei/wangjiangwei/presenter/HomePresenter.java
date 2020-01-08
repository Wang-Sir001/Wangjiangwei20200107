package com.bawei.wangjiangwei.presenter;

import com.bawei.wangjiangwei.base.mvp.BasePresenter;
import com.bawei.wangjiangwei.contract.IHomeContract;
import com.bawei.wangjiangwei.model.HomeEntity;
import com.bawei.wangjiangwei.model.HomeModel;

public class HomePresenter extends BasePresenter<HomeModel, IHomeContract.IView> implements IHomeContract.IPresenter {
    @Override
    protected HomeModel initModel() {
        return new HomeModel();
    }

    @Override
    public void getData() {
        model.getData(new IHomeContract.IModel.ModelCallback() {
            @Override
            public void success(HomeEntity homeEntity) {
                getView().success(homeEntity);
            }

            @Override
            public void error(Throwable throwable) {
                getView().error(throwable);
            }
        });
    }
}
