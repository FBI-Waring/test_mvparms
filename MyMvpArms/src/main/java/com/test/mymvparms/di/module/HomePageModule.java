package com.test.mymvparms.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import com.test.mymvparms.mvp.contract.HomePageContract;
import com.test.mymvparms.mvp.model.HomePageModel;


/**
 * ================================================
 * Date: 12/20/2020 19:13
 * Description:
 * ================================================
 */
@Module
public abstract class HomePageModule {

    @Binds
    abstract HomePageContract.Model bindHomePageModel(HomePageModel model);
}