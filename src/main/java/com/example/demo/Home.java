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
import javafx.scene.control.Dialog;
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
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

import static com.example.demo.User.getCurrentUser;

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
    private AnchorPane deledashboard;
    @FXML
    private AnchorPane delesearch;
    @FXML
    private AnchorPane borrowpane;
    @FXML
    private AnchorPane searchborrowpane;
    @FXML
    private ImageView search;
    @FXML
    private GridPane bookapi;
    @FXML
    private GridPane bookdata;
    @FXML
    private GridPane recommendgrid;
    @FXML
    private GridPane recommendgrid1;
    @FXML
    private ImageView searchaddimage;
    @FXML
    private ImageView search1;
    @FXML
    private ImageView search2;
    @FXML
    private ImageView search4;
    @FXML
    private ImageView search5;
    @FXML
    private ImageView reset;
    @FXML
    private ImageView reset1;
    @FXML
    private ImageView reset2;
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
    private GridPane deletebook;
    @FXML
    private GridPane deletebooksearch;
    @FXML
    private AnchorPane Anchorpanesearch;
    @FXML
    private AnchorPane dashboard1;
    @FXML
    private TableView dsuser;
    @FXML
    private TableView DSborrow;
    @FXML
    private TextField searchborrrow;
    @FXML
    private TextField searchReturnBook;
    @FXML
    private TextField textsearchuser;
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
    @FXML
    private TableColumn<Borrow, String> stt1;
    @FXML
    private TableColumn<Borrow, String> ISBN;
    @FXML
    private TableColumn<Borrow, String> sl1;
    @FXML
    private TableColumn<Borrow, String> cccd1;
    @FXML
    private TableColumn<Borrow, String> dateborrow;
    @FXML
    private TableColumn<Borrow, String> datereturn;
    @FXML
    private TableColumn<Borrow, String> status;


    @FXML
    private TextField searchdele;


    private List<Book> databaseSearchResults;
    private List<Book> apiSearchResults;
    private List<Book> newbooks;
    private List<Book> shortstorybook;
    private List<Book> educationbooks;
    private List<Book> deletebooks;
    private List<Book> recommendbooks;
    private List<AnchorPane> panes;

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
        searchaddimage.setImage(brandingImage2);
        search1.setImage(brandingImage2);
        search2.setImage(brandingImage2);
        search4.setImage(brandingImage2);
        search5.setImage(brandingImage2);

        File brandingFile3 = new File("image/reset.png");
        Image brandingImage3 = new Image(brandingFile3.toURI().toString());
        reset.setImage(brandingImage3);
        reset1.setImage(brandingImage3);
        reset2.setImage(brandingImage3);


        Name();

        panes = List.of(DashBoardForm, AddBookForm, borrow, returnbook, delete, user, settings, profileform);

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

        try {
            DSdeletebook();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            recommendbookborrow();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            DSborrow();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void switchForm(ActionEvent event) {
        panes.forEach(pane -> pane.setVisible(false));

        if (event.getSource() == DashBoard) {
            DashBoardForm.setVisible(true);
            dashboard1.setVisible(true);
            Anchorpanesearch.setVisible(false);
        } else if (event.getSource() == AddBook) {
            AddBookForm.setVisible(true);
        } else if (event.getSource() == BorrowBook) {
            borrowpane.setVisible(true);
            searchborrowpane.setVisible(false);
            borrow.setVisible(true);
        } else if (event.getSource() == ReturnBook) {
            returnbook.setVisible(true);
        } else if (event.getSource() == Delete) {
            delete.setVisible(true);
            deledashboard.setVisible(true);
            delesearch.setVisible(false);
        } else if (event.getSource() == User) {
            user.setVisible(true);
        } else if (event.getSource() == Setting) {
            settings.setVisible(true);
        } else if (event.getSource() == profile) {
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
        User currentUser = getCurrentUser();
        hello.setText("Hello, " + currentUser.getHoten());
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
        displayBooks(bookdata, databaseResults, "Book.fxml");
        displayBooks(bookapi, apiResults, "Book.fxml");
    }

    private void displayBooks(GridPane gridPane, List<Book> books, String fxmlFileName) {
        gridPane.getChildren().clear();
        int columns = 6;
        int rows = 3;
        int bookCount = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (bookCount >= books.size()) {
                    break;
                }
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
                    Pane bookPane = loader.load();
                    BookCover controller = loader.getController();
                    controller.setDataApi(books.get(bookCount));
                    gridPane.add(bookPane, col, row);
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
        displayBooks(bookaddapi, apiResults, "bookaddsearch.fxml");
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

    public void setdashboardbook(List<Book> newbooks, List<Book> shortstorys, List<Book> educationbooks) {
        this.newbooks = newbooks;
        this.shortstorybook = shortstorys;
        this.educationbooks = educationbooks;
        displayBooks(newbook, newbooks, "book.fxml" );
        displayBooks(shortstory, shortstorybook, "book.fxml");
        displayBooks(education, educationbooks, "book.fxml");
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
        tableView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) { // Double-click
                User selectedUser = tableView.getSelectionModel().getSelectedItem();
                if (selectedUser != null) {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("edituser.fxml"));
                        Parent root = loader.load();
                        Edituser controller = loader.getController();
                        controller.showEditDialog(selectedUser);
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.showAndWait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void UserMN() throws SQLException {
        List<User> users = DatabaseConnection.Listusers();
        initializeTableView(dsuser, stt, hoten, tk, mk, sdt, cccd, diachi, users );
    }

    @FXML
    void buttonsearchusers(ActionEvent event) throws IOException, GeneralSecurityException, SQLException {
        List<User> users = DatabaseConnection.searchUsers(textsearchuser.getText());
        initializeTableView(dsuser, stt, hoten, tk, mk, sdt, cccd, diachi, users );
    }

    private void setDelete(List<Book> deletebooks) {
        this.deletebooks = deletebooks;
        displayBooks(deletebook, deletebooks, "coverbookdelete.fxml");
    }

    private void DSdeletebook() throws SQLException {
        List<Book> deletebooks = DatabaseConnection.BookData();
        setDelete(deletebooks);
    }

    @FXML
    void searchdelebookButton(ActionEvent event) throws IOException, GeneralSecurityException, SQLException {
        deledashboard.setVisible(false);
        delesearch.setVisible(true);
        List<Book> ApiResult = DatabaseConnection.searchbookdata(searchdele.getText());
        setSearchdelebookResults(ApiResult);
    }

    public void setSearchdelebookResults(List<Book> apiResults) {
        this.apiSearchResults = apiResults;
        displayBooks(deletebooksearch, apiResults, "coverbookdelete.fxml");
    }

    public void setrecommend(List<Book> recommendbooks) {
        this.recommendbooks = recommendbooks;
        displayBooks(recommendgrid, recommendbooks, "coverbookborrow.fxml" );
    }

    private void recommendbookborrow() throws SQLException {
        List<Book> recommendbooks = DatabaseConnection.BookData();
        setrecommend(recommendbooks);
    }

    @FXML
    void searchborrowkButton(ActionEvent event) throws IOException, GeneralSecurityException, SQLException {
        List<Book> ApiResult = DatabaseConnection.searchbookdata(searchborrrow.getText());
        setSearchborrowbookResults(ApiResult);
    }

    public void setSearchborrowbookResults(List<Book> Results) {
        borrowpane.setVisible(false);
        searchborrowpane.setVisible(true);
        this.databaseSearchResults = Results;
        displayBooks(recommendgrid1, Results, "coverbookborrow.fxml");
    }

    public void initializeTableViewborrow(TableView<Borrow> tableView,
                                    TableColumn<Borrow, String> stt1,
                                    TableColumn<Borrow, String> ISBN,
                                    TableColumn<Borrow, String> sl1,
                                    TableColumn<Borrow, String> dateborrow,
                                    TableColumn<Borrow, String> datereturn,
                                    TableColumn<Borrow, String> cccd1,
                                    TableColumn<Borrow, String> status,
                                    List<Borrow> borrows) {
        stt1.setCellValueFactory(new PropertyValueFactory<>("id"));
        ISBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        sl1.setCellValueFactory(new PropertyValueFactory<>("sl"));
        dateborrow.setCellValueFactory(new PropertyValueFactory<>("Dateborrowed"));
        datereturn.setCellValueFactory(new PropertyValueFactory<>("Datereturned"));
        cccd1.setCellValueFactory(new PropertyValueFactory<>("CCCD"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        ObservableList<Borrow> observableborrows = FXCollections.observableArrayList(borrows);
        tableView.setItems(observableborrows);
        tableView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) { // Double-click
                Borrow selectedBorrow = tableView.getSelectionModel().getSelectedItem();
                if (selectedBorrow != null) {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("returnbook.fxml"));
                        Parent root = loader.load();
                        Returnbook controller = loader.getController();
                        controller.showBorrow(selectedBorrow);
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.showAndWait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    private void DSborrow() throws SQLException {
        List<Borrow> borrows = DatabaseConnection.Listborrows();
        initializeTableViewborrow(DSborrow , stt1, ISBN, sl1, dateborrow, datereturn, cccd1, status, borrows );
    }

    @FXML
    void buttonsearchborrow(ActionEvent event) throws IOException, GeneralSecurityException, SQLException {
        List<Borrow> borrows = DatabaseConnection.searchborrow(searchReturnBook.getText());
        initializeTableViewborrow(DSborrow , stt1, ISBN, sl1, dateborrow, datereturn, cccd1, status, borrows );
    }

    @FXML
    void buttonadduser(ActionEvent event) throws IOException, GeneralSecurityException, SQLException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("adduser.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void buttonresetuser(ActionEvent event) throws IOException, GeneralSecurityException, SQLException {
        try {
            UserMN();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void buttonresetbook(ActionEvent event) throws IOException, GeneralSecurityException, SQLException {
        try {
            DSdeletebook();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void buttonresetreturn(ActionEvent event) throws IOException, GeneralSecurityException, SQLException {
        try {
            DSborrow();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}



