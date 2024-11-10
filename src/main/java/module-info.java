module com.example.demo {
    requires javafx.fxml;
    requires java.sql;


    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires javafx.web;
    requires com.fasterxml.jackson.core;
    requires java.desktop;
    requires com.google.api.client;
    requires com.google.api.client.json.jackson2;
    requires com.google.api.services.books;
    requires google.api.client;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
}