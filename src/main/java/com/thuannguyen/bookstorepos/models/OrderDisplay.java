package com.thuannguyen.bookstorepos.models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class OrderDisplay {
    private SimpleIntegerProperty orderId;
    private final SimpleStringProperty time;
    private final SimpleStringProperty booksDisplay;
    private final SimpleDoubleProperty totalPrice;

    public OrderDisplay(Integer orderId, String time, String booksDisplay, double totalPrice) {
        this.orderId = new SimpleIntegerProperty(orderId);
        this.time = new SimpleStringProperty(time);
        this.booksDisplay = new SimpleStringProperty(booksDisplay);
        this.totalPrice = new SimpleDoubleProperty(totalPrice);
    }
    // Getters
    public int getOrderId() { return orderId.get(); }
    public String getTime() { return time.get(); }
    public String getBooksDisplay() { return booksDisplay.get(); }
    public double getTotalPrice() { return totalPrice.get(); }
}
