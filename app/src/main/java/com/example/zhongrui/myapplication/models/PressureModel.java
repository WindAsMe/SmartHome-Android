package com.example.zhongrui.myapplication.models;

import com.example.zhongrui.myapplication.models.commomModels.MetaModel;
import com.example.zhongrui.myapplication.models.commomModels.PressureDataModel;

public class PressureModel {

    private Integer id;
    private MetaModel meta;
    private PressureDataModel dataModel;

    public PressureModel() {
    }

    public PressureModel(Integer id, MetaModel meta, PressureDataModel dataModel) {
        this.id = id;
        this.meta = meta;
        this.dataModel = dataModel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                "id=" + id +
                ", meta=" + meta.toString() +
                ", dataModel=" + dataModel.toString() +
                '}';
    }
}
