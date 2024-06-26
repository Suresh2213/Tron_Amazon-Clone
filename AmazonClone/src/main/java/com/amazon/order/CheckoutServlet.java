package com.amazon.order;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

   
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/amazon";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "root";
    private static final String INSERT_ORDER_SQL = "INSERT INTO orders (user_Id, product_Id, product_Name, price, category, quantity) VALUES (?, ?,?,?, ?, ?)";
    private static final String DELETE_FROM_CART_SQL = "DELETE FROM cart WHERE id = ?";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cartId = Integer.parseInt(request.getParameter("id"));
        System.out.println(cartId);
        int userId = Integer.parseInt(request.getParameter("userId"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        String productName = request.getParameter("productName");
        double price = Double.parseDouble(request.getParameter("price"));
        String category = request.getParameter("category");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        request.setAttribute("cartId", cartId);
        request.setAttribute("userId", userId);
        request.setAttribute("productId", productId);
        request.setAttribute("productName", productName);
        request.setAttribute("price", price);
        request.setAttribute("category", category);
        request.setAttribute("quantity", quantity);

        
        request.getRequestDispatcher("checkOut.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cartId = Integer.parseInt(request.getParameter("cartId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        String productName = request.getParameter("productName");
        double price = Double.parseDouble(request.getParameter("price"));
        String category = request.getParameter("category");
        int quantity = Integer.parseInt(request.getParameter("quantity"));



		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword)) {
            conn.setAutoCommit(false);

            try (PreparedStatement insertStmt = conn.prepareStatement(INSERT_ORDER_SQL);
                 PreparedStatement deleteStmt = conn.prepareStatement(DELETE_FROM_CART_SQL)) {

                // Insert into orders table
                insertStmt.setInt(1, userId);
                insertStmt.setInt(2, productId);
                insertStmt.setString(3, productName);
                insertStmt.setDouble(4, price);
                insertStmt.setString(5, category);
                insertStmt.setInt(6, quantity);
                insertStmt.executeUpdate();

                // Delete from cart table
                deleteStmt.setInt(1, cartId);
                deleteStmt.executeUpdate();

                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("orderConfirmation.jsp");
    }
}