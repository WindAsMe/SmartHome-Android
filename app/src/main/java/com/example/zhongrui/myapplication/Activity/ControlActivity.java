package com.example.zhongrui.myapplication.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.zhongrui.myapplication.R;
import com.example.zhongrui.myapplication.util.HttpUtil;

import org.json.JSONException;

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
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("invoke onClick {}", "AirOnActivity.class");
                try {
                    HttpUtil.HomeControl(view, 1);
                } catch (Exception e) {
                    Log.v("Exception", e.getMessage());
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("invoke onClick {}", "AirOffActivity.class");
                try {
                    HttpUtil.HomeControl(view, 2);
                } catch (Exception e) {
                    Log.v("Exception", e.getMessage());
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("invoke onClick {}", "LightOnActivity.class");
                try {
                    HttpUtil.HomeControl(view, 3);
                } catch (Exception e) {
                    Log.v("Exception", e.getMessage());
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("invoke onClick {}", "LightOffActivity.class");
                try {
                    HttpUtil.HomeControl(view, 4);
                } catch (Exception e) {
                    Log.v("Exception", e.getMessage());
                }
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
