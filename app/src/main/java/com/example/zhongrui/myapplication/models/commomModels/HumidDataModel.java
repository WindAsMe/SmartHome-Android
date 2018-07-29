package com.example.zhongrui.myapplication.models.commomModels;

/**
 * Create By WindAsMe on 18-7-27
 * Location: ../Home/AndroidProjects/MyApplication
 **/
public class HumidDataModel {

    private Integer id;
    private String humid;
    private String time;

    public HumidDataModel() {
    }

    public HumidDataModel(Integer id, String humid, String time) {
        this.id = id;
        this.humid = humid;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHumid() {
        return humid;
    }

    public void setHumid(String humid) {
        this.humid = humid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "HumidDataModel{" +
                "id=" + id +
                ", humid='" + humid + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
