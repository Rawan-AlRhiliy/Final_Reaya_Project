package com.example.reaya_project;

public class AppointmentsReservationModel {

    private String serName;
    private int detail;

    // Constructor
    public AppointmentsReservationModel(String serName, int detail) {
        this.serName = serName;
        this.detail = detail;
    }

    // Getter and Setter
    public String getserName() {
        return serName;
    }

    public void setserName(String serName) {
        this.serName = serName;
    }


    public int getdetail() {
        return detail;
    }

    public void setdetail(int detail) {
        this.detail = detail;
    }
}

