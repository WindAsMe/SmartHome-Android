package com.example.zhongrui.myapplication.Activity;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.example.zhongrui.myapplication.R;
import com.example.zhongrui.myapplication.adapter.AllAdapter;
import com.example.zhongrui.myapplication.models.AllModel;
import com.example.zhongrui.myapplication.models.commomModels.AllDataModel;
import com.example.zhongrui.myapplication.models.commomModels.MetaModel;
import com.example.zhongrui.myapplication.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

public class AllActivity extends AppCompatActivity {

    private HttpUtil httpUtil = new HttpUtil();
    private String time = "2018年12月31日 15:21:01";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        final Button button1 = findViewById(R.id.go);
        final Button button2 = findViewById(R.id.back);
        final TextView textView = findViewById(R.id.all);

        try {
            String json = "{\n" +
                    "    \"meta\": {\n" +
                    "        \"code\": 0,\n" +
                    "        \"errorMsg\": null\n" +
                    "    },\n" +
                    "    \"data\": {\n" +
                    "        \"temp\": \"30.0\",\n" +
                    "        \"humid\": \"88.0\",\n" +
                    "        \"time\": \"2018-07-29 10:53:20\",\n" +
                    "        \"press\": \"0.99\"\n" +
                    "    }\n" +
                    "}";


            JSONObject meta = JSONObject.parseObject(json).getJSONObject("meta");
            if (Integer.valueOf(0).equals(meta.get("code"))) {
                JSONObject data = JSONObject.parseObject(json).getJSONObject("data");
                textView.setText("温度: " + data.get("temp") + "°C                                "
                        + "湿度: " + data.get("humid")  + "%                                "
                        + "气压: " + data.get("press")  + "Pa                                "
                        + "时间: " + data.get("time") );
            }

            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textView.setText("温度: " + (float)(Math.random() * 35) + "°C                                "
                            + "湿度: " + (float)(Math.random() * 100) + "%                                "
                            + "气压: " + (float)(Math.random() * 2) + "Pa                                "
                            + "时间: " + time);
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
