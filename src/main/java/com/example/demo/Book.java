package com.example.demo;

public class Book {
    private String ISBN;
    private String Title;
    private String Author;
    private String Publisher;
    private String theloai;
    private String  mota;
    private String ngonngu;
    private String image;
    private String rivew;
    private int soluong;


    public Book (String ISBN, String Title, String Author, String Publisher, String theloai, String mota, String ngonngu, String image, String rivew ) {
        this.ISBN = ISBN;
        this.Title = Title;
        this.Author = Author;
        this.Publisher = Publisher;
        this.theloai = theloai;
        this.mota = mota;
        this.ngonngu = ngonngu;
        this.image = image;
        this.rivew = rivew;
    }

    public Book (String ISBN, String Title, String Author, String Publisher, String theloai, String mota, String ngonngu, String image, String rivew, int soluong ) {
        this.ISBN = ISBN;
        this.Title = Title;
        this.Author = Author;
        this.Publisher = Publisher;
        this.theloai = theloai;
        this.mota = mota;
        this.ngonngu = ngonngu;
        this.image = image;
        this.rivew = rivew;
        this.soluong = soluong;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getRivew() {
        return rivew;
    }

    public void setRivew(String rivew) {
        this.rivew = rivew;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public String getNgonngu() {
        return ngonngu;
    }

    public void setNgonngu(String ngonngu) {
        this.ngonngu = ngonngu;
    }
}
