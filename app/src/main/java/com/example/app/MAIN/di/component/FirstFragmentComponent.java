package com.example.app.MAIN.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.app.MAIN.di.module.FirstFragmentModule;
import com.example.app.MAIN.mvp.contract.FirstFragmentContract;

import com.jess.arms.di.scope.ActivityScope;
import com.example.app.MAIN.mvp.ui.activity.FirstFragmentActivity;
import com.example.app.MAIN.mvp.ui.fragment.FirstFragmentFragment;


/**
 * ================================================
 * Date: 12/24/2020 21:17
 * Description:
 * ================================================
 */
@ActivityScope
@Component(modules = FirstFragmentModule.class, dependencies = AppComponent.class)
public interface FirstFragmentComponent {
    void inject(FirstFragmentActivity activity);

    void inject(FirstFragmentFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        FirstFragmentComponent.Builder view(FirstFragmentContract.View view);

        FirstFragmentComponent.Builder appComponent(AppComponent appComponent);

        FirstFragmentComponent build();
    }
}