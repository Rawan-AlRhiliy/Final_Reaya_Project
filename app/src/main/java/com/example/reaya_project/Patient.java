package com.example.reaya_project;

public class Patient {
    private String name;
    private String email;
    private int phone;
    private String geneder;
    private String birthday;
    private int userid;
    private String city;
    private String address;
    private String password;


    public Patient(){}
    public Patient(String name,String email,int phone,String geneder,String birthday,int userid,String city,String address,String password){
        this.name=name;
        this.email=email;
        this.phone=phone;
        this.geneder=geneder;
        this.birthday=birthday;
        this.userid=userid;
        this.city=city;
        this.address=address;
        this.password=password;

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setGeneder(String geneder) {
        this.geneder = geneder;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }

    public String getGeneder() {
        return geneder;
    }

    public String getBirthday() {
        return birthday;
    }

    public int getUserid() {
        return userid;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
