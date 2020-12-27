package com.example.app.MAIN.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import com.example.app.MAIN.mvp.contract.FirstFragmentContract;
import com.example.app.MAIN.mvp.model.FirstFragmentModel;


/**
 * ================================================
 * Date: 12/24/2020 21:17
 * Description:
 * ================================================
 */
@Module
public abstract class FirstFragmentModule {

    @Binds
    abstract FirstFragmentContract.Model bindFirstFragmentModel(FirstFragmentModel model);
}