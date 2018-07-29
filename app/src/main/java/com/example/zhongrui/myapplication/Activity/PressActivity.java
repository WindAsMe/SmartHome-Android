package com.example.zhongrui.myapplication.Activity;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.zhongrui.myapplication.R;
import com.example.zhongrui.myapplication.models.PressureModel;
import com.example.zhongrui.myapplication.models.commomModels.PressureDataModel;
import com.example.zhongrui.myapplication.util.HttpUtil;


public class PressActivity extends AppCompatActivity {

    private HttpUtil httpUtil = new HttpUtil();
    private Float press = 1f;
    private String time = "2018年12月31日 15:21:01";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_press);

        final Button button1 = findViewById(R.id.go);
        final Button button2 = findViewById(R.id.back);
        final TextView textView = findViewById(R.id.press);

        try {
            String json = "{\n" +
                    "    \"meta\": {\n" +
                    "        \"code\": 0,\n" +
                    "        \"errorMsg\": null\n" +
                    "    },\n" +
                    "    \"data\": {\n" +
                    "        \"id\": \"6\",\n" +
                    "        \"press\": \"1.01\",\n" +
                    "        \"time\": \"2018-07-29 10:53:19\"\n" +
                    "    }\n" +
                    "}";
            JSONObject meta = JSONObject.parseObject(json).getJSONObject("meta");
            if (Integer.valueOf(0).equals(meta.get("code"))) {
                JSONObject data = JSONObject.parseObject(json).getJSONObject("data");
                textView.setText("气压： " + data.get("press") + "Pa                               " + "时间: " + data.get("time"));
            }



            // TODO: okHttp GET the Response
            // textView.setText("气压： " + press + "Pa                               " + "时间: " + time);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textView.setText("气压： " + (float)(Math.random() * 2) + "Pa                               " + "时间: " + time);
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
