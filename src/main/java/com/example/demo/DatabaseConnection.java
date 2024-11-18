package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class DatabaseConnection {
    private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/library";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "123456";

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        return connection;
    }

    public static void addbookdata(Book book) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String addsql = "INSERT INTO book(IBSN, Title, Author, Publisher, mota, theloai, image, review, soluong) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(addsql);

        preparedStatement.setString(1, book.getISBN());
        preparedStatement.setString(2, book.getTitle());
        preparedStatement.setString(3, book.getAuthor());
        preparedStatement.setString(4, book.getPublisher());
        preparedStatement.setString(5, book.getMota());
        preparedStatement.setString(6, book.getTheloai());
        preparedStatement.setString(7, book.getImage());
        preparedStatement.setString(8, book.getRivew());
        preparedStatement.setInt(9, book.getSoluong());

        int rowsAffected = preparedStatement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Thêm sách thành công!");
        } else {
            System.out.println("Thêm sách thất bại.");
        }

        preparedStatement.close();
        connection.close();
    }

    public static List<Book> searchbookdata(String search) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Book> books = new ArrayList<>();

        try {
            connection = getConnection();
            String mysql = "SELECT * FROM book WHERE Title LIKE ? OR Author LIKE ? OR theloai LIKE ? OR Publisher LIKE ?";
            preparedStatement = connection.prepareStatement(mysql);
            preparedStatement.setString(1, "%" + search + "%");
            preparedStatement.setString(2, "%" + search + "%");
            preparedStatement.setString(3, "%" + search + "%");
            preparedStatement.setString(4, "%" + search + "%");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String ISBN = resultSet.getString("ISBN");
                String title = resultSet.getString("Title");
                String author = resultSet.getString("Author");
                String theloai = resultSet.getString("theloai");
                String publisher = resultSet.getString("Publisher");
                String mota = resultSet.getString("mota");
                String image = resultSet.getString("image");
                String review = resultSet.getString("review");

                Book book = new Book(ISBN, title, author, publisher, mota, theloai, image, review);
                books.add(book);
            }
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
        return books;
    }
}
