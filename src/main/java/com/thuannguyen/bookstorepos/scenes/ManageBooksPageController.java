package com.thuannguyen.bookstorepos.scenes;

import com.thuannguyen.bookstorepos.Main;
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
import java.util.Objects;

public class ManageBooksPageController {

    @FXML
    private TableView<Book> booksTable;

    @FXML
    private TableColumn<Book, String> titleColumn;

    @FXML
    private TableColumn<Book, String> authorColumn;

    @FXML
    private TableColumn<Book, Double> priceColumn;

    @FXML
    private TableColumn<Book, Void> actionsColumn;
    @FXML
    public void initialize() {
        ObservableList<Book> data = FXCollections.observableArrayList(
                new Book("Example Hard-coded 1", "Thuan Nguyen 1", 100),
                new Book("Example Hard-coded 2", "Thuan Nguyen 2", 200)
        );

        // Set cell value factories for the columns
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

        booksTable.setItems(data);
    }
}