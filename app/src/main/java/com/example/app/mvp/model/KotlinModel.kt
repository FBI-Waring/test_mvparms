package com.example.app.mvp.model

import android.app.Application
import com.google.gson.Gson
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel

import com.jess.arms.di.scope.ActivityScope
import javax.inject.Inject

import com.example.app.mvp.contract.KotlinContract


/**
 * ================================================
 * Date: 01/08/2021 11:08
 * Description:
 * ================================================
 */
@ActivityScope
class KotlinModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), KotlinContract.Model {
    @Inject
    lateinit var mGson: Gson;

    @Inject
    lateinit var mApplication: Application;

    override fun onDestroy() {
        super.onDestroy();
    }
}
