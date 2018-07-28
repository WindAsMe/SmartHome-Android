package com.example.zhongrui.myapplication.Activity;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhongrui.myapplication.R;
import com.example.zhongrui.myapplication.adapter.HumidAdapter;
import com.example.zhongrui.myapplication.models.HumidModel;
import com.example.zhongrui.myapplication.models.commomModels.HumidDataModel;
import com.example.zhongrui.myapplication.models.commomModels.MetaModel;
import com.example.zhongrui.myapplication.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
public class HumidActivity extends AppCompatActivity {

    // Waiting Adjusting...
    private final static String url = "http://127.0.0.1:8090/";
    private static OkHttpClient client = new OkHttpClient();
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
        List<HumidDataModel> list = new ArrayList<>();
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





//            List<HumidModel> models = new ArrayList<>();
//            for (int i = 0; i < 20; i++) {
//                MetaModel metaModel = new MetaModel(0, null);
//                HumidDataModel dataModel = new HumidDataModel("humid: 1", "2016-07-27 14:29:56");
//                models.add(new HumidModel(i, metaModel, dataModel));
//            }
//            listView = findViewById(R.id.listView);
//            listView.setAdapter(new HumidAdapter(this, models));




//            String response = httpUtil.HttpGet("humid");
//            JSONArray array = new JSONArray(response);
//            for (int i = 0; i < array.length(); i++) {
//                JSONObject object = (JSONObject) array.get(i);

//            HumidModel model = new HumidModel();
//            model.setMeta((MetaModel) object.get("meta"));
//            if (model.getMeta().getCode() != 0)
//                break;
//            model.setDataModel((HumidDataModel) object.get("data"));
//            Log.d("object ",model.toString());
//            list.add(new HumidDataModel("湿度" + model.getDataModel().getHumid(), "时间"+model.getDataModel().toString()));
//            listView = findViewById(R.id.listView);
//            listView.setAdapter(new HumidAdapter(this, list));

//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
