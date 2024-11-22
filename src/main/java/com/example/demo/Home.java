package com.example.demo;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.awt.*;
import java.awt.ScrollPane;
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
    private Button searchButton;
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
    @FXML
    private GridPane bookapi;
    @FXML
    private GridPane bookdata;
    @FXML
    private ImageView searchaddimage;
    @FXML
    private TextField searchadd;
    @FXML
    private GridPane bookaddapi;
    @FXML
    private Button searchaddbutton;
    @FXML
    private Button acceptbutton;
    @FXML
    private TextField addtitle;
    @FXML
    private TextField addauthor;
    @FXML
    private TextField addmota;
    @FXML
    private TextField addISBN;
    @FXML
    private TextField addnxb;
    @FXML
    private TextField addsl;
    @FXML
    private TextField addtheloai;
    @FXML
    private TextField linkimage;
    @FXML
    private TextField linkreview;
    @FXML
    private GridPane newbook;
    @FXML
    private GridPane shortstory;
    @FXML
    private GridPane education;
    @FXML
    private AnchorPane Anchorpanesearch;
    @FXML
    private AnchorPane dashboard1;
    @FXML
    private TableView dsuser;
    @FXML
    private TableColumn<User, String> stt;
    @FXML
    private TableColumn<User, String> hoten;
    @FXML
    private TableColumn<User, String> tk;
    @FXML
    private TableColumn<User, String> mk;
    @FXML
    private TableColumn<User, String> sdt;
    @FXML
    private TableColumn<User, String> cccd;
    @FXML
    private TableColumn<User, String> diachi;


    private List<Book> databaseSearchResults;
    private List<Book> apiSearchResults;
    private List<Book> newbooks;
    private List<Book> shortstorybook;
    private List<Book> educationbooks;

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
        search.setImage(brandingImage2);

        File brandingFile3 = new File("image/kinhlup.png");
        Image brandingImage3 = new Image(brandingFile2.toURI().toString());
        searchaddimage.setImage(brandingImage2);

        Name();

        try {
            dashbordresult();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            UserMN();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void switchForm(ActionEvent event) {
        if (event.getSource() == DashBoard) {
            DashBoardForm.setVisible(true);
            dashboard1.setVisible(true);
            Anchorpanesearch.setVisible(false);
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

    public void setSearchResults(List<Book> databaseResults, List<Book> apiResults) {
        this.databaseSearchResults = databaseResults;
        this.apiSearchResults = apiResults;
        displayDatabaseResults();
        displayApiResults();
    }

    private void displayDatabaseResults() {
        bookapi.getChildren().clear();
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
                    BookCover controller = loader.getController();
                    controller.setDataApi(databaseSearchResults.get(bookCount));
                    bookdata.add(bookPane, col, row);
                    bookCount++;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void displayApiResults() {
        bookapi.getChildren().clear();
        int columns = 10;
        int rows = 10;
        int bookCount = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (bookCount >= apiSearchResults.size()) {
                    break;
                }
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("book.fxml"));
                    Pane bookPane = loader.load();
                    BookCover controller = loader.getController();
                    controller.setData(apiSearchResults.get(bookCount));
                    bookapi.add(bookPane, col, row);
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
        Anchorpanesearch.setVisible(true);
        dashboard1.setVisible(false);
        List<Book> ApiResult = ApiBook.searchbook(addressBar.getText());
        List<Book> databaseResult = DatabaseConnection.searchbookdata(addressBar.getText());
        setSearchResults(databaseResult, ApiResult);
    }

    public void setSearchaddbookResults(List<Book> apiResults) {
        this.apiSearchResults = apiResults;
        displayApiaddbookResults();
    }

    private void displayApiaddbookResults() {
        bookaddapi.getChildren().clear();
        int columns = 6;
        int rows = 6;
        int bookCount = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (bookCount >= apiSearchResults.size()) {
                    break;
                }
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("bookaddsearch.fxml"));
                    Pane bookPane = loader.load();
                    BookCover controller = loader.getController();
                    controller.setData(apiSearchResults.get(bookCount));
                    bookaddapi.add(bookPane, col, row);
                    bookCount++;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    void searchaddbookButton(ActionEvent event) throws IOException, GeneralSecurityException, SQLException {
        List<Book> ApiResult = ApiBook.searchbook(searchadd.getText());
        setSearchaddbookResults(ApiResult);
    }

    public void acceptbutton(ActionEvent event) throws IOException, GeneralSecurityException, SQLException {
        Book addbook = new Book();
        addbook.setTitle(addtitle.getText());
        addbook.setAuthor(addauthor.getText());
        addbook.setTheloai(addtheloai.getText());
        addbook.setISBN(addISBN.getText());
        addbook.setMota(addmota.getText());
        addbook.setImage(linkimage.getText());
        addbook.setPublisher(addnxb.getText());
        int soluong = Integer.parseInt(addsl.getText());
        addbook.setSoluong(soluong);
        addbook.setRivew(linkreview.getText());
        DatabaseConnection.addbookdata(addbook);
    }

    public void setdashboardbook(List<Book> newbooks, List<Book> shortstory, List<Book> educationbooks) {
        this.newbooks = newbooks;
        this.shortstorybook = shortstory;
        this.educationbooks = educationbooks;
        displayDatabasenewbook();
        displayDatabaseshortstory();
        displayDatabaseeducationbook();
    }

    private void displayDatabasenewbook() {
        newbook.getChildren().clear();
        int columns = 6;
        int rows = 6;
        int bookCount = 0;

        if (newbooks == null || newbooks.isEmpty()) {
            System.out.println("No books available to display.");
            return;
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (bookCount >= newbooks.size()) {
                    break;
                }
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("book.fxml"));
                    Pane bookPane = loader.load();
                    BookCover controller = loader.getController();
                    controller.setDataApi(newbooks.get(bookCount));
                    newbook.add(bookPane, col, row);
                    bookCount++;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void displayDatabaseshortstory() {
        shortstory.getChildren().clear();
        int columns = 6;
        int rows = 6;
        int bookCount = 0;

        if (shortstorybook == null || shortstorybook.isEmpty()) {
            System.out.println("No books available to display.");
            return;
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (bookCount >= shortstorybook.size()) {
                    break;
                }
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("book.fxml"));
                    Pane bookPane = loader.load();
                    BookCover controller = loader.getController();
                    controller.setDataApi(shortstorybook.get(bookCount));
                    shortstory.add(bookPane, col, row);
                    bookCount++;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void displayDatabaseeducationbook() {
        education.getChildren().clear();
        int columns = 6;
        int rows = 6;
        int bookCount = 0;

        if (educationbooks == null || educationbooks.isEmpty()) {
            System.out.println("No books available to display.");
            return;
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (bookCount >= educationbooks.size()) {
                    break;
                }
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("book.fxml"));
                    Pane bookPane = loader.load();
                    BookCover controller = loader.getController();
                    controller.setDataApi(educationbooks.get(bookCount));
                    education.add(bookPane, col, row);
                    bookCount++;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void dashbordresult() throws SQLException {
        List<Book> newbooks  = DatabaseConnection.searchBookDataNew();
        List<Book> shortstorybook = DatabaseConnection.searchbookdata("Comics");
        List<Book> educationbook = DatabaseConnection.searchbookdata("Education");
        setdashboardbook(newbooks, shortstorybook, educationbook );
    }

    public void initializeTableView(TableView<User> tableView,
                                    TableColumn<User, String> stt,
                                    TableColumn<User, String> hoten,
                                    TableColumn<User, String> tk,
                                    TableColumn<User, String> mk,
                                    TableColumn<User, String> sdt,
                                    TableColumn<User, String> cccd,
                                    TableColumn<User, String> diachi,
                                    List<User> users) {
        stt.setCellValueFactory(new PropertyValueFactory<>("ID"));
        hoten.setCellValueFactory(new PropertyValueFactory<>("Hoten"));
        tk.setCellValueFactory(new PropertyValueFactory<>("username"));
        mk.setCellValueFactory(new PropertyValueFactory<>("password"));
        sdt.setCellValueFactory(new PropertyValueFactory<>("sodt"));
        cccd.setCellValueFactory(new PropertyValueFactory<>("CCCD"));
        diachi.setCellValueFactory(new PropertyValueFactory<>("DiaChi"));
        ObservableList<User> observableUsers = FXCollections.observableArrayList(users);
        tableView.setItems(observableUsers);
    }

    private void UserMN() throws SQLException {
        List<User> users = DatabaseConnection.Listusers();
        initializeTableView(dsuser, stt, hoten, tk, mk, sdt, cccd, diachi, users );
    }
}



