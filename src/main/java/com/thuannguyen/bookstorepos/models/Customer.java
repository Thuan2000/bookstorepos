package com.thuannguyen.bookstorepos.models;

public class Customer extends User {
    private String displayName;

    public Customer(String phoneNumber, String displayName) {
        super(phoneNumber);
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void purchaseBook(Book book) {
        // Logic for purchasing a book
        System.out.println(getUsername() + " purchased " + book.getTitle());
    }
}