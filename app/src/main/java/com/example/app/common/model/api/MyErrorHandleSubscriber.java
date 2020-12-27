/**
 * Copyright 2017 JessYan
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.app.common.model.api;

import android.text.TextUtils;

import com.example.app.common.model.bean.response.BasicResponseEntity;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandlerFactory;


/**
 * ================================================
 * Created by JessYan on 9/2/2016 14:41
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public abstract class MyErrorHandleSubscriber<T> implements Observer<BasicResponseEntity<T>> {

    //public abstract class BaseObserver<T> implements Observer<BaseEntity<T>> {


    private ErrorHandlerFactory mHandlerFactory;
    private boolean mDontShowRespondMsg = false;
    private boolean mDontShowExceptionMsg = false;


    public MyErrorHandleSubscriber(RxErrorHandler rxErrorHandler) {
        this.mHandlerFactory = rxErrorHandler.getHandlerFactory();
    }

    public MyErrorHandleSubscriber(RxErrorHandler rxErrorHandler, boolean noShowMsg) {
        this.mHandlerFactory = rxErrorHandler.getHandlerFactory();
        this.mDontShowRespondMsg = noShowMsg;
    }


    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }


    @Override
    public void onNext(BasicResponseEntity<T> baseResponse) {
        if (baseResponse.isSucceed()) {
            onSuccessData(baseResponse.getData());
        } else if (baseResponse.getCode() == 1002) {
            //未完善信息
            onFailedCodeData(baseResponse.getCode(), baseResponse.getData());

        } else {
            onFailed();
        }
        showMsg(baseResponse);
    }

    public void onFailed() {

    }

    private void showMsg(BasicResponseEntity<T> baseResponse) {
        if (!mDontShowRespondMsg && baseResponse != null && baseResponse.getMsg() != null && TextUtils.isEmpty(baseResponse.getMsg())) {
            //todo 显示后台返回的message
        }
    }


    public void onSuccessData(T data) {
    }


    public void onFailedCodeData(int code, T data) {
    }


    public void doError(String errorDescription) {
        if (!mDontShowExceptionMsg) {
            //todo 显示异常的message
        }
    }


    @Override
    public void onComplete() {

    }


    @Override
    public void onError(@NonNull Throwable t) {
        t.printStackTrace();
        //如果你某个地方不想使用全局错误处理,则重写 onError(Throwable) 并将 super.onError(e); 删掉
        //如果你不仅想使用全局错误处理,还想加入自己的逻辑,则重写 onError(Throwable) 并在 super.onError(e); 后面加入自己的逻辑
        mHandlerFactory.handleError(t);
        String errorTypeDes = ApiException.handleException(t).getMessage();
        doError(errorTypeDes);
    }
}

