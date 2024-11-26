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

                Book book = new Book(ISBN, title, author, publisher, theloai, mota, image, review);
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
                    Book book = new Book(ISBN, title, author, publisher, theloai, mota, image, review);
                    books.add(book);
                }
            }
        } finally {
            getConnection().close();
        }

        return books;
    }

    public static List<Book> BookData() throws SQLException {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM book ORDER BY stt LIMIT 30";
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
                    Book book = new Book(ISBN, title, author, publisher, theloai, mota,  image, review);
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
                int ID = resultSet.getInt("ID");
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

    public static void acceptdelebook(Book book) throws SQLException {
        String query = "DELETE FROM book WHERE ISBN = ?";
        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, book.getISBN());
            preparedStatement.executeUpdate();
            System.out.println("Xoa sách thành công!");
        } catch (SQLException e) {
            System.err.println("Lỗi khi thêm sách: " + e.getMessage());
            throw e;
        } finally {
            getConnection().close();
        }
    }

    public static void Borrowbook(Borrow borrow) throws SQLException {
        String query = "insert into borrow(ISBN, soluong, ngaymuon, ngaytra, CCCD, trangthai) values(?,?,?,?,?,?)";
        try (Connection conn = getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, borrow.getISBN());
            preparedStatement.setInt(2, borrow.getSl());
            preparedStatement.setString(3, borrow.getDateborrowed());
            preparedStatement.setString(4, borrow.getDatereturned());
            preparedStatement.setString(5, borrow.getCCCD());
            preparedStatement.setString(6, borrow.getStatus());
            preparedStatement.executeUpdate();
            System.out.println("Muon sách thành công!");
        } catch (SQLException e) {
            System.err.println("Lỗi khi thêm sách: " + e.getMessage());
            throw e;
        } finally {
            getConnection().close();
        }
    }


    public static List<Borrow> Listborrows() throws SQLException {
        List<Borrow> borrows = new ArrayList<>();
        String query = "SELECT * FROM borrow";
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String ISBN = resultSet.getString("ISBN");
                    int sl = resultSet.getInt("soluong");
                    String Dateborrow = resultSet.getString("ngaymuon");
                    String Datereturn = resultSet.getString("ngaytra");
                    String CCCD = resultSet.getString("CCCD");
                    String status = resultSet.getString("trangthai");
                    Borrow borrow = new Borrow(id, ISBN, sl, Dateborrow, Datereturn, CCCD, status);
                    borrows.add(borrow);
                }
            }
        } finally {
            getConnection().close();
        }
        return borrows;
    }

    public static List<User> searchUsers(String search) throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users WHERE Hoten LIKE ? OR CCCD LIKE ?";
        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            // Set the parameters for the query (search term with wildcards for LIKE)
            String searchPattern = "%" + search + "%";
            preparedStatement.setString(1, searchPattern);
            preparedStatement.setString(2, searchPattern);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int ID = resultSet.getInt("ID");
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


    public static void updateDatabase(User user) throws SQLException {
        String sql = "UPDATE users SET hoten = ?, username = ?, password = ?, sodt = ?, cccd = ?, diachi = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getHoten());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getSodt());
            stmt.setString(5, user.getCCCD());
            stmt.setString(6, user.getDiaChi());
            stmt.setInt(7, user.getID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getConnection().close();
        }
    }

    public static void adduser(User user) throws SQLException {
        String insertQuery = "INSERT INTO users (HoTen, username, password, sodt, CCCD, Diachi) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(insertQuery)) {
            stmt.setString(1, user.getHoten());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getSodt());
            stmt.setString(5, user.getCCCD());
            stmt.setString(6, user.getDiaChi());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getConnection().close();
        }
    }

    public static void deleteuser(String CCCD) throws SQLException {
        String deleteQuery = "DELETE FROM users WHERE CCCD = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(deleteQuery)) {
            stmt.setString(1, CCCD);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Xoá người dùng thành công!");
            } else {
                System.out.println("Không tìm thấy người dùng với username: " + CCCD);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Hiển thị lỗi nếu xảy ra
        } finally {
            getConnection().close();
        }
    }

    public static void updateBorrow(Borrow borrow) throws SQLException {
        String updateQuery = "UPDATE borrow SET soluong = ?, ngaytra = ?, trangthai = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(updateQuery)) {
            stmt.setInt(1, borrow.getSl());
            stmt.setString(2, borrow.getDatereturned());
            stmt.setString(3, borrow.getStatus());
            stmt.setString(4, borrow.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getConnection().close();
        }
    }

    public static List<Borrow> searchborrow(String search) throws SQLException {
        List<Borrow> borrows = new ArrayList<>();
        String query = "SELECT * FROM borrow where CCCD Like ? OR ISBN LIKE ?";
        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            String searchPattern = "%" + search + "%";
            preparedStatement.setString(1, searchPattern);
            preparedStatement.setString(2, searchPattern);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String ISBN = resultSet.getString("ISBN");
                    int sl = resultSet.getInt("soluong");
                    String Dateborrow = resultSet.getString("ngaymuon");
                    String Datereturn = resultSet.getString("ngaytra");
                    String CCCD = resultSet.getString("CCCD");
                    String status = resultSet.getString("trangthai");
                    Borrow borrow = new Borrow(id, ISBN, sl, Dateborrow, Datereturn, CCCD, status);
                    borrows.add(borrow);
                }
            }
        } finally {
            getConnection().close();
        }
        return borrows;
    }
}
