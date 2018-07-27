package com.example.zhongrui.myapplication.models;

import com.example.zhongrui.myapplication.models.commomModels.MetaModel;
import com.example.zhongrui.myapplication.models.commomModels.TempDataModel;

public class TempModel {

    private Integer id;
    private MetaModel meta;
    private TempDataModel dataModel;

    public TempModel() {
    }

    public TempModel(Integer id, MetaModel meta, TempDataModel dataModel) {
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

    public TempDataModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(TempDataModel dataModel) {
        this.dataModel = dataModel;
    }

    @Override
    public String toString() {
        return "TempModel{" +
                "id=" + id +
                ", meta=" + meta.toString() +
                ", dataModel=" + dataModel.toString() +
                '}';
    }
}
