package com.example.app.MAIN.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;

import com.example.app.MAIN.mvp.contract.FirstFragmentContract;


/**
 * ================================================
 * Date: 12/24/2020 21:17
 * Description:
 * ================================================
 */
@ActivityScope
public class FirstFragmentModel extends BaseModel implements FirstFragmentContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public FirstFragmentModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }
}