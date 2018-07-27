package com.example.zhongrui.myapplication.models.commomModels;

/**
 * Create By WindAsMe on 18-7-27
 * Location: ../Home/AndroidProjects/MyApplication
 **/
public class TempDataModel {

    private String temp;
    private String time;

    public TempDataModel() {
    }

    public TempDataModel(String temp, String time) {
        this.temp = temp;
        this.time = time;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "TempDataModel{" +
                "temp='" + temp + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
