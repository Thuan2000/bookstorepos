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
import java.util.Optional;

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
                    // Get the Book object for the current row
                    Book currentBook = getTableView().getItems().get(getIndex());

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation Dialog");
                    alert.setHeaderText("Delete Book");
                    alert.setContentText("Are you sure you want to delete this book? \n" + "'" + currentBook.getTitle() + "'" + " by " + currentBook.getAuthor());

                    Stage alertStage = (Stage) alert.getDialogPane().getScene().getWindow();
                    alertStage.setAlwaysOnTop(true);
                    alertStage.toFront(); // To bring the dialog to the front

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        // User chose OK
                        System.out.println("Deleting book...");
                        currentBook.delete();

                        // Reload entire book list from database (might need to optimize it later, if time allows it).
                        try {
                            ObservableList<Book> books = BookController.getAllBooks();
                            booksTable.setItems(books);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }

                    } else {
                        // User chose Cancel or closed the dialog
                        System.out.println("Delete operation canceled. Do nothing.");
                    }
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