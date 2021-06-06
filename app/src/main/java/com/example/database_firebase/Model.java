package com.example.database_firebase;

public class Model {
    String name,mobile,adress,pass;

    public Model() {

    }

    public Model(String name, String mobile, String adress, String pass) {
        this.name = name;
        this.mobile = mobile;
        this.adress = adress;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
