package com.example.app.MAIN.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import com.example.app.MAIN.mvp.contract.MainContract;
import com.example.app.MAIN.mvp.model.MainModel;


/**
 * ================================================
 * Date: 05/20/2020 14:16
 * Description:
 * ================================================
 */
@Module
public abstract class MainModule {

    @Binds
    abstract MainContract.Model bindMainModel(MainModel model);
}