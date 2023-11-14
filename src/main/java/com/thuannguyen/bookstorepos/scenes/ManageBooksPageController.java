package com.thuannguyen.bookstorepos.scenes;

import com.thuannguyen.bookstorepos.Main;
import com.thuannguyen.bookstorepos.controllers.BookController;
import com.thuannguyen.bookstorepos.models.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class ManageBooksPageController {

    @FXML
    private TableView<Book> booksTable;

    @FXML
    private TableColumn<Book, Integer> idColumn;
    @FXML
    private TableColumn<Book, String> titleColumn;

    @FXML
    private TableColumn<Book, String> authorColumn;

    @FXML
    private TableColumn<Book, Double> priceColumn;

    @FXML
    private TableColumn<Book, Void> actionsColumn;
    @FXML
    public void initialize() throws SQLException {
        ObservableList<Book> books = BookController.getAllBooks();

        // Set cell value factories for the columns
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        actionsColumn.setCellFactory(tc -> new TableCell<>() {
            private final Button btn = new Button("Delete Book");
            {
                btn.setOnAction(e -> {
                    System.out.println("Delete Button was pressed!");
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(btn);
                }
            }
        });

        booksTable.setItems(books);
    }
}