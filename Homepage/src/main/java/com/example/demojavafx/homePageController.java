package com.example.demojavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class homePageController {

    @FXML
    private Button LogOutClickButton;

    @FXML
    private Button AddBooksClickButton;

    @FXML
    private ImageView AddBooksImage;

    @FXML
    private Rectangle AddBooksLabel;

    @FXML
    private ImageView BackgroundLieBraRy;

    @FXML
    private Button BorrowBooksClickButton;

    @FXML
    private ImageView BorrowBooksImage;

    @FXML
    private Label BorrowLabel;

    @FXML
    private Button DashBoardClickButton;

    @FXML
    private ImageView DashboardImage;

    @FXML
    private Label DashboardLabel;

    @FXML
    private Button InventoryClickButton;

    @FXML
    private ImageView InventoryImage;

    @FXML
    private Label InventoryLabel;

    @FXML
    private StackPane MainViewStack;

    @FXML
    private Rectangle MenuBackground;

    @FXML
    private Button ReturnBooksClickButton;

    @FXML
    private ImageView ReturnBooksImage;

    @FXML
    private Label ReturnLabel;

    @FXML
    private TextField SearchBox;

    @FXML
    private Button SettingsClickButton;

    @FXML
    private ImageView SettingsImage;

    @FXML
    private Label SettingsLabel;

    @FXML
    private VBox VBoxOff;

    @FXML
    private VBox VBoxOn;

    @FXML
    void closeAddBooksImage(MouseEvent event) {
        AddBooksImage.setVisible(false);
    }

    @FXML
    void closeDashboardImage(MouseEvent event) {
        DashboardImage.setVisible(false);
    }

    @FXML
    void closeBorrowBooksImage(MouseEvent event) {
        BorrowBooksImage.setVisible(false);
    }

    @FXML
    void closeReturnBooksImage(MouseEvent event) {
        ReturnBooksImage.setVisible(false);
    }

    @FXML
    void closeInventoryImage(MouseEvent event) {
        InventoryImage.setVisible(false);
    }

    @FXML
    void closeSettingsImage(MouseEvent event) {
        SettingsImage.setVisible(false);
    }

    @FXML
    void showAddBooksImage(MouseEvent event) {
        InventoryImage.setVisible(false);
        SettingsImage.setVisible(false);
        DashboardImage.setVisible(false);
        ReturnBooksImage.setVisible(false);
        BorrowBooksImage.setVisible(false);
        AddBooksImage.setVisible(true);
    }

    @FXML
    void showDashboardImage(MouseEvent event) {
        InventoryImage.setVisible(false);
        AddBooksImage.setVisible(false);
        SettingsImage.setVisible(false);
        BorrowBooksImage.setVisible(false);
        ReturnBooksImage.setVisible(false);
        DashboardImage.setVisible(true);
    }

    @FXML
    void showBorrowBooksImage(MouseEvent event) {
        InventoryImage.setVisible(false);
        SettingsImage.setVisible(false);
        AddBooksImage.setVisible(false);
        DashboardImage.setVisible(false);
        ReturnBooksImage.setVisible(false);
        BorrowBooksImage.setVisible(true);
    }

    @FXML
    void showReturnBooksImage(MouseEvent event) {
        InventoryImage.setVisible(false);
        SettingsImage.setVisible(false);
        AddBooksImage.setVisible(false);
        DashboardImage.setVisible(false);
        BorrowBooksImage.setVisible(false);
        ReturnBooksImage.setVisible(true);
    }

    @FXML
    void showInventoryImage(MouseEvent event) {
        SettingsImage.setVisible(false);
        AddBooksImage.setVisible(false);
        DashboardImage.setVisible(false);
        BorrowBooksImage.setVisible(false);
        ReturnBooksImage.setVisible(false);
        InventoryImage.setVisible(true);
    }

    @FXML
    void showSettingsImage(MouseEvent event) {
        AddBooksImage.setVisible(false);
        DashboardImage.setVisible(false);
        BorrowBooksImage.setVisible(false);
        ReturnBooksImage.setVisible(false);
        InventoryImage.setVisible(false);
        SettingsImage.setVisible(true);
    }

    @FXML
    void BackToBackground(MouseEvent event) {
        InventoryImage.setVisible(false);
        SettingsImage.setVisible(false);
        AddBooksImage.setVisible(false);
        DashboardImage.setVisible(false);
        BorrowBooksImage.setVisible(false);
        ReturnBooksImage.setVisible(false);
    }

}
