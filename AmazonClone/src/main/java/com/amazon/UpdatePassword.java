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

@WebServlet("/UpdatePassword")
public class UpdatePassword extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/amazon";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    public UpdatePassword() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String identifier = request.getParameter("identifier");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (newPassword == null || newPassword.length() < 6) {
            request.setAttribute("errorMessage", "Password must be at least 6 characters long.");
            request.getRequestDispatcher("passupdate.jsp").forward(request, response);
            return;
        }

        if (!newPassword.equals(confirmPassword)) {
            request.setAttribute("errorMessage", "Passwords do not match!");
            request.getRequestDispatcher("passupdate.jsp").forward(request, response);
            return;
        }

        String sql = "UPDATE users SET password = ? WHERE email = ? OR mobile = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, newPassword);
            statement.setString(2, identifier);
            statement.setString(3, identifier);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                request.setAttribute("successMessage", "Password updated successfully!");
                request.getRequestDispatcher("passupdate.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Failed to update password!");
                request.getRequestDispatcher("passupdate.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Database error!");
        }
    }
}
