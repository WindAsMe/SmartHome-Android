package com.example.zhongrui.myapplication.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.zhongrui.myapplication.R;
import com.example.zhongrui.myapplication.adapter.HumidAdapter;
import com.example.zhongrui.myapplication.models.HumidModel;
import com.example.zhongrui.myapplication.models.commomModels.HumidDataModel;
import com.example.zhongrui.myapplication.models.commomModels.MetaModel;
import com.example.zhongrui.myapplication.util.HttpUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HumidActivity extends AppCompatActivity {

    private HttpUtil httpUtil = new HttpUtil();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humid);

        final Button button = findViewById(R.id.back);
        listView = findViewById(R.id.listView);

        List<HumidDataModel> list = new ArrayList<>();
        try {
//            String response = httpUtil.HttpGet("humid");
//            JSONArray array = new JSONArray(response);
//            for (int i = 0; i < array.length(); i++) {
//                JSONObject object = (JSONObject) array.get(i);
            List<HumidModel> models = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                MetaModel metaModel = new MetaModel(0, null);
                HumidDataModel dataModel = new HumidDataModel("humid: 1", "2016-07-27 14:29:56");
                models.add(new HumidModel(i, metaModel, dataModel));
            }
            listView = findViewById(R.id.listView);
            listView.setAdapter(new HumidAdapter(this, models));
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
