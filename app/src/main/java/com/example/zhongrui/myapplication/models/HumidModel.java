package com.example.zhongrui.myapplication.models;

import com.example.zhongrui.myapplication.models.commomModels.HumidDataModel;
import com.example.zhongrui.myapplication.models.commomModels.MetaModel;

public class HumidModel {

    private Integer id;
    private MetaModel meta;
    private HumidDataModel dataModel;

    public HumidModel() {
    }

    public HumidModel(Integer id, MetaModel meta, HumidDataModel dataModel) {
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

    public HumidDataModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(HumidDataModel dataModel) {
        this.dataModel = dataModel;
    }

    @Override
    public String toString() {
        return "HumidModel{" +
                "id=" + id +
                ", meta=" + meta.toString() +
                ", dataModel=" + dataModel.toString() +
                '}';
    }
}

