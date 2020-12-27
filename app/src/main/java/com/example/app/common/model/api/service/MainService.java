package com.example.app.common.model.api.service;


import com.example.app.common.model.api.Api;
import com.example.app.common.model.bean.entity.UserDetailEntity;
import com.example.app.common.model.bean.request.LoginParams;
import com.example.app.common.model.bean.response.BasicResponseEntity;
import com.example.app.common.model.bean.response.MainRsp;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author gxc
 * @description:
 * @date : 2019/12/20 14:52
 */
public interface MainService {

    @POST(Api.Main_XXX)
    @FormUrlEncoded
    Observable<MainRsp> loadMainData(@Field("phone") String phone);


    @POST(Api.Main_XXX)
    @FormUrlEncoded
    Observable<BasicResponseEntity<UserDetailEntity>> login(@FieldMap Map<String,Object> map);

//    @FormUrlEncoded
//    @POST(Api.Main_XXX)
//    Observable<MainRsp> loadMainData(@FieldMap Map<String,String> maps);

//    @POST(Api.Main_XXX)
//    Observable<MainRsp> loadMainData(@Body RequestBody body);
}
