module com.thuannguyen.bookstorepos {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.thuannguyen.bookstorepos to javafx.fxml;
    exports com.thuannguyen.bookstorepos;
    exports com.thuannguyen.bookstorepos.scenes;
    opens com.thuannguyen.bookstorepos.scenes to javafx.fxml;
}