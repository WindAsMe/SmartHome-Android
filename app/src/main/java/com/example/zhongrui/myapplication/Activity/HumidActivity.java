package com.example.zhongrui.myapplication.Activity;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zhongrui.myapplication.R;
import com.example.zhongrui.myapplication.models.HumidModel;
import com.example.zhongrui.myapplication.models.commomModels.HumidDataModel;
import com.example.zhongrui.myapplication.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

public class HumidActivity extends AppCompatActivity {

    // Waiting Adjusting...
    private final static String url = "http://127.0.0.1:8090/";
    private HttpUtil httpUtil = new HttpUtil();
    private Float humid = 54f;
    private String time = "2018年12月31日 15:21:01";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humid);

        final Button button1 = findViewById(R.id.go);
        final Button button2 = findViewById(R.id.back);
        final TextView textView = findViewById(R.id.humid);
        HumidModel model = new HumidModel();
        try {
            // TODO: okHttp GET the Response
            textView.setText("湿度： " + humid + "%                                " + "时间: " + time);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textView.setText("湿度： " + (float)(Math.random() * 100) + "%                               " + "时间: " + time);
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
