package com.example.zhongrui.myapplication.Activity;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.example.zhongrui.myapplication.R;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AllActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        final Button button1 = findViewById(R.id.go);
        final Button button2 = findViewById(R.id.back);
        final TextView textView = findViewById(R.id.all);

        // Waiting Adjusting...
        final String url = "http://13.67.109.181:8080/all";
        try {
            final OkHttpClient client = new OkHttpClient();
            new Thread(new Runnable() {
                Handler handler = new Handler(Looper.getMainLooper());
                @Override
                public void run() {
                    try {

                        // Send the Request
                        Request request = new Request
                                .Builder()
                                .url(url)
                                .build();
                        Response response = client.newCall(request).execute();

                        Log.v("invoke url{}", url);
                        String s = response.body().string();
                        JSONObject object = JSONObject.parseObject(s);
                        JSONObject meta = object.getJSONObject("meta");
                        // Success
                        if (Integer.valueOf(0).equals(meta.get("code"))) {
                            final JSONObject data = object.getJSONObject("data");
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    textView.setText("温度: " + data.get("temp") +
                                            "°C                                " +
                                            "湿度: " + data.get("humid") +
                                            "Pa                                " +
                                            "气压: " + data.get("press") +
                                            "Pa                                " +
                                            "时间: " + data.get("time"));
                                }
                            });
                        } else {
                            Log.v("invoke Toast{}", meta.toString());
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(AllActivity.this,
                                            "请求失败, 请稍后重试！", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    } catch (IOException e) {
                        Log.v("Exception", e.getMessage());
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(AllActivity.this,
                                        "网络异常,请检查网络！", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
            }).start();


            // TODO: okHttp GET the Response
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    new Thread(new Runnable() {
                        // subprocess pop Toast needed
                        Handler handler = new Handler(Looper.getMainLooper());
                        @Override
                        public void run() {
                            try {
                                // Send the Request
                                // url is adjustment needed
                                Request request = new Request.Builder().url(url).build();
                                Log.v("invoke url{}", url);
                                Response response = client.newCall(request).execute();
                                String s = response.body().string();

                                JSONObject object = JSONObject.parseObject(s);
                                JSONObject meta = object.getJSONObject("meta");

                                // Success
                                if (Integer.valueOf(0).equals(meta.get("code"))) {
                                    final JSONObject data = object.getJSONObject("data");
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            textView.setText("温度: " + data.get("temp") +
                                                    "°C                                " +
                                                    "湿度: " + data.get("humid") +
                                                    "Pa                                " +
                                                    "气压: " + data.get("press") +
                                                    "Pa                                " +
                                                    "时间: " + data.get("time"));
                                        }
                                    });
                                } else {
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(view.getContext(),
                                                    "请求失败, 请稍后重试！", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            } catch (IOException e) {
                                Log.v("Exception", e.getMessage());
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(view.getContext(),
                                                "网络异常,请检查网络！", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }
                    }).start();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
