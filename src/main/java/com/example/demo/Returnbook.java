package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Returnbook {
    private Borrow borrow;

    @FXML
    private Label ISBN;
    @FXML
    private Label CCCD;
    @FXML
    private Label dateborrow;
    @FXML
    private TextField status;
    @FXML
    private Label datereturn;
    @FXML
    private TextField sl;
    @FXML
    private DatePicker datereturn1;


    public void showBorrow(Borrow borrow) {
        this.borrow = borrow;
        ISBN.setText(borrow.getISBN().toString());
        CCCD.setText(borrow.getCCCD());
        dateborrow.setText(borrow.getDateborrowed());
        datereturn.setText(borrow.getDatereturned());
        datereturn1.setValue(LocalDate.parse(borrow.getDatereturned()));
        status.setText(borrow.getStatus());
        sl.setText(String.valueOf(borrow.getSl()));
    }

    @FXML
    private void onAccept(ActionEvent event) throws SQLException {
        Borrow selectedUser = this.borrow;
        if (selectedUser != null) {
            selectedUser.setISBN(ISBN.getText());
            selectedUser.setCCCD(CCCD.getText());
            selectedUser.setDateborrowed(dateborrow.getText());
            LocalDate returnDate = datereturn1.getValue();
            if (returnDate != null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                selectedUser.setDatereturned(returnDate.format(formatter));
            }
            selectedUser.setStatus(status.getText());
            selectedUser.setSl(Integer.parseInt(sl.getText()));
            DatabaseConnection.updateBorrow(selectedUser);
            System.out.println("Borrow updated successfully!");
        } else {
            System.out.println("No borrow record selected!");
        }
    }


}
