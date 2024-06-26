package com.amazon.cart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CartDAO {

    // JDBC URL, username and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/amazon";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "root";

    // Method to add a product to the cart
    public boolean addToCart(int productId, int userId, String productName, double price, String category, int quantity) {
        boolean success = false;

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO cart (productId, userId, productName, price, category, quantity) VALUES (?, ?, ?, ?, ?, ?)")) {

            // Set parameters for the PreparedStatement
            pstmt.setInt(1, productId);
            pstmt.setInt(2, userId);
            pstmt.setString(3, productName);
            pstmt.setDouble(4, price);
            pstmt.setString(5, category);
            pstmt.setInt(6, quantity);

            // Execute query
            int rowsAffected = pstmt.executeUpdate();

            // Check if insertion was successful
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return success;
    }
}
