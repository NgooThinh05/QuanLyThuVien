package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class DatabaseConnection {
    private static final String DATABASE_URL = "jdbc:sqlite:library.db";

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(DATABASE_URL);
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("PRAGMA busy_timeout = 5000;");
        }
        return connection;
    }


    public static void addbookdata(Book book) throws SQLException {
        String addsql = "INSERT INTO book(ISBN, Title, Author, Publisher, mota, theloai, image, review, soluong) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(addsql)) {

            preparedStatement.setString(1, book.getISBN());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setString(4, book.getPublisher());
            preparedStatement.setString(5, book.getMota());
            preparedStatement.setString(6, book.getTheloai());
            preparedStatement.setString(7, book.getImage());
            preparedStatement.setString(8, book.getRivew());
            preparedStatement.setInt(9, book.getSoluong());
            preparedStatement.executeUpdate();
            System.out.println("Thêm sách thành công!");
        } catch (SQLException e) {
            System.err.println("Lỗi khi thêm sách: " + e.getMessage());
            throw e;
        } finally {
            getConnection().close();
        }
    }

    public static List<Book> searchbookdata(String search) throws SQLException {
        List<Book> books = new ArrayList<>();
        String mysql = "SELECT * FROM book WHERE Title LIKE ? OR Author LIKE ? OR theloai LIKE ? OR Publisher LIKE ?";

        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(mysql)) {
            preparedStatement.setString(1, "%" + search + "%");
            preparedStatement.setString(2, "%" + search + "%");
            preparedStatement.setString(3, "%" + search + "%");
            preparedStatement.setString(4, "%" + search + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

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
            getConnection().close();
        }
        return books;
    }

    public static List<Book> searchBookDataNew() throws SQLException {

        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM book ORDER BY stt DESC LIMIT 6";
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
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
            }
        } finally {
            getConnection().close();
        }

        return books;
    }

    public static List<User> Listusers() throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String ID = resultSet.getString("ID");
                String Hoten = resultSet.getString("Hoten");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String sodt = resultSet.getString("sodt");
                String CCCD = resultSet.getString("CCCD");
                String Diachi = resultSet.getString("DiaChi");
                User user = new User(ID, Hoten, username, password, sodt, CCCD, Diachi);
                users.add(user);
            }
        }
    } finally {
        getConnection().close();
    }
        return users;
    }
}
