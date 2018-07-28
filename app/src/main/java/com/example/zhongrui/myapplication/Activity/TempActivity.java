package com.example.zhongrui.myapplication.Activity;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.zhongrui.myapplication.R;
import com.example.zhongrui.myapplication.adapter.TempAdapter;
import com.example.zhongrui.myapplication.models.TempModel;
import com.example.zhongrui.myapplication.models.commomModels.MetaModel;
import com.example.zhongrui.myapplication.models.commomModels.TempDataModel;
import com.example.zhongrui.myapplication.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

public class TempActivity extends AppCompatActivity {

    private HttpUtil httpUtil = new HttpUtil();
    private Float temp =24f;
    private String time = "2018年12月31日 15:21:01";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        final Button button1 = findViewById(R.id.go);
        final Button button2 = findViewById(R.id.back);
        final TextView textView = findViewById(R.id.temp);

        List<TempDataModel> list = new ArrayList<>();
        try {
            // TODO: okHttp GET the Response
            textView.setText("温度： " + temp + "°C                                " + "时间: " + time);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textView.setText("温度： " + (float)(Math.random() * 35) + "°C                                " + "时间: " + time);
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
