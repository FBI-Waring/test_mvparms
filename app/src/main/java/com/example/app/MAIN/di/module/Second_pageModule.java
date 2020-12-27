package com.example.app.MAIN.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import com.example.app.MAIN.mvp.contract.Second_pageContract;
import com.example.app.MAIN.mvp.model.Second_pageModel;


/**
 * ================================================
 * Date: 12/20/2020 19:46
 * Description:
 * ================================================
 */
@Module
public abstract class Second_pageModule {

    @Binds
    abstract Second_pageContract.Model bindSecond_pageModel(Second_pageModel model);
}