package com.example.zhongrui.myapplication.Activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zhongrui.myapplication.R;

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
    }
}