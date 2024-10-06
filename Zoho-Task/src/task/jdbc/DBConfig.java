package task.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConfig {

    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/incubationDB?useSSL=false";  // Disable SSL explicitly
    private static final String USER = "root";  // Replace with your MySQL username
    private static final String PASSWORD = "root";  // Replace with your MySQL password

    // Static method to get the database connection
    public static Connection getConnection() {
        Connection connection = null;

        try {
            // Load the MySQL JDBC driver for MySQL 5.x
            Class.forName("com.mysql.jdbc.Driver");  // Use the old driver class for MySQL 5.x

            // Establish the connection to the database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            
            if (connection != null) {
                System.out.println("Connected to the database successfully!");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection to database failed!");
            e.printStackTrace();
        }

        return connection;
    }

    // Optionally, add a close method to close the connection
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
