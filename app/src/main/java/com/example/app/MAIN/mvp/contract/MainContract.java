package com.example.app.MAIN.mvp.contract;

import com.example.app.common.model.bean.response.MainRsp;
import com.jess.arms.mvp.IView;
import com.jess.arms.mvp.IModel;

import java.util.function.DoubleUnaryOperator;

import io.reactivex.Observable;


/**
 * ================================================
 * Date: 05/20/2020 14:16
 * Description:
 * ================================================
 */
public interface MainContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {

        void loadDataSuccess(MainRsp data);
    }

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,即是否使用缓存
    interface Model extends IModel {
        Observable<MainRsp> loadData(String data);
    }
}
