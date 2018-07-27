package com.example.zhongrui.myapplication.models.commomModels;

/**
 * Create By WindAsMe on 18-7-27
 * Location: ../Home/AndroidProjects/MyApplication
 **/
public class HumidDataModel {

    private String humid;
    private String time;

    public HumidDataModel() {
    }

    public HumidDataModel(String humid, String time) {
        this.humid = humid;
        this.time = time;
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
                "humid='" + humid + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
