package com.example.app.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.example.app.mvp.contract.KotlinContract
import com.example.app.mvp.model.KotlinModel


/**
 * ================================================
 * Date: 01/08/2021 11:08
 * Description:
 * ================================================
 */
@Module
//构建KotlinModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class KotlinModule(private val view: KotlinContract.View) {
    @ActivityScope
    @Provides
    fun provideKotlinView(): KotlinContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideKotlinModel(model: KotlinModel): KotlinContract.Model {
        return model
    }
}
