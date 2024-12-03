package com.example.demo;

public class User {
    private static User currentUser;

    private int ID;
    private String Hoten;
    private String username;
    private String password;
    private String sodt;
    private String CCCD;
    private String DiaChi;


    public User (int ID, String Hoten, String username, String password, String sodt, String CCCD, String DiaChi) {
        this.ID = ID;
        this.Hoten = Hoten;
        this.username = username;
        this.password = password;
        this.sodt = sodt;
        this.CCCD = CCCD;
        this.DiaChi = DiaChi;
    }

    public User () {
        this.Hoten = Hoten;
        this.username = username;
        this.password = password;
        this.sodt = sodt;
        this.CCCD = CCCD;
        this.DiaChi = DiaChi;
    }

    public int getID() {
        return ID;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String hoten) {
        Hoten = hoten;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User user) {
        currentUser = user;
    }


}
