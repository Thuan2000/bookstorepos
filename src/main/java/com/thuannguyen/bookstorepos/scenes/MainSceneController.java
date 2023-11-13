package com.thuannguyen.bookstorepos.scenes;

import com.thuannguyen.bookstorepos.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainSceneController {
    @FXML
    private BorderPane rootPane;

    @FXML
    protected void onSidebarOrdersInformationClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("orders-page.fxml"));
        Node page = loader.load();
        rootPane.setCenter(page);
    }

    @FXML
    protected void onSidebarCheckoutClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("checkout-page.fxml"));
        Node page = loader.load();
        rootPane.setCenter(page);
    }
    @FXML
    protected void onSidebarBooksManagementClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("manage-books-page.fxml"));
        Node page = loader.load();
        rootPane.setCenter(page);
    }
}