package com.example.app.MAIN.mvp.contract;

import android.content.Context;

import com.example.app.R;
import com.example.app.common.model.bean.entity.UserDetailEntity;
import com.example.app.common.model.bean.response.BasicResponseEntity;
import com.jess.arms.mvp.IView;
import com.jess.arms.mvp.IModel;

import java.util.function.DoubleUnaryOperator;

import io.reactivex.Observable;


/**
 * ================================================
 * Date: 12/20/2020 19:46
 * Description:
 * ================================================
 */
public interface Second_pageContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {

        void loadDataSuccess(UserDetailEntity response);

        Context getContext();
    }

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,即是否使用缓存
    interface Model extends IModel {

        Observable<BasicResponseEntity<UserDetailEntity>> login(String countryCode, String phone, String password);
    }
}
