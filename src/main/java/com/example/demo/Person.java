package com.example.demo;

public class Person {
    protected int ID;
    protected String Hoten;
    protected String sodt;
    protected String CCCD;

    Person(int ID, String Hoten, String sodt, String CCCD) {
        this.ID = ID;
        this.Hoten = Hoten;
        this.sodt = sodt;
        this.CCCD = CCCD;
    }

    Person() {}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String hoten) {
        Hoten = hoten;
    }

    public String getSodt() {
        return sodt;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

}
