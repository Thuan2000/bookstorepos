package com.thuannguyen.bookstorepos.controllers;

import com.thuannguyen.bookstorepos.models.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class BookController {
    public static ObservableList<Book> getAllBooks() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "thuan", "123!@#");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from Book");

        ObservableList<Book> books = FXCollections.observableArrayList();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            double price = resultSet.getDouble("price");

            Book book = new Book(id, title, author, price);
            books.add(book);
        }

        return books;
    }
}
