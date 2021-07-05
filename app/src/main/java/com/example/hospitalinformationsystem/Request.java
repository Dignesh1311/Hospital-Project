package com.example.hospitalinformationsystem;

import java.util.List;

public class Request {
    String date;
    String pname;
    String reqtype;
    String status;

    public Request(String date, String pname, String reqtype, String status) {
        this.date = date;
        this.pname = pname;
        this.reqtype = reqtype;
        this.status = status;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getReqtype() {
        return reqtype;
    }

    public void setReqtype(String reqtype) {
        this.reqtype = reqtype;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

