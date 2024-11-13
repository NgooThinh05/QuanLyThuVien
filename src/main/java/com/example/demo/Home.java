package com.example.demo;


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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

public class Home implements Initializable {

    @FXML
    private Button minimize;

    @FXML
    private Button exit;

    @FXML
    private Button SignOut;

    @FXML
    private Button profile;

    @FXML
    private Button DashBoard;

    @FXML
    private Button AddBook;
    @FXML
    private Button BorrowBook;
    @FXML
    private Button ReturnBook;
    @FXML
    private Button Delete;
    @FXML
    private Button User;
    @FXML
    private Button Setting;
    @FXML
    private Label hello;
    @FXML
    private TextField addressBar;
    @FXML
    private Pane topForm;

    @FXML
    private ImageView Avatar;
    @FXML
    private ImageView SignOutImage;

    @FXML
    private AnchorPane DashBoardForm;
    @FXML
    private AnchorPane AddBookForm;
    @FXML
    private AnchorPane borrow;
    @FXML
    private AnchorPane returnbook;
    @FXML
    private AnchorPane delete;
    @FXML
    private AnchorPane user;
    @FXML
    private AnchorPane settings;
    @FXML
    private AnchorPane profileform;

    @FXML
    private ImageView search;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("image/avatar.jpg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        Avatar.setImage(brandingImage);

        File brandingFile1 = new File("image/log-out.png");
        Image brandingImage1 = new Image(brandingFile1.toURI().toString());
        SignOutImage.setImage(brandingImage1);

        File brandingFile2 = new File("image/kinhlup");
        Image brandingImage2 = new Image(brandingFile2.toURI().toString());
        search.setImage(brandingImage2);

        Name();

    }

    public void switchForm(ActionEvent event) {
        if (event.getSource() == DashBoard) {
            DashBoardForm.setVisible(true);
            AddBookForm.setVisible(false);
            borrow.setVisible(false);
            returnbook.setVisible(false);
            delete.setVisible(false);
            user.setVisible(false);
            settings.setVisible(false);
            profileform.setVisible(false);
        }

        if (event.getSource() == AddBook) {
            DashBoardForm.setVisible(false);
            AddBookForm.setVisible(true);
            borrow.setVisible(false);
            returnbook.setVisible(false);
            delete.setVisible(false);
            user.setVisible(false);
            settings.setVisible(false);
            profileform.setVisible(false);
        }

        if (event.getSource() == BorrowBook) {
            DashBoardForm.setVisible(false);
            AddBookForm.setVisible(false);
            borrow.setVisible(true);
            returnbook.setVisible(false);
            delete.setVisible(false);
            user.setVisible(false);
            settings.setVisible(false);
            profileform.setVisible(false);
        }

        if (event.getSource() == ReturnBook) {
            DashBoardForm.setVisible(false);
            AddBookForm.setVisible(false);
            borrow.setVisible(false);
            returnbook.setVisible(true);
            delete.setVisible(false);
            user.setVisible(false);
            settings.setVisible(false);
            profileform.setVisible(false);
        }

        if (event.getSource() == Delete) {
            DashBoardForm.setVisible(false);
            AddBookForm.setVisible(false);
            borrow.setVisible(false);
            returnbook.setVisible(false);
            delete.setVisible(true);
            user.setVisible(false);
            settings.setVisible(false);
            profileform.setVisible(false);
        }

        if (event.getSource() == User) {
            DashBoardForm.setVisible(false);
            AddBookForm.setVisible(false);
            borrow.setVisible(false);
            returnbook.setVisible(false);
            delete.setVisible(false);
            user.setVisible(true);
            settings.setVisible(false);
            profileform.setVisible(false);
        }

        if (event.getSource() == Setting) {
            DashBoardForm.setVisible(false);
            AddBookForm.setVisible(false);
            borrow.setVisible(false);
            returnbook.setVisible(false);
            delete.setVisible(false);
            user.setVisible(false);
            settings.setVisible(true);
            profileform.setVisible(false);
        }

        if (event.getSource() == profile) {
            DashBoardForm.setVisible(false);
            AddBookForm.setVisible(false);
            borrow.setVisible(false);
            returnbook.setVisible(false);
            delete.setVisible(false);
            user.setVisible(false);
            settings.setVisible(false);
            profileform.setVisible(true);
        }

    }

    public void keyHandler(KeyEvent event) {

    }

    public void exit() {
        System.exit(0);
    }

    public void Login(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1200, 720);
            Stage stage1 = new Stage();
            stage1.initStyle(StageStyle.UNDECORATED);

            stage1.setScene(scene);
            stage1.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Name() {
        hello.setText("Hello, " + getdata.username);
    }

    public void SignOut() {
        Stage stage = (Stage) SignOut.getScene().getWindow();
        stage.close();
        Login();
    }

    public void minimize() {
        Stage stage = (Stage) topForm.getScene().getWindow();
        stage.setIconified(true);
    }

    public void keyHandler(javafx.scene.input.KeyEvent keyEvent) {
    }


    /*@FXML
    void searchButton(ActionEvent event) throws IOException {
        List<Book> ApiResult = ApiBook.searchbook(addressBar.getText());
        List<Book> databaseResult = DatabaseConnection.searchBook(addressBar.getText());

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(""));
            Parent homeView = loader.load();

            // Get the controller instance
            SearchPageController searchPageController = loader.getController();
            searchPageController.setSearchResults(databaseResult, ApiResult);

            setMainContent(homeView);
            staticMainScrollPane.setFitToWidth(true);
            staticMainScrollPane.setFitToHeight(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
