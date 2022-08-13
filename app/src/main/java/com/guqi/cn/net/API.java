package com.guqi.cn.net;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.POST;

import static com.guqi.cn.config.Urls.SHENGXIANGUI;

public interface API {
    @POST("cs/app/azp")
    Call<ResponseBody> getResult();
}
