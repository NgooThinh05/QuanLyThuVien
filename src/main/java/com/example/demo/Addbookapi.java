package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.example.demo.User.getCurrentUser;

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
    @FXML
    private Button buttonacceptdele;
    @FXML
    private TextField slmuon;
    @FXML
    private TextField mamuon;
    @FXML
    private DatePicker dateborrow;
    @FXML
    private DatePicker datereturn;

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

    @FXML
    public void buttondeleaccept(ActionEvent event) throws SQLException {
        Book book = new Book();
        book.setTitle(title1.getText());
        book.setAuthor(author1.getText());
        book.setPublisher(nxb1.getText());
        book.setTheloai(theloai1.getText());
        book.setMota(describe1.getText());
        book.setImage(linkimage.getText());
        book.setISBN(isbn.getText());
        book.setRivew(linkreview.getText());
        DatabaseConnection.acceptdelebook(book);
    }

    @FXML
    public void buttonacceptborrow(ActionEvent event) throws SQLException {
        Borrow borrow = new Borrow();
        borrow.setISBN(isbn.getText());
        int soluong = Integer.parseInt(slmuon.getText());
        borrow.setSl(soluong);
        LocalDate borrowDate = dateborrow.getValue();
        if (borrowDate != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            borrow.setDateborrowed(borrowDate.format(formatter));
        }

        LocalDate returnDate = datereturn.getValue();
        if (returnDate != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            borrow.setDatereturned(returnDate.format(formatter));
        }
        borrow.setCCCD(mamuon.getText());
        borrow.setStatus("Dang muon");
        DatabaseConnection.Borrowbook(borrow);

    }

}
