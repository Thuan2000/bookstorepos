package com.thuannguyen.bookstorepos.models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Book {

    private final SimpleIntegerProperty id;
    private final SimpleStringProperty title;
    private final SimpleStringProperty author;
    private final SimpleDoubleProperty price;

    public Book(Integer id, String title, String author, double price) {
        this.id = new SimpleIntegerProperty(id);
        this.title = new SimpleStringProperty(title);
        this.author = new SimpleStringProperty(author);
        this.price = new SimpleDoubleProperty(price);
    }
    // Getters
    public int getId() { return id.get(); }
    public String getTitle() { return title.get(); }
    public String getAuthor() { return author.get(); }
    public double getPrice() { return price.get(); }

    // Delete method
    public void delete() {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Establish a connection
            String url = "jdbc:mysql://localhost:3306/bookstore";
            String user = "thuan"; // Replace with your database username
            String password = "123!@#"; // Replace with your database password

            conn = DriverManager.getConnection(url, user, password);

            // Step 2: Create a SQL delete statement
            String sql = "DELETE FROM Book WHERE id = ?";

            // Step 3: Prepare the statement
            pstmt = conn.prepareStatement(sql);

            // Step 4: Set the id
            pstmt.setInt(1, getId());

            // Step 5: Execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the resources
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}