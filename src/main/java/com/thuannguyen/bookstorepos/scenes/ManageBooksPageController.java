package com.thuannguyen.bookstorepos.scenes;

import com.thuannguyen.bookstorepos.Main;
import com.thuannguyen.bookstorepos.controllers.BookController;
import com.thuannguyen.bookstorepos.models.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
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
    protected void onAddNewBookClick(ActionEvent event) throws IOException {
        // Create the custom dialog.
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Add New Book");

        // Set the button types.
        ButtonType confirmButtonType = new ButtonType("Confirm");
        dialog.getDialogPane().getButtonTypes().addAll(confirmButtonType, ButtonType.CANCEL);

        // Create the title, author, and price labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField title = new TextField();
        title.setPromptText("Title");
        TextField author = new TextField();
        author.setPromptText("Author");
        TextField price = new TextField();
        price.setPromptText("Price");

        grid.add(new Label("Title:"), 0, 0);
        grid.add(title, 1, 0);
        grid.add(new Label("Author:"), 0, 1);
        grid.add(author, 1, 1);
        grid.add(new Label("Price:"), 0, 2);
        grid.add(price, 1, 2);

        dialog.getDialogPane().setContent(grid);

        // Add action handler for the confirm button
        Button confirmButton = (Button) dialog.getDialogPane().lookupButton(confirmButtonType);
        confirmButton.addEventFilter(
                ActionEvent.ACTION,
                e -> {
                    double priceValue = Double.parseDouble(price.getText());
                    Book newBook = new Book(title.getText(), author.getText(), priceValue);
                    newBook.saveToDatabase();
                    // Reload the view.
                    ObservableList<Book> books = null;
                    try {
                        books = BookController.getAllBooks();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    booksTable.setItems(books);
                }
        );

        // Add action handler for the cancel button
        Button cancelButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.CANCEL);
        cancelButton.addEventFilter(
                ActionEvent.ACTION,
                e -> dialog.close() // Close the dialog
        );

        // Show the dialog and wait for a response
        dialog.showAndWait();
    }
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