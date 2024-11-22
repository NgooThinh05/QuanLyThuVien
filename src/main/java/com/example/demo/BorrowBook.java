package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BorrowBook {

    @FXML
    private TextField searchField; // Trường văn bản cho tìm kiếm
    @FXML
    private ListView<HBox> bookListView; // Danh sách hiển thị sách

    private List<Book> availableBooks; // Danh sách sách khả dụng
    private DatabaseConnection db; // Đối tượng truy vấn cơ sở dữ liệu

    @FXML
    public void initialize() {
        db = new DatabaseConnection();
        try {
            availableBooks = db.searchBookDataNew(); // Lấy danh sách sách từ cơ sở dữ liệu
            updateBookList(availableBooks);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSearch() {
        String keyword = searchField.getText().toLowerCase();
        List<Book> filteredBooks = availableBooks.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(keyword) ||
                        book.getAuthor().toLowerCase().contains(keyword) ||
                        book.getTheloai().toLowerCase().contains(keyword) ||
                        book.getPublisher().toLowerCase().contains(keyword))
                .collect(Collectors.toList());
        updateBookList(filteredBooks);
    }
    // Cập nhật danh sách sách hiển thị
    private void updateBookList(List<Book> books) {
        bookListView.getItems().clear();
        for (Book book : books) {
            HBox bookRow = new HBox(10);
            Label bookLabel = new Label(book.getTitle() + " - " + book.getAuthor());
            Button borrowButton = new Button("Mượn");

            borrowButton.setOnAction(e -> {
                borrowButton.setDisable(true);
                borrowButton.setText("Đã mượn");
                try {
                    // Xử lý mượn sách: Cập nhật trạng thái sách trong cơ sở dữ liệu
                    db.addbookdata(book); // Giả sử bạn có phương thức để cập nhật lại sách đã mượn
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                availableBooks.remove(book);
            });

            bookRow.getChildren().addAll(bookLabel, borrowButton);
            bookListView.getItems().add(bookRow);
        }
    }


}
