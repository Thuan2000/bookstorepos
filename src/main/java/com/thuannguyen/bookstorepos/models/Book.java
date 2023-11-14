package com.thuannguyen.bookstorepos.models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

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

    // Other methods...
}