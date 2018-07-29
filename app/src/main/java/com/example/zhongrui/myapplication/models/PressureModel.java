package com.example.zhongrui.myapplication.models;

import com.example.zhongrui.myapplication.models.commomModels.MetaModel;
import com.example.zhongrui.myapplication.models.commomModels.PressureDataModel;

public class PressureModel {

    private MetaModel meta;
    private PressureDataModel dataModel;

    public PressureModel() {
    }

    public PressureModel( MetaModel meta, PressureDataModel dataModel) {
        this.meta = meta;
        this.dataModel = dataModel;
    }

    public MetaModel getMeta() {
        return meta;
    }

    public void setMeta(MetaModel meta) {
        this.meta = meta;
    }

    public PressureDataModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(PressureDataModel dataModel) {
        this.dataModel = dataModel;
    }

    @Override
    public String toString() {
        return "PressureModel{" +
                ", meta=" + meta.toString() +
                ", dataModel=" + dataModel.toString() +
                '}';
    }
}
