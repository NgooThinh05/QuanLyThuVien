package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.sql.SQLException;

public class Addbookapi {
    private Book book;
    @FXML
    private AnchorPane anchorpane1;
    @FXML
    private Text title1;
    @FXML
    private Text author1;
    @FXML
    private Text nxb1;
    @FXML
    private Text describe1;
    @FXML
    private ImageView imagebook1;
    @FXML
    private Text theloai1;
    @FXML
    private Button buttonaccept;
    @FXML
    private TextField sl;
    @FXML
    private Text isbn;
    @FXML
    private Text linkimage;
    @FXML
    private Text linkreview;

    public void addbookapi(Book book) {
        this.book = book;
        isbn.setText(book.getISBN());
        title1.setText(book.getTitle());
        author1.setText(book.getAuthor());
        nxb1.setText(book.getPublisher());
        theloai1.setText(book.getTheloai());
        linkimage.setText(book.getImage());
        linkreview.setText(book.getRivew());

        describe1.setText(book.getMota());

        String imagePath = book.getImage();
        try {
            if (imagePath != null && !imagePath.isEmpty()) {
                imagebook1.setImage(new Image(imagePath));
            } else {
                imagebook1.setImage(new Image(getClass().getResourceAsStream("/Image/logo.png")));
            }
        } catch (Exception e) {
            imagebook1.setImage(new Image(getClass().getResourceAsStream("/Image/logo.png")));
            System.out.println("Error loading image: " + e.getMessage());
        }
    }

    @FXML
    public void buttonaccept(ActionEvent event) throws SQLException {
        Book book = new Book();
        book.setTitle(title1.getText());
        book.setAuthor(author1.getText());
        book.setPublisher(nxb1.getText());
        book.setTheloai(theloai1.getText());
        book.setMota(describe1.getText());
        book.setImage(linkimage.getText());
        book.setISBN(isbn.getText());
        book.setRivew(linkreview.getText());
        int soluong = Integer.parseInt(sl.getText());
        book.setSoluong(soluong);
        DatabaseConnection.addbookdata(book);
    }



}
