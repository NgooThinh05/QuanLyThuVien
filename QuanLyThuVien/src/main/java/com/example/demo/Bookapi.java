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

       String imagePath = book.getImage();
       try {
           if (imagePath != null && !imagePath.isEmpty()) {
               imageview.setImage(new Image(imagePath));
           } else {
               imageview.setImage(new Image(getClass().getResourceAsStream("/Image/logo.png")));
           }
       } catch (Exception e) {
           imageview.setImage(new Image(getClass().getResourceAsStream("/Image/logo.png")));
           System.out.println("Error loading image: " + e.getMessage());
       }
    }


    public void setDataAll(Book book) {
        this.currentBook = book;
        namebook.setText(book.getTitle());
        author.setText(book.getAuthor());
        String imagePath = book.getImage();
        try {
            if (imagePath != null && !imagePath.isEmpty()) {
                imageview.setImage(new Image(imagePath));
            } else {
                imageview.setImage(new Image(getClass().getResourceAsStream("/Image/logo.png")));
            }
        } catch (Exception e) {
            imageview.setImage(new Image(getClass().getResourceAsStream("/Image/logo.png")));
            System.out.println("Error loading image: " + e.getMessage());
        }
    }


}
