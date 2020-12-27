package com.example.app.MAIN.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.app.MAIN.di.module.MainModule;
import com.example.app.MAIN.mvp.contract.MainContract;

import com.jess.arms.di.scope.ActivityScope;
import com.example.app.MAIN.mvp.ui.activity.MainActivity;


/**
 * ================================================
 * Date: 05/20/2020 14:16
 * Description:
 * ================================================
 */
@ActivityScope
@Component(modules = MainModule.class, dependencies = AppComponent.class)
public interface MainComponent {
    void inject(MainActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        MainComponent.Builder view(MainContract.View view);

        MainComponent.Builder appComponent(AppComponent appComponent);

        MainComponent build();
    }
}