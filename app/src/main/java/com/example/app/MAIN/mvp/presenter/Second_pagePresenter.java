package com.example.app.MAIN.mvp.presenter;

import android.app.Application;

import com.example.app.common.model.api.Api;
import com.example.app.common.model.api.MyErrorHandleSubscriber;
import com.example.app.common.model.bean.entity.UserDetailEntity;
import com.example.app.common.model.bean.response.BasicResponseEntity;
import com.example.app.common.model.bean.response.MainRsp;
import com.example.app.common.utils.RxUtils;
import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.http.imageloader.ImageLoader;

import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;

import javax.inject.Inject;

import com.example.app.MAIN.mvp.contract.Second_pageContract;


/**
 * ================================================
 * Date: 12/20/2020 19:46
 * Description:
 * ================================================
 */
@ActivityScope
public class Second_pagePresenter extends BasePresenter<Second_pageContract.Model, Second_pageContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public Second_pagePresenter(Second_pageContract.Model model, Second_pageContract.View rootView) {
        super(model, rootView);
    }

    public void Login(String countryCode, String phone, String password) {

        mModel.login(countryCode, phone, password)
                .compose(RxUtils.applySchedulers(mRootView))//线程调度
                .subscribe(new MyErrorHandleSubscriber<UserDetailEntity>(mErrorHandler) {


                    @Override
                    public void onSuccessData(UserDetailEntity data) {

                        mRootView.loadDataSuccess(data);

                    }

                    @Override
                    public void onFailedCodeData(int code, UserDetailEntity data) {
                        super.onFailedCodeData(code, data);

                    }


                });

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
    }
}
