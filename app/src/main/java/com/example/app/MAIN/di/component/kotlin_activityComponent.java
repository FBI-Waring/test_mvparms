package com.example.app.MAIN.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.app.MAIN.di.module.kotlin_activityModule;

import com.jess.arms.di.scope.ActivityScope;


/**
 * ================================================
 * Date: 12/24/2020 21:21
 * Description:
 * ================================================
 */
@ActivityScope
@Component(modules = kotlin_activityModule.class, dependencies = AppComponent.class)
public interface kotlin_activityComponent {
    void inject(kotlin_activityActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        kotlin_activityComponent.Builder view(kotlin_activityContract.View view);

        kotlin_activityComponent.Builder appComponent(AppComponent appComponent);

        kotlin_activityComponent build();
    }
}