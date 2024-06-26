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

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/amazon";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    String mob="";
    String name1="";
    
    public RegisterUser() {
        super();
    }
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        String name = request.getParameter("name");
        String countryCode = request.getParameter("country-code");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        mob=mobile;
        name1=name;
        // Combine country code and mobile number
      

        // Insert data into database
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // Check if the mobile number already exists
            String checkSql = "SELECT COUNT(*) FROM users WHERE mobile = ?";
            try (PreparedStatement checkStmt = connection.prepareStatement(checkSql)) {
                checkStmt.setString(1, mobile);
                try (ResultSet rs = checkStmt.executeQuery()) {
                    rs.next();
                    if (rs.getInt(1) > 0) {
                        // Mobile number already in use
                        request.setAttribute("mobileNumber", mobile);
                        request.getRequestDispatcher("regError.jsp").forward(request, response);
                        return;
                    }
                }
            }

            // If mobile number does not exist, insert new user
            String sql = "INSERT INTO users (name, email, countryCode,mobile, password) VALUES (?, ?,?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, name);
                statement.setString(2, email);
                statement.setString(3, countryCode);
                statement.setString(4, mobile);
                statement.setString(5, password);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    response.setContentType("text/html");
                    response.getWriter().println("<html><body>");
                    response.getWriter().println("<h1>Registration successful!</h1>");
                    response.getWriter().println("<a href='login.html'><button>Back to Login</button></a>");
                    response.getWriter().println("</body></html>");
                } else {
                    response.getWriter().println("Registration failed!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Database error!");
        }
    }
   public String getName() {
	   System.out.println(name1);
  	  return name1;
    }String getMobile() {
    	  return mob;
      }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
