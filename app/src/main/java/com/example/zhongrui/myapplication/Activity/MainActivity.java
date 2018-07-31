package com.example.zhongrui.myapplication.Activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.zhongrui.myapplication.R;
import com.alibaba.fastjson.*;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnOne = findViewById(R.id.btnOne);
        final Button btnTwo = findViewById(R.id.btnTwo);
        final Button btnThree = findViewById(R.id.btnThree);
        final Button btnFour = findViewById(R.id.btnFour);
        final Button btnFive = findViewById(R.id.btnFive);
        final Button btnSix = findViewById(R.id.btnSix);

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TempActivity.class);
                startActivity(intent);
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HumidActivity.class);
                startActivity(intent);
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PressActivity.class);
                startActivity(intent);
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllActivity.class);
                startActivity(intent);
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ControlActivity.class);
                startActivity(intent);
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PackageManager packageManager = getPackageManager();
                Intent intent = packageManager.getLaunchIntentForPackage("com.realvnc.viewer.android");
                startActivity(intent);
            }
        });

        new Thread(new Runnable() {
            OkHttpClient client = new OkHttpClient();
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5000);
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Request request = new Request
                                            .Builder()
                                            .url("http://13.67.109.181:8080/api/get")
                                            .build();
                                    Log.v("url {} ", request.toString());
                                    Response response = client.newCall(request).execute();
                                    String s = response.body().string();
                                    JSONObject object = JSONObject.parseObject(s);
                                    JSONObject meta = object.getJSONObject("meta");
                                    if (meta.get("code").equals(0)) {
                                        Handler handler = new Handler(Looper.getMainLooper());
                                        handler.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(MainActivity.this,
                                                        "有陌生人闯入了您的家中！", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                        PackageManager packageManager = getPackageManager();
                                        Intent intent = packageManager.getLaunchIntentForPackage("com.realvnc.viewer.android");
                                        startActivity(intent);
                                    }
                                } catch (Exception e) {
                                    Log.v("Exception ", e.getMessage());
                                }
                            }
                        }).start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }




}