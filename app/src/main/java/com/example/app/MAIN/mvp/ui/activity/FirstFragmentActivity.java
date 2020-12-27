package com.example.app.MAIN.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.app.R;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.example.app.MAIN.di.component.DaggerFirstFragmentComponent;
import com.example.app.MAIN.mvp.contract.FirstFragmentContract;
import com.example.app.MAIN.mvp.presenter.FirstFragmentPresenter;


import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Date: 12/24/2020 21:17
 * Description:
 * ================================================
 */
public class FirstFragmentActivity extends BaseActivity<FirstFragmentPresenter> implements FirstFragmentContract.View {

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerFirstFragmentComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_first_fragment; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }
}
