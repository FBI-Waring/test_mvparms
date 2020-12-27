package com.example.app.MAIN.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides


/**
 * ================================================
 * Date: 12/24/2020 21:21
 * Description:
 * ================================================
 */
@Module
//构建KotlinActivityModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class KotlinActivityModule(private val view: KotlinActivityContract.View) {
    @ActivityScope
    @Provides
    fun provideKotlinActivityView(): KotlinActivityContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideKotlinActivityModel(model: KotlinActivityModel): KotlinActivityContract.Model {
        return model
    }
}
