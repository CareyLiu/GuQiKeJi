package com.guqi.cn.activity;

import android.app.Activity;

import android.os.Bundle;
import android.util.Log;


import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.guqi.cn.config.Urls;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;


public class NetWorkActivity extends Activity {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Map<String, Object> map = new HashMap<>();
        map.put("code", "100057");
        map.put("key", Urls.key);
        map.put("device_ccid", "aaaaaaaaaaaaaaaa10150018");

        Gson gson = new Gson();
        Log.e("map_data", gson.toJson(map));
        try {
            post(Urls.SHENGXIANGUI, gson.toJson(map));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public void getNet() {

    }


}
