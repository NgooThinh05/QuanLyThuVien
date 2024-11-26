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

    @FXML
    private void onAcceptadd(ActionEvent event) throws SQLException {
        User selectedUser = new User(); // Lấy đối tượng `User` được chỉnh sửa
        if (selectedUser != null) {
            selectedUser.setUsername(editusername.getText());
            selectedUser.setPassword(editpassword.getText());
            selectedUser.setHoten(editHoten.getText());
            selectedUser.setCCCD(editcccd1.getText());
            selectedUser.setDiaChi(editaddress.getText());
            selectedUser.setSodt(editsdt.getText());
            DatabaseConnection.adduser(selectedUser);
            System.out.println("User add successfully!");
        }
    }

    @FXML
    private void onAcceptdele(ActionEvent event) throws SQLException {
            DatabaseConnection.deleteuser(editcccd.getText());
            System.out.println("User updated successfully!");
    }
}

