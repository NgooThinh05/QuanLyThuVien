package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Edituser {
    @FXML
    private Label gt;
    @FXML
    private Label birth;
    @FXML
    private Button accept;
    @FXML
    private TextField editHoten;
    @FXML
    private Label editcccd;
    @FXML
    private TextField editcccd1;
    @FXML
    private TextField editaddress;
    @FXML
    private TextField editsdt;
    @FXML
    private ChoiceBox<String> gender;
    @FXML
    private DatePicker birthday;

    private User user;


    @FXML
    private void initialize() {
        if (gender != null && gender.getItems().isEmpty()) {
            gender.getItems().addAll("Male", "Female");
        }
    }

    public void showEditDialog(User user) {
        this.user = user;
        gt.setText(user.getGt());
        birth.setText(user.getBirthday().toString());
        editHoten.setText(user.getHoten());
        editcccd.setText(user.getCCCD());
        editaddress.setText(user.getDiaChi());
        editsdt.setText(user.getSodt());
    }

    @FXML
    private void onAccept(ActionEvent event) throws SQLException {
        User selectedUser = this.user;
        if (selectedUser != null) {
            selectedUser.setGt(gt.getText());
            selectedUser.setBirthday(birth.getText());
            selectedUser.setHoten(editHoten.getText());
            selectedUser.setCCCD(editcccd.getText());
            selectedUser.setDiaChi(editaddress.getText());
            selectedUser.setSodt(editsdt.getText());

            DatabaseConnection.updateDatabase(selectedUser);

            System.out.println("User updated successfully!");
        }

    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void onAcceptadd(ActionEvent event) {
        try {
            if (gender.getItems().isEmpty()) {
                gender.getItems().addAll("Male", "Female");
            }
            LocalDate returnDate = birthday.getValue();
            String formattedDate = null;
            if (returnDate != null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                formattedDate = returnDate.format(formatter);
            }
            String hoten = editHoten.getText();
            String cccd = editcccd1.getText();
            String diaChi = editaddress.getText();
            String sodt = editsdt.getText();
            String gtValue = (String) gender.getValue();
            if (hoten.isEmpty() || cccd.isEmpty() || diaChi.isEmpty() || sodt.isEmpty() || gtValue == null || formattedDate == null) {
                showAlert(Alert.AlertType.WARNING, "Input Error", "All fields must be filled!");
                return;
            }
            User newUser = new User();
            newUser.setHoten(hoten);
            newUser.setCCCD(cccd);
            newUser.setDiaChi(diaChi);
            newUser.setSodt(sodt);
            newUser.setGt(gtValue);
            newUser.setBirthday(formattedDate);
            DatabaseConnection.adduser(newUser);
            showAlert(Alert.AlertType.INFORMATION, "Success", "User added successfully!");
        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Database Error", "Failed to add user: " + e.getMessage());
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Unexpected Error", "An unexpected error occurred: " + e.getMessage());
        }
    }

    @FXML
    private void onAcceptdele(ActionEvent event) throws SQLException {
            DatabaseConnection.deleteuser(editcccd.getText());
            showAlert(Alert.AlertType.INFORMATION, "Success", "User deleted successfully!");
    }
}

