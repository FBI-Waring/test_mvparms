package com.example.app.MAIN.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.app.R;
import com.example.app.common.model.bean.response.MainRsp;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.example.app.MAIN.di.component.DaggerMainComponent;
import com.example.app.MAIN.mvp.contract.MainContract;
import com.example.app.MAIN.mvp.presenter.MainPresenter;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Date: 05/20/2020 14:16
 * Description:
 * ================================================
 */
public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;
    @BindView(R.id.tv_message)
    TextView tv_message;

    @Override
    protected void onResume() {
        super.onResume();
        toolbar_title.setText("自定义标题");
    }

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMainComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
//        mPresenter.loadData("模拟访问网络");
        tv_message.setOnClickListener(v -> {
            startActivity(new Intent(this,Second_pageActivity.class));

        });
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

    @Override
    public void loadDataSuccess(MainRsp data) {
        tv_message.setText(data.getMessage() + "");
    }
}
