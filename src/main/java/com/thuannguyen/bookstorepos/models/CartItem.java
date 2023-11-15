package com.thuannguyen.bookstorepos.models;

public class CartItem {
    private String bookTitle;
    private int quantity;
    private double totalPrice;

    public CartItem(String bookTitle, int quantity, double totalPrice) {
        this.bookTitle = bookTitle;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return String.format("\"%s\" - quantity %d - total price: %.2f", bookTitle, quantity, totalPrice);
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
