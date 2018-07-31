package com.example.zhongrui.myapplication.models;

import com.example.zhongrui.myapplication.models.commomModels.MetaModel;
import com.example.zhongrui.myapplication.models.commomModels.TempDataModel;

public class TempModel {

    private MetaModel meta;
    private TempDataModel dataModel;

    public TempModel() {
    }

    public TempModel( MetaModel meta, TempDataModel dataModel) {
        this.meta = meta;
        this.dataModel = dataModel;
    }

    public MetaModel getMeta() {
        return meta;
    }

    public void setMeta(MetaModel meta) {
        this.meta = meta;
    }

    public TempDataModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(TempDataModel dataModel) {
        this.dataModel = dataModel;
    }

    @Override
    public String toString() {
        return "TempModel{" +
                ", meta=" + meta.toString() +
                ", dataModel=" + dataModel.toString() +
                '}';
    }
}
