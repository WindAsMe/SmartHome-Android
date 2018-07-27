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

        final Button button = findViewById(R.id.back);
        listView = findViewById(R.id.listView);

        List<AllDataModel> list = new ArrayList<>();
        try {
//            String response = httpUtil.HttpGet("humid");
//            JSONArray array = new JSONArray(response);
//            for (int i = 0; i < array.length(); i++) {
//                JSONObject object = (JSONObject) array.get(i);
            List<AllModel> models = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                MetaModel metaModel = new MetaModel(0, null);
                AllDataModel dataModel = new AllDataModel("12", "12", "12", "2015-07-27 14:29:56");
                models.add(new AllModel(i, metaModel, dataModel));
            }
            listView = findViewById(R.id.listView);
            listView.setAdapter(new AllAdapter(this, models));
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
