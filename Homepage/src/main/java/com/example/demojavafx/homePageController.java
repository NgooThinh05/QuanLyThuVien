package com.example.demojavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class homePageController {

    @FXML
    private Button AddBooksClickButton;

    @FXML
    private Rectangle AddBooksLabel;

    @FXML
    private AnchorPane AddBooksPane;

    @FXML
    private ImageView BackgroundLieBraRy;

    @FXML
    private Label BooksOnShelfLabel;

    @FXML
    private AnchorPane BooksOnShelfPane;

    @FXML
    private Button BorrowBooksClickButton;

    @FXML
    private Label BorrowLabel;

    @FXML
    private AnchorPane BorrowPane;

    @FXML
    private Button DashBoardClickButton;

    @FXML
    private Label DashboardLabel;

    @FXML
    private AnchorPane DashboardPane;

    @FXML
    private Button InventoryClickButton;

    @FXML
    private Label InventoryLabel;

    @FXML
    private AnchorPane InventoryPane;

    @FXML
    private Button LogOutClickButton;

    @FXML
    private StackPane MainViewStack;

    @FXML
    private Button ReturnBooksClickButton;

    @FXML
    private Label ReturnLabel;

    @FXML
    private AnchorPane ReturnPane;

    @FXML
    private TextField SearchBox;

    @FXML
    private Button SettingsClickButton;

    @FXML
    private Label SettingsLabel;

    @FXML
    private AnchorPane SettingsPane;

    @FXML
    private VBox VBoxOff;

    @FXML
    private VBox VBoxOn;

    @FXML
    void closeAddBooksPane(MouseEvent event) {
        AddBooksPane.setVisible(false);
    }

    @FXML
    void closeDashboardPane(MouseEvent event) {
        DashboardPane.setVisible(false);
    }

    @FXML
    void closeBorrowBooksPane(MouseEvent event) {
        BorrowPane.setVisible(false);
    }

    @FXML
    void closeReturnBooksPane(MouseEvent event) {
        ReturnPane.setVisible(false);
    }

    @FXML
    void closeInventoryPane(MouseEvent event) {
        InventoryPane.setVisible(false);
    }

    @FXML
    void closeSettingsPane(MouseEvent event) {
        SettingsPane.setVisible(false);
    }

    @FXML
    void showAddBooksImage(MouseEvent event) {
        InventoryPane.setVisible(false);
        SettingsPane.setVisible(false);
        ReturnPane.setVisible(false);
        BorrowPane.setVisible(false);
        DashboardPane.setVisible(false);
        AddBooksPane.setVisible(true);
    }

    @FXML
    void showDashboardImage(MouseEvent event) {
        InventoryPane.setVisible(false);
        SettingsPane.setVisible(false);
        ReturnPane.setVisible(false);
        BorrowPane.setVisible(false);
        AddBooksPane.setVisible(false);
        DashboardPane.setVisible(true);
    }

    @FXML
    void showBorrowBooksImage(MouseEvent event) {
        InventoryPane.setVisible(false);
        SettingsPane.setVisible(false);
        ReturnPane.setVisible(false);
        AddBooksPane.setVisible(false);
        DashboardPane.setVisible(false);
        BorrowPane.setVisible(true);
    }

    @FXML
    void showReturnBooksImage(MouseEvent event) {
        InventoryPane.setVisible(false);
        SettingsPane.setVisible(false);
        BorrowPane.setVisible(false);
        AddBooksPane.setVisible(false);
        DashboardPane.setVisible(false);
        ReturnPane.setVisible(true);
    }

    @FXML
    void showInventoryImage(MouseEvent event) {
        SettingsPane.setVisible(false);
        ReturnPane.setVisible(false);
        BorrowPane.setVisible(false);
        AddBooksPane.setVisible(false);
        DashboardPane.setVisible(false);
        InventoryPane.setVisible(true);
    }

    @FXML
    void showSettingsImage(MouseEvent event) {
        InventoryPane.setVisible(false);
        ReturnPane.setVisible(false);
        BorrowPane.setVisible(false);
        AddBooksPane.setVisible(false);
        DashboardPane.setVisible(false);
        SettingsPane.setVisible(true);
    }

    @FXML
    void BackToBackground(MouseEvent event) {
        InventoryPane.setVisible(false);
        SettingsPane.setVisible(false);
        ReturnPane.setVisible(false);
        BorrowPane.setVisible(false);
        AddBooksPane.setVisible(false);
        DashboardPane.setVisible(false);
    }

}
