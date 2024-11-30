package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Edituser {
    @FXML
    private TextField editusername;
    @FXML
    private TextField editpassword;
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

    private User user;

    public void showEditDialog(User user) {
        this.user = user;
        editusername.setText(user.getUsername());
        editpassword.setText(user.getPassword());
        editHoten.setText(user.getHoten());
        editcccd.setText(user.getCCCD());
        editaddress.setText(user.getDiaChi());
        editsdt.setText(user.getSodt());
    }

    @FXML
    private void onAccept(ActionEvent event) throws SQLException {
        User selectedUser = this.user;
        if (selectedUser != null) {
            selectedUser.setUsername(editusername.getText());
            selectedUser.setPassword(editpassword.getText());
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
            String username = editusername.getText();
            String password = editpassword.getText();
            String hoten = editHoten.getText();
            String cccd = editcccd1.getText();
            String diaChi = editaddress.getText();
            String sodt = editsdt.getText();
            if (username.isEmpty() || password.isEmpty() || hoten.isEmpty() || cccd.isEmpty() || diaChi.isEmpty() || sodt.isEmpty()) {
                showAlert(Alert.AlertType.WARNING, "Input Error", "All fields must be filled!");
                return;
            }
            User selectedUser = new User();
            selectedUser.setUsername(username);
            selectedUser.setPassword(password);
            selectedUser.setHoten(hoten);
            selectedUser.setCCCD(cccd);
            selectedUser.setDiaChi(diaChi);
            selectedUser.setSodt(sodt);
            DatabaseConnection.adduser(selectedUser);
            showAlert(Alert.AlertType.INFORMATION, "Success", "User edited successfully!");
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

