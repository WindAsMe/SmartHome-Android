package com.example.zhongrui.myapplication.Activity;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.example.zhongrui.myapplication.R;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ControlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        final Button btn1 = findViewById(R.id.airOn);
        final Button btn2 = findViewById(R.id.airOff);
        final Button btn3 = findViewById(R.id.lightOn);
        final Button btn4 = findViewById(R.id.lightOff);
        final Button btn5 = findViewById(R.id.back);
        final String url = "http://13.67.109.181:8080/man?flag=";
        final OkHttpClient client = new OkHttpClient();
        final Handler handler = new Handler(Looper.getMainLooper());

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("invoke onClick {}", "AirOnActivity.class");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Request request = new Request
                                    .Builder()
                                    .url(url + "1")
                                    .build();
                            Log.v("url {}", url + "1");
                            Response response = client.newCall(request).execute();
                            String s = response.body().string();
                            Log.v("onClick {}", s);
                            JSONObject object = JSONObject.parseObject(s);
                            JSONObject meta = object.getJSONObject("meta");
                            if (response.isSuccessful() && meta.get("code").equals(0)) {
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(ControlActivity.this,
                                                "空调打开成功！", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        } catch (Exception e) {
                            Log.v("Exception", e.getMessage());
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(ControlActivity.this,
                                            "网络错误,请检查网络！", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                }).start();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("invoke onClick {}", "AirOnActivity.class");

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Request request = new Request
                                    .Builder()
                                    .url(url + "2")
                                    .build();
                            Response response = client.newCall(request).execute();
                            Log.v("url {}", url + "2");
                            String s = response.body().string();
                            Log.v("onClick {}", s);
                            JSONObject object = JSONObject.parseObject(s);
                            JSONObject meta = object.getJSONObject("meta");
                            if (response.isSuccessful() && meta.get("code").equals(0)) {
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(ControlActivity.this,
                                                "空调关闭成功！", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        } catch (Exception e) {
                            Log.v("Exception", e.getMessage());
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(ControlActivity.this,
                                            "网络错误,请检查网络！", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                }).start();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("invoke onClick {}", "AirOnActivity.class");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Request request = new Request
                                    .Builder()
                                    .url(url + "3")
                                    .build();
                            Response response = client.newCall(request).execute();
                            Log.v("url {}", url + "3");
                            String s = response.body().string();
                            Log.v("onClick {}", s);
                            JSONObject object = JSONObject.parseObject(s);
                            JSONObject meta = object.getJSONObject("meta");
                            if (response.isSuccessful() && meta.get("code").equals(0)) {
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(ControlActivity.this,
                                                "灯光打开成功！", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        } catch (Exception e) {
                            Log.v("Exception", e.getMessage());
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(ControlActivity.this,
                                            "网络错误,请检查网络！", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                }).start();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("invoke onClick {}", "AirOnActivity.class");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Request request = new Request
                                    .Builder()
                                    .url(url + "4")
                                    .build();
                            Response response = client.newCall(request).execute();
                            Log.v("url {}", url + "4");
                            String s = response.body().string();
                            Log.v("onClick {}", s);
                            JSONObject object = JSONObject.parseObject(s);
                            JSONObject meta = object.getJSONObject("meta");
                            if (response.isSuccessful() && meta.get("code").equals(0)) {
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(ControlActivity.this,
                                                "灯光关闭成功！", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        } catch (Exception e) {
                            Log.v("Exception", e.getMessage());
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(ControlActivity.this,
                                            "网络错误,请检查网络！", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                }).start();
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("invoke onClick {}", "finish");
                finish();
            }
        });
    }
}
