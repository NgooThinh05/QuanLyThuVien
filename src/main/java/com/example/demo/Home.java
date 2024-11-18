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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

public class Home implements Initializable {

        @FXML
        private Button AddBook;

        @FXML
        private AnchorPane AddBookPane;

        @FXML
        private ImageView Avatar;

        @FXML
        private Button BorrowBook;

        @FXML
        private AnchorPane BorrowBookPane;

        @FXML
        private Button DashBoard;

        @FXML
        private AnchorPane DashBoardPane;

        @FXML
        private Button Delete;

        @FXML
        private AnchorPane DeleteBookPane;

        @FXML
        private AnchorPane ProfileForm;

        @FXML
        private Button ReturnBook;

        @FXML
        private AnchorPane ReturnBookPane;

        @FXML
        private Button Setting;

        @FXML
        private AnchorPane SettingsPane;

        @FXML
        private Button SignOut;

        @FXML
        private ImageView SignOutImage;

        @FXML
        private Button User;

        @FXML
        private AnchorPane UserPane;

        @FXML
        private TextField addressBar;

        @FXML
        private Label appName;

        @FXML
        private GridPane bookApi;

        @FXML
        private GridPane bookData;

        @FXML
        private Button exitButton;

        @FXML
        private Label helloUserLabel;

        @FXML
        private AnchorPane mainAnchorPane;

        @FXML
        private AnchorPane menuAnchorPane;

        @FXML
        private Button minimizeButton;

        @FXML
        private Button profile;

        @FXML
        private ImageView searchBorrowBook;

        @FXML
        private ImageView searchAddBook;

        @FXML
        private Button searchButton;

        @FXML
        private ImageView searchDashboard;

        @FXML
        private TextField searchReturnBook;

        @FXML
        private Button searchReturnBookButton;

        @FXML
        private Pane topForm;

    private List<Book> databaseSearchResults;
    private List<Book> apiSearchResults;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("image/avatar.jpg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        Avatar.setImage(brandingImage);

        File brandingFile1 = new File("image/log-out.png");
        Image brandingImage1 = new Image(brandingFile1.toURI().toString());
        SignOutImage.setImage(brandingImage1);

        File brandingFile2 = new File("image/kinhlup.png");
        Image brandingImage2 = new Image(brandingFile2.toURI().toString());
        searchDashboard.setImage(brandingImage2);

        Name();

    }

    public void switchForm(ActionEvent event) {
        if (event.getSource() == DashBoard) {
            DashBoardPane.setVisible(true);
            AddBookPane.setVisible(false);
            BorrowBookPane.setVisible(false);
            ReturnBookPane.setVisible(false);
            DeleteBookPane.setVisible(false);
            UserPane.setVisible(false);
            SettingsPane.setVisible(false);
            ProfileForm.setVisible(false);
        }

        if (event.getSource() == AddBook) {
            DashBoardPane.setVisible(false);
            AddBookPane.setVisible(true);
            BorrowBookPane.setVisible(false);
            ReturnBookPane.setVisible(false);
            DeleteBookPane.setVisible(false);
            UserPane.setVisible(false);
            SettingsPane.setVisible(false);
            ProfileForm.setVisible(false);
        }

        if (event.getSource() == BorrowBook) {
            DashBoardPane.setVisible(false);
            AddBookPane.setVisible(false);
            BorrowBookPane.setVisible(true);
            ReturnBookPane.setVisible(false);
            DeleteBookPane.setVisible(false);
            UserPane.setVisible(false);
            SettingsPane.setVisible(false);
            ProfileForm.setVisible(false);
        }

        if (event.getSource() == ReturnBook) {
            DashBoardPane.setVisible(false);
            AddBookPane.setVisible(false);
            BorrowBookPane.setVisible(false);
            ReturnBookPane.setVisible(true);
            DeleteBookPane.setVisible(false);
            UserPane.setVisible(false);
            SettingsPane.setVisible(false);
            ProfileForm.setVisible(false);
        }

        if (event.getSource() == Delete) {
            DashBoardPane.setVisible(false);
            AddBookPane.setVisible(false);
            BorrowBookPane.setVisible(false);
            ReturnBookPane.setVisible(false);
            DeleteBookPane.setVisible(true);
            UserPane.setVisible(false);
            SettingsPane.setVisible(false);
            ProfileForm.setVisible(false);
        }

        if (event.getSource() == User) {
            DashBoardPane.setVisible(false);
            AddBookPane.setVisible(false);
            BorrowBookPane.setVisible(false);
            ReturnBookPane.setVisible(false);
            DeleteBookPane.setVisible(false);
            UserPane.setVisible(true);
            SettingsPane.setVisible(false);
            ProfileForm.setVisible(false);
        }

        if (event.getSource() == Setting) {
            DashBoardPane.setVisible(false);
            AddBookPane.setVisible(false);
            BorrowBookPane.setVisible(false);
            ReturnBookPane.setVisible(false);
            DeleteBookPane.setVisible(false);
            UserPane.setVisible(false);
            SettingsPane.setVisible(true);
            ProfileForm.setVisible(false);
        }

        if (event.getSource() == profile) {
            DashBoardPane.setVisible(false);
            AddBookPane.setVisible(false);
            BorrowBookPane.setVisible(false);
            ReturnBookPane.setVisible(false);
            DeleteBookPane.setVisible(false);
            UserPane.setVisible(false);
            SettingsPane.setVisible(false);
            ProfileForm.setVisible(true);
        }

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
        helloUserLabel.setText("Hello, " + getdata.username);
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

    public void setSearchResults(List<Book> databaseResults, List<Book> apiResults) {
        this.databaseSearchResults = databaseResults;
        this.apiSearchResults = apiResults;
        displayDatabaseResults();
        displayApiResults();
    }

    private void displayDatabaseResults() {
        bookApi.getChildren().clear();
        int columns = 6;
        int rows = 6;
        int bookCount = 0;

        if (databaseSearchResults == null || databaseSearchResults.isEmpty()) {
            System.out.println("No books available to display.");
            return;
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (bookCount >= databaseSearchResults.size()) {
                    break;
                }
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("book.fxml"));
                    Pane bookPane = loader.load();
                    Bookapi controller = loader.getController();
                    controller.setDataAll(databaseSearchResults.get(bookCount));
                    bookData.add(bookPane, col, row);
                    bookCount++;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void displayApiResults() {
        bookApi.getChildren().clear(); // Xóa các sách hiển thị trước đó
        int columns = 6;
        int rows = 6;
        int bookCount = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (bookCount >= apiSearchResults.size()) {
                    break;
                }
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("book.fxml"));
                    Pane bookPane = loader.load();
                    Bookapi controller = loader.getController();
                    controller.setData(apiSearchResults.get(bookCount));
                    bookApi.add(bookPane, col, row);
                    bookCount++;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static ScrollPane staticMainScrollPane;
    @FXML
    void searchButton(ActionEvent event) throws IOException, GeneralSecurityException, SQLException {
        List<Book> ApiResult = ApiBook.searchbook(addressBar.getText());
        List<Book> databaseResult = DatabaseConnection.searchbookdata(addressBar.getText());
        setSearchResults(databaseResult, ApiResult);
    }



}



