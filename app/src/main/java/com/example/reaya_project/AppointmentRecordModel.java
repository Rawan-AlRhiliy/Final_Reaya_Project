package com.example.reaya_project;

public class AppointmentRecordModel {

    private String DrName;
    private String Time;
    private String day;
    private String state;
    private int image_detail;

    // Constructor
    public AppointmentRecordModel(String DrName, String Time,String day,String state, int image_detail) {
        this.DrName = DrName;
        this.Time = Time;
        this.day = day;
        this.state = state;
        this.image_detail = image_detail;
    }

    // Getter and Setter
    public String getDrName() {
        return DrName;
    }

    public void setDrName(String DrName) {
        this.DrName = DrName;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public String getday() {
        return day;
    }

    public void setday(String day) {
        this.day = day;
    }
    public String getstate() {
        return state;
    }

    public void setstate(String state) {
        this.state = state;
    }
    public int getimage_detail() {
        return image_detail;
    }

    public void setimage_detail(int image_detail) {
        this.image_detail = image_detail;
    }
}

