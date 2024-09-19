package database;

import java.sql.*;
import javax.swing.JOptionPane;

public class Connect {
    public Connection con;

    public Connect(String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // Use the correct driver for MySQL 8+
            System.out.println("Driver Loaded");
            
            // Define the URL for the MySQL database
            String url = "jdbc:mysql://localhost:3306/oes";
            
            // Establish the connection
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established.");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver is not Loaded.");
            System.out.println("Exception: " + e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Can't connect to server.");
            System.out.println("Connection is not established: " + e.getMessage() + "\n\n" + e);
        }
    }

    public static void main(String[] args) {
        // Ensure you provide the correct username and password when calling this
        new Connect("root", "1234");  // Replace "1234" with your actual password if needed
    }
}
