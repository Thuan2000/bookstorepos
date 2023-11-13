package com.thuannguyen.bookstorepos.scenes;

import com.thuannguyen.bookstorepos.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class LoginSceneController {
    @FXML
    private Label inputText;

    @FXML
    private TextField usernameInput;

    @FXML
    private TextField passwordInput;

    @FXML
    protected void onLoginButtonClick(ActionEvent event) throws IOException {
        String username = usernameInput.getText();
        String password = passwordInput.getText();

        if (!Objects.equals(username, "admin") || !Objects.equals(password, "admin")) {
            inputText.setText("Username or password is incorrect!");
            return;
        }

        Node source = (Node) event.getSource();  // Cast the event source to Node
        Stage stage = (Stage) source.getScene().getWindow();  // Get the stage from the scene of the source

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Bookstore POS");
        stage.setScene(scene);
        stage.centerOnScreen();
    }
}