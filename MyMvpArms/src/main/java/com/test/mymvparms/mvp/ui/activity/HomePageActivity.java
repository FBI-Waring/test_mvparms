package com.test.mymvparms.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.test.mymvparms.R;
import com.test.mymvparms.di.component.DaggerHomePageComponent;
import com.test.mymvparms.mvp.contract.HomePageContract;
import com.test.mymvparms.mvp.presenter.HomePagePresenter;


import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Date: 12/20/2020 19:13
 * Description:
 * ================================================
 */
public class HomePageActivity extends BaseActivity<HomePagePresenter> implements HomePageContract.View {

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerHomePageComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_home_page; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
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
