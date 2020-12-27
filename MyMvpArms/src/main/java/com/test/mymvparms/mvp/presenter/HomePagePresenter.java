package com.test.mymvparms.mvp.presenter;

import android.app.Application;

import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.http.imageloader.ImageLoader;

import me.jessyan.rxerrorhandler.core.RxErrorHandler;

import javax.inject.Inject;

import com.test.mymvparms.mvp.contract.HomePageContract;


/**
 * ================================================
 * Date: 12/20/2020 19:13
 * Description:
 * ================================================
 */
@ActivityScope
public class HomePagePresenter extends BasePresenter<HomePageContract.Model, HomePageContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public HomePagePresenter(HomePageContract.Model model, HomePageContract.View rootView) {
        super(model, rootView);
    }


    public void Login(String countryCode, String phone, String password){
//        mModel.login(countryCode,phone,password)
//                .compose(RxUtils.applySchedulers(mRootView))//线程调度
//                .subscribe(new ErrorHandleSubscriber<MainRsp>(mErrorHandler) {
//                    @Override
//                    public void onNext(MainRsp response) {
//                        if(response.getStatus().equals(Api.SUCCESS)){
//                            mRootView.loadDataSuccess(response);
//                        }
//                    }
//                });
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
