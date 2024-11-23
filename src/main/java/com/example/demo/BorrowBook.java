package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class BorrowBook {

    @FXML
    private TextField searchField; // Ô tìm kiếm

    @FXML
    private TableView<Book> tableView; // Bảng hiển thị sách
    @FXML
    private TableColumn<Book, Integer> idColumn;
    @FXML
    private TableColumn<Book, String> titleColumn;
    @FXML
    private TableColumn<Book, String> genreColumn;
    @FXML
    private TableColumn<Book, String> authorColumn;
    @FXML
    private TableColumn<Book, String> publisherColumn;
    @FXML
    private TableColumn<Book, String> descriptionColumn;
    @FXML
    private TableColumn<Book, Void> availableColumn; // Column for borrow button

    private List<Book> availableBooks; // Danh sách sách khả dụng

    @FXML
    public void initialize() {
        // Khởi tạo các cột trong bảng
        initializeTableColumns();

        // Tải dữ liệu sách từ cơ sở dữ liệu
        loadBooksFromDatabase();
    }

    private void initializeTableColumns() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("theloai"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        availableColumn.setCellFactory(column -> new TableCell<>() {
            private final Button borrowButton = new Button("Borrow");

            {
                borrowButton.setOnAction(event -> {
                    Book book = getTableView().getItems().get(getIndex());
                    handleBorrowBook(book);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(borrowButton);
                }
            }
        });
    }


    private void loadBooksFromDatabase() {
        try {
            // Lấy sách từ cơ sở dữ liệu
            availableBooks = DatabaseConnection.searchBookDataNew();

            if (availableBooks.isEmpty()) {
                showInfoDialog("No Books Found", "The database returned no books.");
            }

            updateBookList(availableBooks);
        } catch (SQLException e) {
            e.printStackTrace();
            showErrorDialog("Database Error", "Unable to fetch books from the database.");
        }
    }

    @FXML
    public void handleSearch() {
        String keyword = searchField.getText().toLowerCase().trim();

        // Kiểm tra nếu không có từ khóa nhập vào
        if (keyword.isEmpty()) {
            updateBookList(availableBooks);
            return;
        }

        // Lọc danh sách sách theo từ khóa
        List<Book> filteredBooks = availableBooks.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(keyword) ||
                        book.getAuthor().toLowerCase().contains(keyword) ||
                        book.getTheloai().toLowerCase().contains(keyword) ||
                        book.getPublisher().toLowerCase().contains(keyword))
                .collect(Collectors.toList());

        updateBookList(filteredBooks);
    }

    private void updateBookList(List<Book> books) {
        tableView.getItems().clear();
        tableView.getItems().addAll(books);
    }

    private void handleBorrowBook(Book book) {
        try {
            DatabaseConnection.borrowBook(book);
            availableBooks.remove(book);
            updateBookList(availableBooks);
            showInfoDialog("Success", "Book borrowed successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            showErrorDialog("Borrow Error", "Unable to borrow the selected book.");
        }
    }

    private void showErrorDialog(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showInfoDialog(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
