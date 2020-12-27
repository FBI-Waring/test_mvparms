package com.example.app.common.model.api;

/**
 * ================================================
 * 存放一些与 API 有关的东西,如请求地址,请求码等
 * <p>
 * Created by MVPArmsTemplate on 12/10/2019 14:09
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public interface Api {
    int SUCCESS_CODE = 0;
    //状态码:成功
    String SUCCESS = "";
    //状态码:失败
    String ERROR = "";

    //服务器
    String APP_DOMAIN = "http://api.test.kongming365.com";

    //模拟访问数据 登录接口
    String Main_XXX = "/api/v1/open/login";
}
