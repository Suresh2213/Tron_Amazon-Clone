package com.amazon;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserCheckk")
public class UserCheckk extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // JDBC URL, username, and password of MySQL server
        String jdbcURL = "jdbc:mysql://localhost:3306/amazon";
        String dbUser = "root";
        String dbPassword = "root";

        // Retrieve form parameters
        String emailOrPhone = request.getParameter("emailOrPhone");
        String password = request.getParameter("pass");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Create a connection to the database
            connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            // SQL query to check user credentials
            String sql = "SELECT * FROM users WHERE (email = ? OR mobile = ?) AND password = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, emailOrPhone);
            preparedStatement.setString(2, emailOrPhone);
            preparedStatement.setString(3, password);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // User authenticated; redirect to welcome page or perform other actions
            	String userName = resultSet.getString("name"); // Assuming 'name' is the column name in your users table
            	String id=resultSet.getString("id"); // Assuming 'mobile' is the column name in
//            	request.setAttribute("userName", userName);
//            	request.setAttribute("id", id);
            	request.getSession().setAttribute("userName", userName);
            	request.getSession().setAttribute("id", id);
            	RequestDispatcher dispatcher = request.getRequestDispatcher("homePage.jsp");
            	dispatcher.forward(request, response);
            } else {
                // Authentication failed; redirect back to login page with error message
                response.sendRedirect("login.html?error=true");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new ServletException(ex);
        } finally {
            // Close JDBC objects
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new ServletException(ex);
            }
        }
    }
}
