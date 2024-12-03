package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

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
    private ChoiceBox<String> status;
    @FXML
    private Label datereturn;
    @FXML
    private TextField sl;
    @FXML
    private DatePicker datereturn1;


    public void showBorrow(Borrow borrow) {
        this.borrow = borrow;
        ISBN.setText(borrow.getISBN());
        CCCD.setText(borrow.getCCCD());
        dateborrow.setText(borrow.getDateborrowed());
        datereturn.setText(borrow.getDatereturned());
        datereturn1.setValue(LocalDate.parse(borrow.getDatereturned()));
        if (status.getItems().isEmpty()) {
            status.getItems().addAll("Dang muon", "Da tra", "Qua han");
        }
        status.setValue(borrow.getStatus());
        sl.setText(String.valueOf(borrow.getSl()));
    }

    @FXML
    private void onAccept(ActionEvent event) {
        try {
            if (borrow != null) {
                borrow.setISBN(ISBN.getText());
                borrow.setCCCD(CCCD.getText());
                borrow.setDateborrowed(dateborrow.getText());
                LocalDate returnDate = datereturn1.getValue();
                if (returnDate != null) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    borrow.setDatereturned(returnDate.format(formatter));
                }
                String selectedStatus = status.getValue();
                if (selectedStatus != null) {
                    borrow.setStatus(selectedStatus);
                } else {
                    showAlert(Alert.AlertType.WARNING, "Input Error", "Please select a status.");
                    return;
                }
                try {
                    borrow.setSl(Integer.parseInt(sl.getText()));
                } catch (NumberFormatException e) {
                    showAlert(Alert.AlertType.ERROR, "Input Error", "Invalid quantity. Please enter a valid number.");
                    return;
                }
                DatabaseConnection.updateBorrow(borrow);
                showAlert(Alert.AlertType.INFORMATION, "Success", "Borrow record updated successfully!");
            } else {
                showAlert(Alert.AlertType.WARNING, "No Selection", "No borrow record selected!");
            }
        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Database Error", "Failed to update borrow record: " + e.getMessage());
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Unexpected Error", "An unexpected error occurred: " + e.getMessage());
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


}
