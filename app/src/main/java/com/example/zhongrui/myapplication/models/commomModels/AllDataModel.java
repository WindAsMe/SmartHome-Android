package com.example.zhongrui.myapplication.models.commomModels;

/**
 * Create By WindAsMe on 18-7-27
 * Location: ../Home/AndroidProjects/MyApplication
 **/
public class AllDataModel {

    private String temp;
    private String humid;
    private String press;
    private String time;

    public AllDataModel() {
    }

    public AllDataModel(String temp, String humid, String press, String time) {
        this.temp = temp;
        this.humid = humid;
        this.press = press;
        this.time = time;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHumid() {
        return humid;
    }

    public void setHumid(String humid) {
        this.humid = humid;
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
        return "AllDataModel{" +
                "temp='" + temp + '\'' +
                ", humid='" + humid + '\'' +
                ", press='" + press + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
