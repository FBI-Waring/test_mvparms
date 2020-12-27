package com.example.app.MAIN.mvp.ui.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.app.MAIN.di.component.DaggerSecond_pageComponent;
import com.example.app.MAIN.mvp.contract.Second_pageContract;
import com.example.app.MAIN.mvp.presenter.Second_pagePresenter;
import com.example.app.R;
import com.example.app.common.model.bean.entity.UserDetailEntity;
import com.example.app.common.model.bean.response.BasicResponseEntity;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.jess.arms.utils.LogUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Date: 12/20/2020 19:46
 * Description:
 * ================================================
 */
public class Second_pageActivity extends BaseActivity<Second_pagePresenter> implements Second_pageContract.View {

    @BindView(R.id.et_mobile_number)
    EditText etMobileNumber;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.but_login)
    Button butLogin;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerSecond_pageComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_second_page; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {




    }




    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
        System.out.println(message);
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
    public void loadDataSuccess(UserDetailEntity response) {
        LogUtils.debugInfo(response.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.but_login)
    public void onViewClicked() {
        mPresenter.Login("+86", etMobileNumber.getText().toString(), password.getText().toString() + "00000000f.");

    }
}
