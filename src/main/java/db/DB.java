package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import beans.User;

public class DB {
    public DB() {
    }

    private Connection connection = null;

    // Establish database connection in a constructor or a separate method
    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion-contact", "root", "");
            System.out.println("Connection successful");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Close the database connection
    public void close() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(User user) {
        String username = user.getUsername();
        connect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user (username) VALUES (?)");
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public String getUsername() {
        String username = "";
        connect();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT username FROM user");
            if (resultSet.next()) {
                username = resultSet.getString("username");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return username;
    }

    public void updateUsername(String username1 , String username2) {
        connect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE user SET username=? WHERE username =?");
            preparedStatement.setString(1, username1);
            preparedStatement.setString(2, username2); 
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void removeContact(String username) {
        connect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM user WHERE username=?");
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
}
