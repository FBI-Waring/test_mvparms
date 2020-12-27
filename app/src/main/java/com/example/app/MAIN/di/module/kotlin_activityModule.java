package com.example.app.MAIN.di.module;

import dagger.Binds;
import dagger.Module;


/**
 * ================================================
 * Date: 12/24/2020 21:21
 * Description:
 * ================================================
 */
@Module
public abstract class kotlin_activityModule {

    @Binds
    abstract kotlin_activityContract.Model bindkotlin_activityModel(kotlin_activityModel model);
}