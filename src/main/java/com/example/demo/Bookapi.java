package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;


public class Bookapi extends Node {

    @FXML
    private Label author;

    @FXML
    private ImageView imageview;

    @FXML
    private Label namebook;
    private Book book;

    @FXML
    private Button chitiet;


    public void setData(Book book) {
        this.book = book;
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
        this.book = book;
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

    public void chitiet(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("bookdetail.fxml"));
            Parent root = loader.load();
            Bookdetail controller = loader.getController();
            controller.bookdetail(book);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println("Error loading detailed view: " + e.getMessage());
            e.printStackTrace();
        }
    }


}
