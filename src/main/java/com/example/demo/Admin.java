package com.example.demo;

public class Admin extends Person {
    private static Admin currentadmin;
    private String username;
    private String password;

    public Admin(int ID, String Hoten, String CCCD, String sdt, String username, String password) {
        super(ID, Hoten, CCCD, sdt);
        this.username = username;
        this.password = password;
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

    public static Admin getCurrentadmin() {
        return currentadmin;
    }

    public static void setCurrentadmin(Admin currentadmin) {
        Admin.currentadmin = currentadmin;
    }



}
