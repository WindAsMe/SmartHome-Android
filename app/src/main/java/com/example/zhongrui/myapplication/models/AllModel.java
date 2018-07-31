package com.example.zhongrui.myapplication.models;

import com.example.zhongrui.myapplication.models.commomModels.AllDataModel;
import com.example.zhongrui.myapplication.models.commomModels.MetaModel;

/**
 * Create By WindAsMe on 18-7-27
 * Location: ../Home/AndroidProjects/MyApplication
 **/
public class AllModel {

    private MetaModel meta;
    private AllDataModel dataModel;

    public AllModel() {
    }

    public AllModel(Integer id, MetaModel meta, AllDataModel dataModel) {
        this.meta = meta;
        this.dataModel = dataModel;
    }

    public MetaModel getMeta() {
        return meta;
    }

    public void setMeta(MetaModel meta) {
        this.meta = meta;
    }

    public AllDataModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(AllDataModel dataModel) {
        this.dataModel = dataModel;
    }

    @Override
    public String toString() {
        return "AllModel{" +
                ", meta=" + meta +
                ", dataModel=" + dataModel +
                '}';
    }
}
