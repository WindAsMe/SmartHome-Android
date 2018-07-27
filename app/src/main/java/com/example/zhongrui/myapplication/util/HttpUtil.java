package com.example.zhongrui.myapplication.util;


import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtil {

    // Waiting Adjusting...
    private final static String url = "http://127.0.0.1:8090/";

    public String HttpGet(final String s) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(url + s)
                        .build();
                System.out.println(request.toString());
                try {
                    Response response = client.newCall(request).execute();
                    if (response.isSuccessful()) {
                        String s = response.body().string();
                        Log.i("Response ", s);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return s;
    }
}
