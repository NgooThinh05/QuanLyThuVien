package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Login implements Initializable {
    @FXML
    private Button Cancelbutton;

    @FXML
    private Label loginMessagelabel;

    @FXML
    private ImageView brandingImageView;

    @FXML
    private TextField usernametextfield;

    @FXML
    private PasswordField enterpasswordfield;

    @FXML
    private Button loginButton;

    @FXML
    private Button Signupbutton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Adjusted for loading resources properly
        try {
            Image brandingImage = new Image(getClass().getResource("/image/LoginImage.png").toExternalForm());
            brandingImageView.setImage(brandingImage);
        } catch (NullPointerException e) {
            System.out.println("Image not found! Check the path.");
        }
    }

    public void loginButtonOnAction(ActionEvent event) throws SQLException {
        if (usernametextfield.getText().isBlank() == false && enterpasswordfield.getText().isBlank() == false) {
            /*createAccountForm();*/
            validateLogin();

        } else {
            loginMessagelabel.setText("Invalid login. Please try again!");
        }
    }

    public void CancelbuttonOnAction(ActionEvent event) {
        Stage stage = (Stage) Cancelbutton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin() throws SQLException {
        DatabaseConnection connecnow = new DatabaseConnection();
        Connection connectiBD = connecnow.getConnection();

        String verifylogin = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (PreparedStatement preparedStatement = connectiBD.prepareStatement(verifylogin)) {
            preparedStatement.setString(1, usernametextfield.getText());
            preparedStatement.setString(2, enterpasswordfield.getText());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String Hoten = resultSet.getString("Hoten");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String sodt = resultSet.getString("sodt");
                String CCCD = resultSet.getString("CCCD");
                String Diachi = resultSet.getString("Diachi");
                User usermain = new User(ID, Hoten, username, password, sodt, CCCD, Diachi);
                User.setCurrentUser(usermain);
                Home();
            } else {
                loginMessagelabel.setText("Invalid login. Please try again!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        } finally {
            try {
                connectiBD.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void createAccountForm() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("signup.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root, 700, 500));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void Home() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            Scene scene = new Scene(root, 1200, 720);
            scene.getStylesheets().add(getClass().getResource("/dashboarddesign.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void signupButtonOnAction(ActionEvent event) {
        createAccountForm();
    }
}
