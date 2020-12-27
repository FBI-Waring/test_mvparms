package com.example.app.MAIN.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.app.MAIN.di.module.Second_pageModule;
import com.example.app.MAIN.mvp.contract.Second_pageContract;

import com.jess.arms.di.scope.ActivityScope;
import com.example.app.MAIN.mvp.ui.activity.Second_pageActivity;


/**
 * ================================================
 * Date: 12/20/2020 19:46
 * Description:
 * ================================================
 */
@ActivityScope
@Component(modules = Second_pageModule.class, dependencies = AppComponent.class)
public interface Second_pageComponent {
    void inject(Second_pageActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Second_pageComponent.Builder view(Second_pageContract.View view);

        Second_pageComponent.Builder appComponent(AppComponent appComponent);

        Second_pageComponent build();
    }
}