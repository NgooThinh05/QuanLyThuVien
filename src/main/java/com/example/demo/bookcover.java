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


import java.io.IOException;


public class BookCover extends Node {

    @FXML
    private Label author;

    @FXML
    private ImageView imageview;

    @FXML
    private Label namebook;
    private Book book;


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


    public void setDataApi(Book book) {
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

    public void addbookbutton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("addbookapi.fxml"));
            Parent root1 = loader.load();
            Addbookapi controller = loader.getController();
            controller.addbookapi(book);
            Scene scene = new Scene(root1);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println("Error loading detailed view: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void delebookbutton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("delebook.fxml"));
            Parent root = loader.load();
            Addbookapi controller = loader.getController(); // Nếu là Addbookapi
            controller.addbookapi(book); // Gọi phương thức tương ứng
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
