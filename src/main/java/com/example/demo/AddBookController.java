package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddBookController {

    @FXML
    private TextField AuthorLabel;

    @FXML
    private TextField BookIdLabel;

    @FXML
    private TextField BookTitleLabel;

    @FXML
    private Button CancelButton;

    @FXML
    private TextField PublisherLabel;

    @FXML
    private Button SaveButton;

    @FXML
    void CancelAction(ActionEvent event) {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void SaveAction(ActionEvent event) {

    }

}
