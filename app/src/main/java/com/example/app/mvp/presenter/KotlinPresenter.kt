package com.example.app.mvp.presenter

import android.app.Application
import com.example.app.common.model.api.MyErrorHandleSubscriber
import com.example.app.common.model.bean.entity.UserDetailEntity
import com.example.app.common.model.bean.response.BasicResponseEntity
import com.example.app.common.utils.RxUtils
import com.example.app.mvp.contract.KotlinContract
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.http.imageloader.ImageLoader
import com.jess.arms.integration.AppManager
import com.jess.arms.mvp.BasePresenter
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject


/**
 * ================================================
 * Date: 01/08/2021 11:08
 * Description:
 * ================================================
 */
@ActivityScope
class KotlinPresenter
@Inject
constructor(model: KotlinContract.Model, rootView: KotlinContract.View) :
        BasePresenter<KotlinContract.Model, KotlinContract.View>(model, rootView) {
    @Inject
    lateinit var mErrorHandler: RxErrorHandler

    @Inject
    lateinit var mApplication: Application

    @Inject
    lateinit var mImageLoader: ImageLoader

    @Inject
    lateinit var mAppManager: AppManager


    override fun onDestroy() {
        super.onDestroy();
    }

    fun login() {
        mModel.login()
                .compose(RxUtils.applySchedulers<BasicResponseEntity<UserDetailEntity>>(mRootView)) //线程调度
                .subscribe(object : MyErrorHandleSubscriber<UserDetailEntity?>(AppManager.getAppManager().currentActivity, mErrorHandler) {

                    fun onFailedCodeData(code: Int, data: UserDetailEntity) {
                        super.onFailedCodeData(code, data)
                    }
                })
    }
}
