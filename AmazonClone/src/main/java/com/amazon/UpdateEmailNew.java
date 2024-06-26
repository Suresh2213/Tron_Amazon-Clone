package com.amazon;

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

@WebServlet("/UpdateEmailNew")
public class UpdateEmailNew extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/amazon";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    public UpdateEmailNew() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String identifier = request.getParameter("identifier");
        String email = request.getParameter("email");
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (email == null) {
            request.setAttribute("errorMessage", "Please enter a valid email");
            request.getRequestDispatcher("emailUpdate.jsp").forward(request, response);
            return;
        }

       

        String sql = "UPDATE users SET email = ? WHERE mobile = ? ";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);
            statement.setString(2, identifier);
           

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                request.setAttribute("successMessage", "Email updated successfully!");
                request.getRequestDispatcher("emailupdatenew.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Failed to update EMail!");
                request.getRequestDispatcher("EmailUpdate.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Database error!");
        }
    }
}
