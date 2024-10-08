module com.example.quanlythuvien {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.example.quanlythuvien to javafx.fxml;
    exports com.example.quanlythuvien;
}