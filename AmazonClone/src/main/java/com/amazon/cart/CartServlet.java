package com.amazon.cart;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // JDBC URL, username, and password of MySQL server
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/amazon";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "root";

    // SQL query to retrieve cart items by user ID
    private static final String SELECT_CART_ITEMS_BY_USERID = "SELECT * FROM cart WHERE userId = ?";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        int userId =Integer.parseInt( request.getParameter("id"));
      
      
            List<CartItem> cartItems = getCartItems(userId);
            request.setAttribute("cartItems", cartItems);
            request.getRequestDispatcher("UserCart.jsp").forward(request, response);
       
    }

    private List<CartItem> getCartItems(int userId) {
        List<CartItem> cartItems = new ArrayList<>();
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement stmt = conn.prepareStatement(SELECT_CART_ITEMS_BY_USERID)) {
            
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CartItem cartItem = new CartItem();
                cartItem.setId(rs.getInt("id"));  // Adjust according to your CartItem fields
                cartItem.setProductId(rs.getInt("productId"));
                cartItem.setUserId(rs.getInt("userId"));
                cartItem.setProductName(rs.getString("productName"));
                cartItem.setPrice(rs.getDouble("price"));
                cartItem.setCategory(rs.getString("category"));
                cartItem.setQuantity(rs.getInt("quantity"));
                cartItems.add(cartItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       // System.out.println(cartItems);
        return cartItems;
    }
}
