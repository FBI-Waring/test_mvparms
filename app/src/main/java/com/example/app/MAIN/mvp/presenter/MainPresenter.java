package com.example.app.MAIN.mvp.presenter;

import android.app.Application;

import com.example.app.common.model.api.Api;
import com.example.app.common.model.bean.response.MainRsp;
import com.example.app.common.utils.RxUtils;
import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.http.imageloader.ImageLoader;

import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;

import javax.inject.Inject;

import com.example.app.MAIN.mvp.contract.MainContract;


/**
 * ================================================
 * Date: 05/20/2020 14:16
 * Description:
 * ================================================
 */
@ActivityScope
public class MainPresenter extends BasePresenter<MainContract.Model, MainContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public MainPresenter(MainContract.Model model, MainContract.View rootView) {
        super(model, rootView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
    }

    public void loadData(String data) {
        mModel.loadData(data)
                .compose(RxUtils.applySchedulers(mRootView))//线程调度
                .subscribe(new ErrorHandleSubscriber<MainRsp>(mErrorHandler) {
                    @Override
                    public void onNext(MainRsp response) {
                        if(response.getStatus().equals(Api.SUCCESS)){
                            mRootView.loadDataSuccess(response);
                        }
                    }
                });
    }
}
