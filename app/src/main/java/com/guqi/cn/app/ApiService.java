package com.guqi.cn.app;

import com.guqi.cn.model.QingQiuModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @POST
    Call<QingQiuModel> createUser(@Body QingQiuModel user);

}
