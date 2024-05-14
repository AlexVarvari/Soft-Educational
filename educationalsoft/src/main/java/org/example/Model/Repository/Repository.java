package org.example.Model.Repository;

import org.example.Model.UserRole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Repository {
    protected Connection connection;

    public Repository() {
        String url = "jdbc:mysql://localhost/userdb"; // URL for MySQL connection
        String username = "root"; // MySQL username
        String password = ""; // MySQL password

        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void openingConnection() {
        try {
            if (this.connection == null || this.connection.isClosed()) {
                this.connection = DriverManager.getConnection("jdbc:mysql://localhost/userdb", "root", "");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void closingConnection() {
        try {
            if (this.connection != null && !this.connection.isClosed()) {
                this.connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean executeSQL(String sql) {
        boolean result = true;
        try {
            openingConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            if (statement.executeUpdate() == 0)
                result = false;
        } catch (SQLException e) {
            e.printStackTrace();
            result = false;
        } finally {
            closingConnection();
        }
        return result;
    }

    public ResultSet getResultSet(String sql) {
        ResultSet result = null;
        try {
            openingConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            result = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean authenticateUser(String username, String password) {
        boolean isAuthenticated = false;
        String query = "SELECT * FROM usertable WHERE Username = ? AND Password = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                isAuthenticated = resultSet.next(); // Check if any rows were returned
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isAuthenticated;
    }

    public int getUserId(String username) {
        // Your logic to fetch user ID from the database or any other storage
        // This is just a placeholder implementation
        if (username.equals("Alex Varvari")) {
            return 1; // Assuming the ID for admin is 1
        } else {
            return 2; // Assuming the ID for other users is 2
        }
    }
    public UserRole getUserRole(String username) {
        UserRole userRole = null;
        String query = "SELECT Role FROM usertable WHERE Username = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String roleString = resultSet.getString("Role");
                    userRole = UserRole.valueOf(roleString);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userRole;
    }


}
