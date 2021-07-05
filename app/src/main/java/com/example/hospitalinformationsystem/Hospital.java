package com.example.hospitalinformationsystem;

public class Hospital {
    int logo;
    String HospName;
    String Address;
    String amtbed;
    String amtoxy;
    String amtamb;

    public Hospital(int logo, String hospName, String address, String amtbed, String amtoxy, String amtamb) {
        this.logo = logo;
        HospName = hospName;
        Address = address;
        this.amtbed = amtbed;
        this.amtoxy = amtoxy;
        this.amtamb = amtamb;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getHospName() {
        return HospName;
    }

    public void setHospName(String hospName) {
        HospName = hospName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getAmtbed() {
        return amtbed;
    }

    public void setAmtbed(String amtbed) {
        this.amtbed = amtbed;
    }

    public String getAmtoxy() {
        return amtoxy;
    }

    public void setAmtoxy(String amtoxy) {
        this.amtoxy = amtoxy;
    }

    public String getAmtamb() {
        return amtamb;
    }

    public void setAmtamb(String amtamb) {
        this.amtamb = amtamb;
    }
}

