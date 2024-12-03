package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null); // Không có tiêu đề phụ
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void buttonaccept(ActionEvent event) throws SQLException {
        try {
            // Tạo đối tượng Book và thiết lập các thuộc tính
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
            showAlert(Alert.AlertType.INFORMATION, "Success", "The book has been added successfully!");
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Invalid input for quantity. Please enter a valid number.");
        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Database Error", "Failed to add the book: " + e.getMessage());
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Unexpected Error", "An unexpected error occurred: " + e.getMessage());
        }
    }

    @FXML
    public void buttondeleaccept(ActionEvent event) throws SQLException {
        try {

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
            showAlert(Alert.AlertType.INFORMATION, "Success", "The book has been deleted successfully!");
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Unexpected Error", "An unexpected error occurred: " + e.getMessage());
        }
    }

    @FXML
    public void buttonacceptborrow(ActionEvent event) throws SQLException {
        try {
            Borrow borrow = new Borrow();
            String isbnValue = isbn.getText();
            borrow.setISBN(isbnValue);

            int soluong;
            try {
                soluong = Integer.parseInt(slmuon.getText());
                if (soluong <= 0) {
                    showAlert(Alert.AlertType.WARNING, "Input Error", "Quantity must be greater than 0!");
                    return;
                }
            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Input Error", "Invalid quantity! Please enter a valid number.");
                return;
            }
            borrow.setSl(soluong);

            LocalDate borrowDate = dateborrow.getValue();
            if (borrowDate == null) {
                showAlert(Alert.AlertType.WARNING, "Input Error", "Borrow date cannot be empty!");
                return;
            }
            borrow.setDateborrowed(borrowDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

            LocalDate returnDate = datereturn.getValue();
            if (returnDate == null) {
                showAlert(Alert.AlertType.WARNING, "Input Error", "Return date cannot be empty!");
                return;
            }
            if (returnDate.isBefore(borrowDate)) {
                showAlert(Alert.AlertType.WARNING, "Input Error", "Return date cannot be earlier than borrow date!");
                return;
            }
            borrow.setDatereturned(returnDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

            String cccdValue = mamuon.getText();
            if (cccdValue == null || cccdValue.isEmpty()) {
                showAlert(Alert.AlertType.WARNING, "Input Error", "CCCD cannot be empty!");
                return;
            }
            borrow.setCCCD(cccdValue);
            borrow.setStatus("Dang muon");
            DatabaseConnection.Borrowbook(borrow);
            showAlert(Alert.AlertType.INFORMATION, "Success", "Borrow record added successfully!");

        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Database Error", "Failed to add borrow record: " + e.getMessage());
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Unexpected Error", "An unexpected error occurred: " + e.getMessage());
        }

    }

}
