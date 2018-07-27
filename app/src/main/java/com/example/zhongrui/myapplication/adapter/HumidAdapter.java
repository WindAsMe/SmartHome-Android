package com.example.zhongrui.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.zhongrui.myapplication.R;
import com.example.zhongrui.myapplication.models.HumidModel;

import java.util.List;

/**
 * Create By WindAsMe on 18-7-27
 * Location: ../Home/AndroidProjects/MyApplication
 **/
public class HumidAdapter extends BaseAdapter {

    private List<HumidModel> mList;
    private LayoutInflater mInflater;

    public HumidAdapter(Context context, List<HumidModel> list) {
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

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item,null);
        }

        // ImageView imageView = convertView.findViewById(R.id.iv_image);
        TextView titleTextView = convertView.findViewById(R.id.tv_title);
        TextView contentTextView = convertView.findViewById(R.id.tv_content);

        HumidModel model = mList.get(position);

        // imageView.setImageResource(model.getId());
        titleTextView.setText(model.getDataModel().getHumid());
        contentTextView.setText(model.getDataModel().getTime());
        return convertView;
    }
}
