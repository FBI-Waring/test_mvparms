package com.test.mymvparms.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;

import com.test.mymvparms.mvp.contract.HomePageContract;


/**
 * ================================================
 * Date: 12/20/2020 19:13
 * Description:
 * ================================================
 */
@ActivityScope
public class HomePageModel extends BaseModel implements HomePageContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public HomePageModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }
}