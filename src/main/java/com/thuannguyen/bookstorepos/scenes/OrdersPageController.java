package com.thuannguyen.bookstorepos.scenes;

import com.thuannguyen.bookstorepos.Main;
import com.thuannguyen.bookstorepos.controllers.OrderController;
import com.thuannguyen.bookstorepos.models.OrderDisplay;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.sql.SQLException;

public class OrdersPageController {
    @FXML
    private AnchorPane rootPane;

    @FXML
    private TableView<OrderDisplay> ordersTable;

    @FXML
    private TableColumn<OrderDisplay, Integer> idColumn;
    @FXML
    private TableColumn<OrderDisplay, String> timeColumn;

    @FXML
    private TableColumn<OrderDisplay, String> booksDisplayColumn;

    @FXML
    private TableColumn<OrderDisplay, Double> totalCostColumn;
    @FXML
    protected void onToCheckoutClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("checkout-page.fxml"));
        Node page = loader.load();
        BorderPane grandparent = (BorderPane) rootPane.getParent();
        grandparent.setCenter(page);
    }

    @FXML
    public void initialize() throws SQLException {
        // TODO:
        ObservableList<OrderDisplay> orderDisplays = OrderController.getAllOrderDisplays();

        // Set cell value factories for the columns
        idColumn.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        booksDisplayColumn.setCellValueFactory(new PropertyValueFactory<>("booksDisplay"));
        totalCostColumn.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));

        ordersTable.setItems(orderDisplays);
    }
}