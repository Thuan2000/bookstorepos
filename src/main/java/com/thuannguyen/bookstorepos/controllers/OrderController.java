package com.thuannguyen.bookstorepos.controllers;
import com.thuannguyen.bookstorepos.models.OrderDisplay;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class OrderController {
    public static ObservableList<OrderDisplay> getAllOrderDisplays() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "thuan", "123!@#");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from `Order`");

        ObservableList<OrderDisplay> orderDisplays = FXCollections.observableArrayList();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String timestamp = resultSet.getString("timestamp");
            double totalPrice = resultSet.getDouble("totalPrice");
            String booksDisplay = resultSet.getString("books_display");
            OrderDisplay orderDisplay = new OrderDisplay(id, timestamp, booksDisplay, totalPrice);
            orderDisplays.add(orderDisplay);
        }

        return orderDisplays;
    }
}
