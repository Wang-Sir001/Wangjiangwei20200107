package com.bawei.wangjiangwei.contract;

import com.bawei.wangjiangwei.base.mvp.IBaseModel;
import com.bawei.wangjiangwei.base.mvp.IBaseView;
import com.bawei.wangjiangwei.model.HomeEntity;

public interface IHomeContract {
    interface IModel extends IBaseModel {
        void getData(ModelCallback modelCallback);

        interface ModelCallback{
            void success(HomeEntity homeEntity);
            void error(Throwable throwable);
        }
    }
    interface IView extends IBaseView {
        void success(HomeEntity homeEntity);
        void error(Throwable throwable);
    }
    interface IPresenter{
        void getData();
    }
}
