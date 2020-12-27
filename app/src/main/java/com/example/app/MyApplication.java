package com.example.app;

import android.content.Context;

import com.jess.arms.base.BaseApplication;

import butterknife.internal.Utils;

public class MyApplication extends BaseApplication {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

        //blankj工具初始化
//        Utils.init(this);
    }

    public static Context getContext() {
        return mContext;
    }
}
