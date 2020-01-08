package com.bawei.wangjiangwei;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.bawei.wangjiangwei.base.BaseActivity;
import com.bawei.wangjiangwei.contract.IHomeContract;
import com.bawei.wangjiangwei.model.HomeEntity;
import com.bawei.wangjiangwei.model.adapter.HomeAdapter;
import com.bawei.wangjiangwei.presenter.HomePresenter;

import butterknife.BindView;

public class MainActivity extends BaseActivity<HomePresenter> implements IHomeContract.IView {
    @BindView(R.id.rv_one)
    RecyclerView oneRv;
    @Override
    protected void initData() {
        presenter.getData();
    }

    @Override
    protected void initView() {
        oneRv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void success(HomeEntity homeEntity) {
        HomeAdapter homeAdapter = new HomeAdapter(this, homeEntity.result);
        oneRv.setAdapter(homeAdapter);
    }

    @Override
    public void error(Throwable throwable) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
