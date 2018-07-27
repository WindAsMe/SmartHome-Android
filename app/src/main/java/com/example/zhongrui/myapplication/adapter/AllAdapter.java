package com.example.zhongrui.myapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.zhongrui.myapplication.R;
import com.example.zhongrui.myapplication.models.AllModel;
import com.example.zhongrui.myapplication.models.commomModels.AllDataModel;

import java.util.List;

/**
 * Create By WindAsMe on 18-7-27
 * Location: ../Home/AndroidProjects/MyApplication
 **/
public class AllAdapter extends BaseAdapter {

    private List<AllDataModel> mList;
    private LayoutInflater mInflater;

    public AllAdapter(Context context, List<AllDataModel> list) {
        mList = list;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("SetTextI18n")
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item,null);
        }

        // ImageView imageView = convertView.findViewById(R.id.iv_image);
        TextView titleTextView = convertView.findViewById(R.id.tv_title);
        TextView contentTextView = convertView.findViewById(R.id.tv_content);

        AllDataModel model = mList.get(position);

        // imageView.setImageResource(model.getId());
        titleTextView.setText(model.getTemp());
        contentTextView.setText(model.getHumid() + model.getPress() + model.getTime());
        return convertView;
    }
}
