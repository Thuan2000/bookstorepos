package com.thuannguyen.bookstorepos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.*;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login-scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Bookstore POS Login");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) throws SQLException {
        // Just testing things out here.
//        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "thuan", "123!@#");
//        Statement statement = connection.createStatement();
//
//        ResultSet resultSet = statement.executeQuery("select * from Users");
//
//        while(resultSet.next()) {
//            System.out.println(resultSet.getString("username"));
//        }

        launch();
    }
}