package com.thuannguyen.bookstorepos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Node;

public class MainController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick(ActionEvent event) {

        welcomeText.setText("Welcome to JavaFX Application!");
        // TODO: How to get the current JAVAFX stage

        Node source = (Node) event.getSource();  // Cast the event source to Node
        Stage stage = (Stage) source.getScene().getWindow();  // Get the stage from the scene of the source

        // Now you can use the 'stage' variable to interact with the current stage
        // For example, to close the current window you can call:
         stage.close();
    }
}