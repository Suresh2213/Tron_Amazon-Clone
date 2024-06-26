package com.amazon;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String productName = request.getParameter("productName");
        double price = Double.parseDouble(request.getParameter("price"));
        String category = request.getParameter("category");
        int qty = Integer.parseInt(request.getParameter("qty"));

        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon", "root", "root");

            String sql = "UPDATE products SET productName=?, price=?, category=?, qty=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, productName);
            stmt.setDouble(2, price);
            stmt.setString(3, category);
            stmt.setInt(4, qty);
            stmt.setInt(5, id);

            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("AdminServlet");
    }
}