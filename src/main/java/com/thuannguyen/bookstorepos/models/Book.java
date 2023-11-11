package com.thuannguyen.bookstorepos.models;

public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        // Save to database if formatted title is unique. Throws error and display if otherwise. Perhaps a job for the controller.
    }
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return title + " by " + author + " - $" + price;
    }
}
