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
import com.example.zhongrui.myapplication.models.TempModel;
import com.example.zhongrui.myapplication.models.commomModels.TempDataModel;
import com.example.zhongrui.myapplication.util.HttpUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TempActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        final Button button1 = findViewById(R.id.go);
        final Button button2 = findViewById(R.id.back);
        final TextView textView = findViewById(R.id.temp);

        // url is adjustment needed
        final String url = "http://13.76.133.103/temp";

        try {
            final OkHttpClient client = new OkHttpClient();
            new Thread(new Runnable() {
                Handler handler = new Handler(Looper.getMainLooper());
                @Override
                public void run() {
                    try {

                        // Send the Request
                        Request request = new Request.Builder().url(url).build();
                        Response response = client.newCall(request).execute();
                        Log.v("invoke url{}", url);
                        JSONObject meta = JSONObject.parseObject(response.toString()).getJSONObject("meta");

                        // Success
                        if (Integer.valueOf(0).equals(meta.get("code"))) {
                            JSONObject data = JSONObject.parseObject(response.toString()).getJSONObject("data");
                            textView.setText("温度: " + data.get("temp") +
                                    "°C                                " +
                                    "时间: " + data.get("time"));
                        } else {
                            Log.v("invoke Toast{}", meta.toString());
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(TempActivity.this,
                                            "网络异常,请检查网络！", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    } catch (IOException e) {
                        Log.v("Exception", e.getMessage());
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(TempActivity.this,
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
                                JSONObject meta = JSONObject.parseObject(response.toString()).getJSONObject("meta");

                                // Success
                                if (Integer.valueOf(0).equals(meta.get("code"))) {
                                    JSONObject data = JSONObject.parseObject(response.toString()).getJSONObject("data");
                                    textView.setText("温度: " + data.get("temp") +
                                            "°C                                " +
                                            "时间: " + data.get("time"));
                                } else {
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(view.getContext(),
                                                    "网络异常,请检查网络！", Toast.LENGTH_SHORT).show();
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
