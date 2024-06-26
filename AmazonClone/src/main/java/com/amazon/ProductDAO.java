package com.amazon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    
    // JDBC URL, username and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/amazon";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "root";

    // Method to fetch list of products from database
    public List<Product> getProductList() {
        List<Product> products = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Establish connection
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            
            // SQL query to retrieve all products
            String sql = "SELECT * FROM products";
            
            // Prepare statement
            pstmt = conn.prepareStatement(sql);
            
            // Execute query
            rs = pstmt.executeQuery();

            // Process result set
            while (rs.next()) {
                int id = rs.getInt("id");
                String productName = rs.getString("productName");
                double price = rs.getDouble("price");
                String category = rs.getString("category");
                String imageName = rs.getString("imageName");

                // Create Product object and add to list
                Product product = new Product(id, productName, price, category, imageName);
                products.add(product);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Close resources in finally block
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return products;
    }

    // Method to fetch a product by its ID
    public Product getProductById(int productId) {
        Product product = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Establish connection
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            
            // SQL query to retrieve product by ID
            String sql = "SELECT * FROM products WHERE id = ?";
            
            // Prepare statement
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, productId);
            
            // Execute query
            rs = pstmt.executeQuery();

            // Process result set
            if (rs.next()) {
                String productName = rs.getString("productName");
                double price = rs.getDouble("price");
                String category = rs.getString("category");
                String imageName = rs.getString("imageName");

                // Create Product object
                product = new Product(productId, productName, price, category, imageName);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Close resources in finally block
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return product;
    }
}
