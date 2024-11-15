package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.io.File;
import java.io.IOException;



public class Bookapi extends Node {

    @FXML
    private Label author;

    @FXML
    private ImageView imageview;

    @FXML
    private Label namebook;
    private Book currentBook;

    @FXML
    private Button chitiet;


   public void setData(Book book) {
        this.currentBook = book;
        namebook.setText(book.getTitle());
        author.setText(book.getAuthor());
        if (book.getImage() != null) {
            imageview.setImage(new Image(book.getImage()));
        } else {
            imageview.setImage(new Image(getClass().getResourceAsStream("/image/logo.png")));
        }
    }


    public void setDataAll(Book book) {
        this.currentBook = book;
        namebook.setText(book.getTitle());
        author.setText(book.getAuthor());
        try {
            if (book.getImage() != null) {
                imageview.setImage(new Image(book.getImage()));
            } else {
                imageview.setImage(new Image(getClass().getResourceAsStream("/image/logo.png")));
            }
        } catch (Exception e) {
            imageview.setImage(new Image(getClass().getResourceAsStream("/image/logo.png")));
        }
    }


}
