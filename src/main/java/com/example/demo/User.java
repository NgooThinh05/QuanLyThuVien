package com.example.demo;



public class User extends Person {
    private String DiaChi;
    private String gt;
    private String birthday;


    public User (int ID, String Hoten, String gt, String birthday, String sodt, String CCCD, String DiaChi) {
        super(ID, Hoten, sodt, CCCD);
        this.gt = gt;
        this.birthday = birthday;
        this.DiaChi = DiaChi;
    }

    public User () {
        super();
    }

    public String getGt() {
        return gt;
    }

    public void setGt(String gt) {
        this.gt = gt;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }




}
