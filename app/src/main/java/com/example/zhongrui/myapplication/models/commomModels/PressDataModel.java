package com.example.zhongrui.myapplication.models.commomModels;

/**
 * Create By WindAsMe on 18-7-27
 * Location: ../Home/AndroidProjects/MyApplication
 **/
public class PressDataModel {

    private Integer id;
    private String time;
    private String press;

    public PressDataModel() {
    }

    public PressDataModel(Integer id, String time, String press) {
        this.id = id;
        this.time = time;
        this.press = press;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return "PressDataModel{" +
                "id=" + id +
                ", press='" + press + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
