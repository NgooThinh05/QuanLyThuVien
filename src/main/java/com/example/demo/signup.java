package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import javafx.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

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



    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("image/bgrlogin.jpg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        signupimage.setImage(brandingImage);
    }

    public void SignupButtonAction(ActionEvent actionEvent) throws SQLException {
        if (!setpasswordfield.getText().equals(comfirmpasswordfield.getText())) {
            signupmessage.setText("password not match!");
        }
        signupuser();
    }

    public void signupuser() throws SQLException {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        String username = usernameTextField.getText();
        String password = setpasswordfield.getText();

        String insertFields = "insert into account_user (user_name, pass_word ) values (' " ;
        String insertValues =  username + "','" + password + "')" ;
        String insertToSignup = insertFields + insertValues;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToSignup);
            signupmessage.setText("successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }


    public void closeButton(ActionEvent actionEvent) {
        Stage stage = (Stage) closebutton.getScene().getWindow();
        stage.close();
    }
}
