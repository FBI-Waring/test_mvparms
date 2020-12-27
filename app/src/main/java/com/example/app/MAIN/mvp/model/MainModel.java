package com.example.app.MAIN.mvp.model;

import android.app.Application;

import com.example.app.common.model.api.service.MainService;
import com.example.app.common.model.bean.response.MainRsp;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;

import com.example.app.MAIN.mvp.contract.MainContract;

import io.reactivex.Observable;


/**
 * ================================================
 * Date: 05/20/2020 14:16
 * Description:
 * ================================================
 */
@ActivityScope
public class MainModel extends BaseModel implements MainContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public MainModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<MainRsp> loadData(String data) {
        return mRepositoryManager.obtainRetrofitService(MainService.class)
                .loadMainData(data);
    }
}