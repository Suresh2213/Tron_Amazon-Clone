package com.amazon.order;

import com.amazon.order.Order;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserOrder")
public class UserOrder extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
    	int id = Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        List<Order> orders = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon", "root", "root");

            

            // Retrieve orders
            String sqlOrders ="SELECT o.id, o.user_id, o.product_id, p.productName, p.category, o.quantity, (o.quantity * p.price) AS totalAmount, o.order_date " +
                    "FROM orders o JOIN products p ON o.product_id = p.id " +
                    "WHERE o.user_id = ?";
            PreparedStatement stmtOrders = conn.prepareStatement(sqlOrders);
            stmtOrders.setInt(1, id);
            ResultSet rsOrders = stmtOrders.executeQuery();
            while (rsOrders.next()) {
                Order order = new Order(
                        rsOrders.getInt("id"),
                        rsOrders.getInt("user_id"),
                        rsOrders.getInt("product_id"),
                        rsOrders.getString("productName"),
                        rsOrders.getString("category"),
                        rsOrders.getInt("quantity"),
                        rsOrders.getDouble("totalAmount"),
                        rsOrders.getDate("order_date")
                );
                orders.add(order);
            }

            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

      
        request.setAttribute("orders", orders);

        getServletContext().getRequestDispatcher("/UserOrders.jsp").forward(request, response);
    }
}