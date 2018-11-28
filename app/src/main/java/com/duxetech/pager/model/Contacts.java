package com.duxetech.pager.model;

/**
 * Created by Karthik Swamy on 27-11-2018.
 */
public class Contacts {


    String first_name, last_name, mail, mobile, address;
    public Contacts() {
    }
    public Contacts(String first_name, String last_name, String mobile, String mail,String address){
        this.first_name = first_name;
        this.last_name = last_name;
        this.mobile = mobile;
        this.mail = mail;
        this.address = address;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
