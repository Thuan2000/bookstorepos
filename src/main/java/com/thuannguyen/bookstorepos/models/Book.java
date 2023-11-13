package com.thuannguyen.bookstorepos.models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book {
    private final SimpleStringProperty title;
    private final SimpleStringProperty author;
    private final SimpleDoubleProperty price;

    public Book(String title, String author, double price) {
        this.title = new SimpleStringProperty(title);
        this.author = new SimpleStringProperty(author);
        this.price = new SimpleDoubleProperty(price);
    }

    // Getters
    public String getTitle() { return title.get(); }
    public String getAuthor() { return author.get(); }
    public double getPrice() { return price.get(); }

    // Other methods...
}