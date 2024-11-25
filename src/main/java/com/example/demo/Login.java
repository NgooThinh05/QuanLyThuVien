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

import java.io.File;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class Login implements Initializable{
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
    private Button loginbutton;
    @FXML
    private Button signupbutton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("image/bgrlogin.jpg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);
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

        String verifylogin = "SELECT id FROM users WHERE username = ? AND password = ?";

        try {
            PreparedStatement preparedStatement = connectiBD.prepareStatement(verifylogin);
            preparedStatement.setString(1, usernametextfield.getText());
            preparedStatement.setString(2, enterpasswordfield.getText());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                getdata.username = usernametextfield.getText();
                Home();
            } else {
                loginMessagelabel.setText("Invalid login. Please try again!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        } finally {
            connectiBD.close();
        }
    }

    public void createAccountForm(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("signup.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1200, 720);
            Stage stage1 = new Stage();
            stage1.initStyle(StageStyle.UNDECORATED);
            stage1.setScene(scene);
            stage1.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Home(){
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/demo/Home.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1200, 720);
            scene.getStylesheets().add(Main.class.getResource("/dashboarddesign.css").toExternalForm());
            Stage stage1 = new Stage();
            stage1.initStyle(StageStyle.UNDECORATED);
            stage1.setScene(scene);
            stage1.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void signupButtonOnAction(ActionEvent event) {
        createAccountForm();
    }
}
