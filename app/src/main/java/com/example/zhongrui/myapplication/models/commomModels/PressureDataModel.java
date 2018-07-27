package com.example.zhongrui.myapplication.models.commomModels;

/**
 * Create By WindAsMe on 18-7-27
 * Location: ../Home/AndroidProjects/MyApplication
 **/
public class PressureDataModel {

    private String press;
    private String time;

    public PressureDataModel() {
    }

    public PressureDataModel(String press, String time) {
        this.press = press;
        this.time = time;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "PressureDataModel{" +
                "press='" + press + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
