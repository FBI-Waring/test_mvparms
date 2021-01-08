package com.example.app.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.example.app.di.module.KotlinModule

import com.jess.arms.di.scope.ActivityScope
import com.example.app.mvp.ui.activity.KotlinActivity


/**
 * ================================================
 * Date: 01/08/2021 11:08
 * Description:
 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(KotlinModule::class), dependencies = arrayOf(AppComponent::class))
interface KotlinComponent {
    fun inject(activity: KotlinActivity)
}
