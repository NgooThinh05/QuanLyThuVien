package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.net.URL;

import java.sql.*;
import java.util.ResourceBundle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class signup implements Initializable {

    @FXML
    private Button closebutton;

    @FXML
    private Label signupmessage;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField setpasswordfield;

    @FXML
    private PasswordField comfirmpasswordfield;

    @FXML
    private TextField MSV;

    @FXML
    private TextField HoTen;

    @FXML
    private TextField sodt;

    @FXML
    private TextField diachi;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    public void SignupButtonAction(ActionEvent actionEvent) {
        if (!setpasswordfield.getText().equals(comfirmpasswordfield.getText())) {
            signupmessage.setText("Passwords do not match!");
            return;
        }

        if (usernameTextField.getText().isBlank() ||
                setpasswordfield.getText().isBlank() ||
                HoTen.getText().isBlank() ||
                sodt.getText().isBlank() ||
                MSV.getText().isBlank() ||
                diachi.getText().isBlank()) {
            signupmessage.setText("All fields are required!");
            return;
        } 
        signupuser();
            

        }
    }

    private void signupuser() throws SQLException {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();
        if (connectDB == null) {
            signupmessage.setText("Cannot connect to the database!");
            return;
        }
        String username = usernameTextField.getText().trim();
        String password = setpasswordfield.getText().trim();
        String hoTenText = HoTen.getText().trim();
        String sodtText = sodt.getText().trim();
        String MSVText = MSV.getText().trim();
        String diaChiText = diachi.getText().trim();
        if (!sodtText.matches("\\d+")) {
            signupmessage.setText("Phone number must contain only digits!");
            return;
        }

        String insertQuery = "INSERT INTO users (HoTen, username, password, sodt, CCCD, Diachi) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connectDB.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, hoTenText);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, sodtText);
            preparedStatement.setString(5, MSVText);
            preparedStatement.setString(6, diaChiText);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                signupmessage.setText("Signup successful!");
            } else {
                signupmessage.setText("Signup failed! Please try again.");
            }

        } catch (SQLIntegrityConstraintViolationException e) {
            signupmessage.setText("Username already exists!");
        } catch (SQLException e) {
            signupmessage.setText("An error occurred while accessing the database!");
            e.printStackTrace();
        }
    }

    public void Login(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 700, 500);
            Stage stage1 = new Stage();
            stage1.initStyle(StageStyle.UNDECORATED);

            stage1.setScene(scene);
            stage1.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void closeButton(ActionEvent actionEvent) {
        Stage stage = (Stage) closebutton.getScene().getWindow();
        stage.close();
        Login();
    }

    private void Login() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 700, 500);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
