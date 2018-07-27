package com.example.zhongrui.myapplication.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.zhongrui.myapplication.R;
import com.example.zhongrui.myapplication.adapter.PressureAdapter;
import com.example.zhongrui.myapplication.models.PressureModel;
import com.example.zhongrui.myapplication.models.commomModels.MetaModel;
import com.example.zhongrui.myapplication.models.commomModels.PressureDataModel;
import com.example.zhongrui.myapplication.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

public class PressActivity extends AppCompatActivity {

    private HttpUtil httpUtil = new HttpUtil();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_press);

        final Button button = findViewById(R.id.back);
        listView = findViewById(R.id.listView);

        List<PressureDataModel> list = new ArrayList<>();
        try {
            List<PressureModel> models = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                MetaModel metaModel = new MetaModel(0, null);
                PressureDataModel dataModel = new PressureDataModel("10", "2017-07-27 14:29:56");
                models.add(new PressureModel(i, metaModel, dataModel));
            }
            listView = findViewById(R.id.listView);
            listView.setAdapter(new PressureAdapter(this, models));
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
