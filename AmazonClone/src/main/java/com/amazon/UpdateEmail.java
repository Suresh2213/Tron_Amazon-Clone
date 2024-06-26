package com.amazon;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateEmail")
public class UpdateEmail extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/amazon";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    public UpdateEmail() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String identifier = request.getParameter("identifier");
        
        
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        String sql = "SELECT * FROM users WHERE mobile = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, identifier);
           
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Identifier found, forward to password update page
                request.setAttribute("identifier", identifier);
                request.getRequestDispatcher("emailupdatenew.jsp").forward(request, response);
            } else {
                // Identifier not found, set error message and forward back to password assistance page
                request.setAttribute("errorMessage", "We're sorry. We weren't able to identify you given the information provided.");
                request.getRequestDispatcher("emailUpdate.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Database error!");
        }
    }
}
