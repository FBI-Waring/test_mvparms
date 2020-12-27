package com.test.mymvparms.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.test.mymvparms.di.module.HomePageModule;
import com.test.mymvparms.mvp.contract.HomePageContract;

import com.jess.arms.di.scope.ActivityScope;
import com.test.mymvparms.mvp.ui.activity.HomePageActivity;


/**
 * ================================================
 * Date: 12/20/2020 19:13
 * Description:
 * ================================================
 */
@ActivityScope
@Component(modules = HomePageModule.class, dependencies = AppComponent.class)
public interface HomePageComponent {
    void inject(HomePageActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        HomePageComponent.Builder view(HomePageContract.View view);

        HomePageComponent.Builder appComponent(AppComponent appComponent);

        HomePageComponent build();
    }
}