package com.guqi.cn.model;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.guqi.cn.config.callback.AppResponse;
import com.guqi.cn.config.Urls;
import com.guqi.cn.config.callback.JsonCallback;
import com.guqi.cn.net.API;
import com.guqi.cn.net.RetrofitManager;
import com.lzy.okgo.OkGo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;

import static com.guqi.cn.config.Urls.SHENGXIANGUI;

public class DemoModelClick {
    private Context context;

    public DemoModelClick(Context context) {
        this.context = context;
    }

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();

    public void bttonClick(View view) {
        Toast.makeText(context, "这个被点击了", Toast.LENGTH_SHORT).show();
    }

    public void postOk(View view) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                Map<String, Object> map = new HashMap<>();
//                map.put("code", "100057");
//                map.put("key", Urls.key);
//                map.put("device_ccid", "aaaaaaaaaaaaaaaa10150018");
//
//                Gson gson = new Gson();
//                Log.e("map_data", gson.toJson(map));
//                try {
//                    post(Urls.SHENGXIANGUI, gson.toJson(map));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }).start();

        getNetJiaQian();
    }

    public void getNetJiaQian_Retrofit() {
        API api = RetrofitManager.getRetrofit().create(API.class);
        Map<String, Object> map = new HashMap<>();
        map.put("code", "100057");
        map.put("key", Urls.key);
        map.put("device_ccid", "aaaaaaaaaaaaaaaa10150018");
      //  Call<ResponseBody> responseCall = api.getResult();
//        responseCall.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//
//            }
//        });
    }

    private void getNetJiaQian() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", "100057");
        map.put("key", Urls.key);
        map.put("device_ccid", "aaaaaaaaaaaaaaaa10150018");

        Gson gson = new Gson();
        Log.e("map_data", gson.toJson(map));
        OkGo.<AppResponse<ShangPinJieKouModel.DataBean>>post(SHENGXIANGUI)
                .tag(this)//
                .upJson(gson.toJson(map))
                .execute(new JsonCallback<AppResponse<ShangPinJieKouModel.DataBean>>() {
                    @Override
                    public void onSuccess(com.lzy.okgo.model.Response<AppResponse<ShangPinJieKouModel.DataBean>> response) {

                    }

                    @Override
                    public void onError(com.lzy.okgo.model.Response<AppResponse<ShangPinJieKouModel.DataBean>> response) {
                        super.onError(response);
                        Log.i("DemoModelClick", response.getException().getMessage());
                    }
                });
    }

    public void post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        final Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();


        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                Log.i("NETLOG", response.body().string());
            }
        });
    }
}
