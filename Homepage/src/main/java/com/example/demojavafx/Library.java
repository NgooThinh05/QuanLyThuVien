package com.example.demojavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;

import java.awt.*;

public class Library extends Application {

    @Override
    public void start(Stage loginStage) throws Exception {
        FXMLLoader loginScene = new FXMLLoader(Library.class.getResource("homePage.fxml"));
        Scene scene = new Scene(loginScene.load(), 1200, 800);

        loginStage.setScene(scene);
        loginStage.setTitle("LieBraRy");
        loginStage.show();
    }


    public static void main(String[] args) {
        launch();
    }


}
