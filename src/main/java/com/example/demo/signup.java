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
import java.util.ResourceBundle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class signup implements Initializable {

    @FXML
    private ImageView signupimage;

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
        // Load the background image for branding
        try {
            URL imageUrl = getClass().getResource("/image/");
            if (imageUrl != null) {
                Image brandingImage = new Image(imageUrl.toExternalForm());
                signupimage.setImage(brandingImage);
            } else {
                System.out.println("Background image not found. Check the file path!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void SignupButtonAction(ActionEvent actionEvent) {
        if (!setpasswordfield.getText().equals(comfirmpasswordfield.getText())) {
            signupmessage.setText("Passwords do not match!");
        } else {
            try {
                signupuser();
            } catch (SQLException e) {
                e.printStackTrace();
                signupmessage.setText("An error occurred during signup!");
            }
        }
    }

    private void signupuser() throws SQLException {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        String username = usernameTextField.getText();
        String password = setpasswordfield.getText();
        String hoTenText = HoTen.getText();
        String sodtText = sodt.getText();
        String MSVText = MSV.getText();
        String DiaChi = diachi.getText();

        String insertQuery = "INSERT INTO users (HoTen, username, password, sodt, CCCD, Diachi) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connectDB.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, hoTenText);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, sodtText);
            preparedStatement.setString(5, MSVText);
            preparedStatement.setString(6, DiaChi);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                signupmessage.setText("Signup successful!");
            } else {
                signupmessage.setText("Signup failed!");
            }
        }
    }

    @FXML
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
