package com.example.app.mvp.ui.activity

import android.content.Intent
import android.os.Bundle
import com.example.app.R

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.example.app.di.component.DaggerKotlinComponent
import com.example.app.di.module.KotlinModule
import com.example.app.mvp.contract.KotlinContract
import com.example.app.mvp.presenter.KotlinPresenter


/**
 * ================================================
 * Date: 01/08/2021 11:08
 * Description:
 * ================================================
 */
/**
 * 如果没presenter
 * 你可以这样写
 *
 * @ActivityScope(請注意命名空間) class NullObjectPresenterByActivity
 * @Inject constructor() : IPresenter {
 * override fun onStart() {
 * }
 *
 * override fun onDestroy() {
 * }
 * }
 */
class KotlinActivity : BaseActivity<KotlinPresenter>(), KotlinContract.View {

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerKotlinComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .kotlinModule(KotlinModule(this))
                .build()
                .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_kotlin //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {

        mPresenter?.login()
    }


    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showMessage(message: String) {
        ArmsUtils.snackbarText(message)
    }

    override fun launchActivity(intent: Intent) {
        ArmsUtils.startActivity(intent)
    }

    override fun killMyself() {
        finish()
    }
}
