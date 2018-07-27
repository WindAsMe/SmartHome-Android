package com.example.zhongrui.myapplication.util;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtil {

    // Waiting Adjusting...
    private final static String url = "http://127.0.0.1:8090/";
    private static OkHttpClient client = new OkHttpClient();

    public static Response HttpGet(final String address) throws Exception {
        Log.v("invoke HttpGet {}", url + address);
        Request request = new Request.Builder()
                .url(url + address)
                .build();
        return client.newCall(request).execute();
    }

    // flag represent the movement:
    // Air on: 1
    // Air off: 2
    // Light on: 3
    // Light off: 4
    public static void HomeControl(final View v, final int flag) throws Exception {
        Log.v("invoke HomeControl {}", url + "home?flag=" + flag);
        new Thread (new Runnable() {
            @Override
            public void run() {
                // subprocess pop Toast needed
                Handler handler = new Handler(Looper.getMainLooper());
                try {
                    Request request = new Request.Builder()
                            .url(url + "home?flag=" + flag)
                            .build();
                    Boolean tip = client.newCall(request).execute().isSuccessful();
                    if (tip && flag == 1) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(v.getContext(),
                                        "空调已打开！", Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else if (tip && flag == 2) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(v.getContext(),
                                        "空调已关闭！", Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else if (tip && flag == 3) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(v.getContext(),
                                        "灯已打开！", Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else if (tip && flag == 4) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(v.getContext(),
                                        "灯已关闭！", Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(v.getContext(),
                                        "网络错误,请稍候再试", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                } catch (IOException e) {
                    Log.v("Exception", e.getMessage());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(v.getContext(),
                                    "网络错误,请稍候再试",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        }).start();
    }
}
