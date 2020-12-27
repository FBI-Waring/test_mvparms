package com.example.app.MAIN.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.example.app.MAIN.di.module.KotlinActivityModule

import com.jess.arms.di.scope.ActivityScope


/**
 * ================================================
 * Date: 12/24/2020 21:21
 * Description:
 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(KotlinActivityModule::class), dependencies = arrayOf(AppComponent::class))
interface KotlinActivityComponent {
    fun inject(activity: KotlinActivityActivity)
}
