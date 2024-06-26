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

import com.amazon.Product;
import com.amazon.ProductDAO;

@WebServlet("/UserCheckOut")
public class UserCheckOut extends HttpServlet {
    private static final long serialVersionUID = 1L;

   
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/amazon";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "root";
    private static final String INSERT_ORDER_SQL = "INSERT INTO orders (user_Id, product_Id, product_Name, price, category, quantity) VALUES (?, ?,?,?, ?, ?)";
   
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    	int id = Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        int productId = Integer.parseInt(request.getParameter("productId"));
        
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.getProductById(productId);
        String productName = product.getProductName();
        double price = product.getPrice();
        String cat=product.getCategory();
        int quantity = 1;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword)) {
           

            try (PreparedStatement insertStmt = conn.prepareStatement(INSERT_ORDER_SQL);
                ) {

                // Insert into orders table
                insertStmt.setInt(1, id);
                insertStmt.setInt(2, productId);
                insertStmt.setString(3, productName);
                insertStmt.setDouble(4, price);
                insertStmt.setString(5, cat);
                insertStmt.setInt(6, quantity);
                insertStmt.executeUpdate();

                
               
                
            } catch (SQLException e) {
             
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("orderConfirmation.jsp");
    }
}