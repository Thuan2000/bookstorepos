package com.thuannguyen.bookstorepos.scenes;

import com.thuannguyen.bookstorepos.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;

public class LoginSceneController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick(ActionEvent event) throws IOException {

        welcomeText.setText("Welcome to JavaFX Application!");
        // TODO: How to get the current JAVAFX stage

        Node source = (Node) event.getSource();  // Cast the event source to Node
        Stage stage = (Stage) source.getScene().getWindow();  // Get the stage from the scene of the source

        // Now you can use the 'stage' variable to interact with the current stage
        // For example, to close the current window you can call:
        // stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1024, 1024);
        stage.setTitle("Bookstore POS");
        stage.setScene(scene);
    }
}