package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
    private TextField enterpasswordfield;
    @FXML
    private PasswordField enterpasswordfield1;

    private Button loginbutton;
    @FXML
    private Button signupbutton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("image/bgrlogin.jpg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);
    }

    public void loginButtonOnAction(ActionEvent event) {
        if (usernametextfield.getText().isBlank() == false && enterpasswordfield1.getText().isBlank() == false) {
            loginMessagelabel.setText("Invalid login. Please try again!");
        } else {
            loginMessagelabel.setText("Invalid login. Please try again!");
        }
    }

    public void CancelbuttonOnAction(ActionEvent event) {
        Stage stage = (Stage) Cancelbutton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin() {
        DatabaseConnection connecnow = new DatabaseConnection();
        Connection connectiBD = connecnow.getConnection();

        String verifylogin = "SELECT count(1) FROM username = '" + usernametextfield + "'AND password= '" + enterpasswordfield.getText() + "'";

        try {
            Statement statement = connectiBD.createStatement();
            ResultSet resultSet = statement.executeQuery(verifylogin);

            while (resultSet.next()) {
                if (resultSet.getInt(1) == 1) {
                    loginMessagelabel.setText("Congratulations! You are logged in!");
                } else {
                    loginMessagelabel.setText("Invalid login. Please try again!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
