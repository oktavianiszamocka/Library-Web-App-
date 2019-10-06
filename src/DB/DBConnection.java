package DB;

import models.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {

    static Connection con;

    public static void getConnection() {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@db-oracle:1521:baza";
        String username = "s17874";
        String pass = "oracle12";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, pass);
            con.setAutoCommit(false);

            System.out.println("connected");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static List<Book> searchAllBook(){
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM THEBOOK");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2); //rs.getString("login)
                String author  =  rs.getString(3);
                String subject =  rs.getString(4);
                books.add(new Book(id, title, author, subject));

            }
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static List<Book> findbyId(int id){
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM THEBOOK WHERE ID_BOOK = ?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String title = rs.getString(2); //rs.getString("login)
                String author  =  rs.getString(3);
                String subject =  rs.getString(4);
                books.add(new Book(id, title, author, subject));

            }
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static List<Book> findbyTitle(String title){
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM THEBOOK WHERE TITLE = ?");
            st.setString(1, title);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id  = Integer.parseInt(rs.getString(1)); //rs.getString("login)
                String author  =  rs.getString(3);
                String subject =  rs.getString(4);
                books.add(new Book(id, title, author, subject));

            }
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static List<Book> findbyAuthor(String author){
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM THEBOOK WHERE THEAUTHOR = ?");
            st.setString(1, author);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id  = Integer.parseInt(rs.getString(1)); //rs.getString("login)
                String title  =  rs.getString(2);
                String subject =  rs.getString(4);
                books.add(new Book(id, title, author, subject));

            }
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static List<Book> findSubject(String subject){
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM THEBOOK WHERE SUBJECT = ?");
            st.setString(1, subject);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id  = Integer.parseInt(rs.getString(1)); //rs.getString("login)
                String title =  rs.getString(2);
                String author  =  rs.getString(3);
                books.add(new Book(id, title, author, subject));

            }
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
