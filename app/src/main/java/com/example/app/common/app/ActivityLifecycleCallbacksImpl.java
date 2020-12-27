package com.example.app.common.app;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.example.app.R;
import com.example.app.common.utils.immersion.StatusBarUtil;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import timber.log.Timber;

/**
 * ================================================
 * 展示 {@link Application.ActivityLifecycleCallbacks} 的用法
 * <p>
 * Created by MVPArmsTemplate on 12/10/2019 14:09
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public class ActivityLifecycleCallbacksImpl implements Application.ActivityLifecycleCallbacks {

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Timber.i(activity + " - onActivityCreated");
    }

    @Override
    public void onActivityStarted(Activity activity) {
        Timber.i("%s - onActivityStarted", activity);
        if (!activity.getIntent().getBooleanExtra("isInitToolbar", false)) {
            //由于加强框架的兼容性,故将 setContentView 放到 onActivityCreated 之后,onActivityStarted 之前执行
            //而 findViewById 必须在 Activity setContentView() 后才有效,所以将以下代码从之前的 onActivityCreated 中移动到 onActivityStarted 中执行
            activity.getIntent().putExtra("isInitToolbar", true);
            //这里全局给Activity设置toolbar和title,你想象力有多丰富,这里就有多强大,以前放到BaseActivity的操作都可以放到这里
            if (activity.findViewById(R.id.toolbar) != null) {
                if (activity instanceof AppCompatActivity) {
                    ((AppCompatActivity) activity).setSupportActionBar(activity.findViewById(R.id.toolbar));
                    Objects.requireNonNull(((AppCompatActivity) activity).getSupportActionBar()).setDisplayShowTitleEnabled(false);
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        activity.setActionBar(activity.findViewById(R.id.toolbar));
                        Objects.requireNonNull(activity.getActionBar()).setDisplayShowTitleEnabled(false);
                    }
                }
            }
            if (activity.findViewById(R.id.toolbar_title) != null) {
                ((TextView) activity.findViewById(R.id.toolbar_title)).setText(activity.getTitle());
            }
            if (activity.findViewById(R.id.toolbar_back) != null) {
                activity.findViewById(R.id.toolbar_back).setOnClickListener(v -> activity.onBackPressed());
            }
        }

        //沉浸式状态栏
//        initImmersion(activity);
    }

    private void initImmersion(Activity activity) {
        //当FitsSystemWindows设置 true 时，会在屏幕最上方预留出状态栏高度的 padding
        StatusBarUtil.setRootViewFitsSystemWindows(activity,false);//推荐false
        //设置状态栏透明
        StatusBarUtil.setTranslucentStatus(activity);
        //一般的手机的状态栏文字和图标都是白色的, 可如果你的应用也是纯白色的, 或导致状态栏文字看不清
        //所以如果你是这种情况,请使用以下代码, 设置状态使用深色文字图标风格, 否则你可以选择性注释掉这个if内容
        if (!StatusBarUtil.setStatusBarDarkTheme(activity, true)) {
            //如果不支持设置深色风格 为了兼容总不能让状态栏白白的看不清, 于是设置一个状态栏颜色为半透明,
            //这样半透明+白=灰, 状态栏的文字能看得清
            StatusBarUtil.setStatusBarColor(activity,0x55000000);
        }

    }

    @Override
    public void onActivityResumed(Activity activity) {
        Timber.i(activity + " - onActivityResumed");
    }

    @Override
    public void onActivityPaused(Activity activity) {
        Timber.i(activity + " - onActivityPaused");
    }

    @Override
    public void onActivityStopped(Activity activity) {
        Timber.i(activity + " - onActivityStopped");
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Timber.i(activity + " - onActivitySaveInstanceState");
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        Timber.i(activity + " - onActivityDestroyed");
        //横竖屏切换或配置改变时, Activity 会被重新创建实例, 但 Bundle 中的基础数据会被保存下来,移除该数据是为了保证重新创建的实例可以正常工作
        activity.getIntent().removeExtra("isInitToolbar");
    }
}
