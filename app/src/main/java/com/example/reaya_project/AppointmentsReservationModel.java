package com.example.reaya_project;

public class AppointmentsReservationModel {

    private String serName;
    private String appointments_number;
    private int detail;

    // Constructor
    public AppointmentsReservationModel(String serName, String appointments_number, int detail) {
        this.serName = serName;
        this.appointments_number = appointments_number;
        this.detail = detail;

    }

    // Getter and Setter
    public String getserName() {
        return serName;
    }
    public void setserName(String serName) {
        this.serName = serName;
    }

    public String getappointments_number() {
        return appointments_number;
    }
    public void setappointments_number(String appointments_number) {
        this.appointments_number = appointments_number;
    }

    public int getdetail() {
        return detail;
    }
    public void setdetail(int detail) {
        this.detail = detail;
    }
}

