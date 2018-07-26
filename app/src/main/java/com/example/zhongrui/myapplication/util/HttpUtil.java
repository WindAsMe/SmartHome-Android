package com.example.zhongrui.myapplication.util;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtil {

    // Waiting Adjusting...
    private final static String url = "http://127.0.0.1:8090/";

    public void HttpGet(final String s) {
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
                    String s = response.body().string();
                    System.out.println(s);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("Exception");
                }
            }
        }).start();
    }
}
