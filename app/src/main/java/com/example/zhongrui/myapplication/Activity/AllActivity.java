package com.example.zhongrui.myapplication.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

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
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        final Button button1 = findViewById(R.id.go);
        final Button button2 = findViewById(R.id.back);
        listView = findViewById(R.id.listView);

        List<AllDataModel> list = new ArrayList<>();
        try {
            List<AllDataModel> models = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                models.add(new AllDataModel("temp: 12", "humid: 12", "pressure: 12", "2015-07-27 14:29:56"));
            }
            listView = findViewById(R.id.listView);
            listView.setAdapter(new AllAdapter(this, models));
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
