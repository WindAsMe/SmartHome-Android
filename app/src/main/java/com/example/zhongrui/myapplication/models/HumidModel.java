package com.example.zhongrui.myapplication.models;

import com.example.zhongrui.myapplication.models.commomModels.HumidDataModel;
import com.example.zhongrui.myapplication.models.commomModels.MetaModel;

public class HumidModel {

    private MetaModel meta;
    private HumidDataModel data;

    public HumidModel() {
    }

    public HumidModel(MetaModel meta, HumidDataModel data) {
        this.meta = meta;
        this.data = data;
    }
    public MetaModel getMeta() {
        return meta;
    }

    public void setMeta(MetaModel meta) {
        this.meta = meta;
    }

    public HumidDataModel getDataModel() {
        return data;
    }

    public void setDataModel(HumidDataModel data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HumidModel{" +
                "meta=" + meta +
                ", data=" + data +
                '}';
    }
}

