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

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
}