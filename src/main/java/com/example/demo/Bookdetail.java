package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Bookdetail {
    private Book book;
    @FXML
    private AnchorPane anchorpanedetail;
    @FXML
    private Text title;
    @FXML
    private Text author;
    @FXML
    private Text nxb;
    @FXML
    private Text describe;
    @FXML
    private ImageView imagebook;
    @FXML
    private Text theloai;


    public void bookdetail(Book book) {
        this.book = book;
        title.setText(book.getTitle());
        author.setText("Author: " + book.getAuthor());
        nxb.setText("Publisher: " + book.getPublisher());
        theloai.setText("Category: " + book.getTheloai());

        describe.setText(book.getMota());

        String imagePath = book.getImage();
        try {
            if (imagePath != null && !imagePath.isEmpty()) {
                imagebook.setImage(new Image(imagePath));
            } else {
                imagebook.setImage(new Image(getClass().getResourceAsStream("/Image/logo.png")));
            }
        } catch (Exception e) {
            imagebook.setImage(new Image(getClass().getResourceAsStream("/Image/logo.png")));
            System.out.println("Error loading image: " + e.getMessage());
        }
    }




}
