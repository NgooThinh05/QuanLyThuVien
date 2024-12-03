package com.example.demo;

public class Borrow {
    private String id;
    private String ISBN;
    private int sl;
    private String dateborrowed;
    private String datereturned;
    private String CCCD;
    private String status;

    public Borrow(String id,String ISBN,int sl,String dateborrowed,String datereturned,String CCCD,String status ) {
        this.id = id;
        this.ISBN = ISBN;
        this.sl = sl;
        this.dateborrowed = dateborrowed;
        this.datereturned = datereturned;
        this.CCCD = CCCD;
        this.status = status;
    }

    public Borrow() {
        this.ISBN = ISBN;
        this.sl = sl;
        this.dateborrowed = dateborrowed;
        this.datereturned = datereturned;
        this.CCCD = CCCD;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public String getDateborrowed() {
        return dateborrowed;
    }

    public void setDateborrowed(String dateborrowed) {
        this.dateborrowed = dateborrowed;
    }

    public String getDatereturned() {
        return datereturned;
    }

    public void setDatereturned(String datereturned) {
        this.datereturned = datereturned;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
