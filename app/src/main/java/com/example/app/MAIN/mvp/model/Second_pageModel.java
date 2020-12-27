package com.example.app.MAIN.mvp.model;

import android.app.Application;

import com.example.app.common.model.api.service.MainService;
import com.example.app.common.model.bean.entity.UserDetailEntity;
import com.example.app.common.model.bean.request.LoginParams;
import com.example.app.common.model.bean.response.BasicResponseEntity;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;

import com.example.app.MAIN.mvp.contract.Second_pageContract;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;


/**
 * ================================================
 * Date: 12/20/2020 19:46
 * Description:
 * ================================================
 */
@ActivityScope
public class Second_pageModel extends BaseModel implements Second_pageContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public Second_pageModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<BasicResponseEntity<UserDetailEntity>> login(String countryCode, String phone, String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("phone_code", countryCode);
        map.put("username", phone);
        map.put("login_pass", password);

//        this.username = username;
//        this.login_pass = login_pass;
//        this.phone_code = phone_code;

        return mRepositoryManager.obtainRetrofitService(MainService.class).login(map);
    }
}