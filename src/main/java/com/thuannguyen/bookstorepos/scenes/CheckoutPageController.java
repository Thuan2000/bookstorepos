package com.thuannguyen.bookstorepos.scenes;

import com.thuannguyen.bookstorepos.Main;
import com.thuannguyen.bookstorepos.controllers.BookController;
import com.thuannguyen.bookstorepos.models.Book;
import com.thuannguyen.bookstorepos.models.CartItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CheckoutPageController {
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField quantityInput;

    @FXML
    private ChoiceBox<Book> bookChoiceBox;

    @FXML
    private Button addToCartButton;

    @FXML
    private Button checkoutButton;

    @FXML
    private Text pricePerUnitText;

    @FXML
    private Text totalPriceText;

    @FXML
    private Text orderInformationText;

    @FXML
    private Text orderCostText;

    private List<CartItem> cart = new ArrayList<>();

    @FXML
    public void initialize() throws SQLException {
        ObservableList<Book> books = BookController.getAllBooks();
        bookChoiceBox.setItems(books);

        // Listener for the book choice box
        bookChoiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Book>() {
            @Override
            public void changed(ObservableValue<? extends Book> observable, Book oldValue, Book newValue) {
                updateCartItemTotalPrice();
            }
        });

        // Listener for quantity input changes
        quantityInput.textProperty().addListener((observable, oldValue, newValue) -> {
            updateCartItemTotalPrice();
        });
        addToCartButton.setOnAction(e -> addToCart());
        checkoutButton.setOnAction(e -> {
            showCheckoutDialog();
        });
    }

    private void showCheckoutDialog() {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Checkout Confirmation");

        // Set the content text
        dialog.setContentText("Order has been checked out!");

        // Create custom buttons
        ButtonType goToOrdersButtonType = new ButtonType("Go to Orders Page", ButtonBar.ButtonData.OTHER);
        ButtonType okButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(goToOrdersButtonType, okButtonType);

        // Handle 'Go to Orders Page' button click
        Button goToOrdersButton = (Button) dialog.getDialogPane().lookupButton(goToOrdersButtonType);
        goToOrdersButton.addEventFilter(ActionEvent.ACTION, event -> {
            try {
                goToOrdersPage();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            dialog.close(); // Close the dialog
        });

        // Handle 'OK' button click
        Button okButton = (Button) dialog.getDialogPane().lookupButton(okButtonType);
        okButton.addEventFilter(ActionEvent.ACTION, event -> {
            dialog.close(); // Close the dialog
        });
        dialog.showAndWait();
    }

    private void goToOrdersPage() throws IOException {
        // Implement the logic to go to the Orders Page
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("orders-page.fxml"));
        Node page = loader.load();
        BorderPane grandparent = (BorderPane) rootPane.getParent();
        grandparent.setCenter(page);
    }

    private void addToCart() {
        Book selectedBook = bookChoiceBox.getValue();
        if (selectedBook != null) {
            try {
                int quantity = Integer.parseInt(quantityInput.getText());
                double totalPrice = selectedBook.getPrice() * quantity;

                CartItem item = new CartItem(selectedBook.getTitle(), quantity, totalPrice);
                cart.add(item);

                updateTotalOrderCost();
                updateOrderInformationText();
            } catch (NumberFormatException e) {
                // Handle invalid quantity input
            }
        }
    }

    private void updateOrderInformationText() {
        StringBuilder info = new StringBuilder();
        for (CartItem item : cart) {
            info.append("- ").append(item.toString()).append("\n");
        }
        orderInformationText.setText(info.toString());
    }

    private void updateTotalOrderCost() {
        double totalCost = cart.stream().mapToDouble(CartItem::getTotalPrice).sum();
        orderCostText.setText("Order Cost: " + totalCost);
    }

    private void updateCartItemTotalPrice() {
        Book selectedBook = bookChoiceBox.getValue();
        if (selectedBook != null) {
            try {
                double price = selectedBook.getPrice();
                pricePerUnitText.setText("Price Per Unit: " + price);

                int quantity = Integer.parseInt(quantityInput.getText());
                totalPriceText.setText("Total Cost: " + (price * quantity));
            } catch (NumberFormatException e) {
                totalPriceText.setText("Total Cost: -");
            }
        }
    }
}