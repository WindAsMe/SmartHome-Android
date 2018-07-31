package com.example.zhongrui.myapplication.models;

import com.example.zhongrui.myapplication.models.commomModels.MetaModel;
import com.example.zhongrui.myapplication.models.commomModels.PressDataModel;

public class PressureModel {

    private MetaModel meta;
    private PressDataModel pressDataModelModel;

    public PressureModel() {
    }

    public PressureModel( MetaModel meta, PressDataModel pressDataModelModel) {
        this.meta = meta;
        this.pressDataModelModel = pressDataModelModel;
    }

    public MetaModel getMeta() {
        return meta;
    }

    public void setMeta(MetaModel meta) {
        this.meta = meta;
    }

    public PressDataModel getPressDataModelModel() {
        return pressDataModelModel;
    }

    public void setPressDataModelModel(PressDataModel pressDataModelModel) {
        this.pressDataModelModel = pressDataModelModel;
    }

    @Override
    public String toString() {
        return "PressureModel{" +
                ", meta=" + meta.toString() +
                ", pressDataModelModel=" + pressDataModelModel.toString() +
                '}';
    }
}
