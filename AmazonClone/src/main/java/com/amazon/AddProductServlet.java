package com.amazon;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/AddProductServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
                 maxFileSize = 1024 * 1024 * 10,      // 10MB
                 maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class AddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("productName");
        double price = Double.parseDouble(request.getParameter("price"));
        String category = request.getParameter("category");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Part filePart = request.getPart("image");
        String fileName = extractFileName(filePart);
        String savePath =  fileName; // Change to your desired directory

        // Save the file to the specified directory
        File fileSaveDir = new File(savePath);
        Files.copy(filePart.getInputStream(), fileSaveDir.toPath(), StandardCopyOption.REPLACE_EXISTING);

        boolean success = insertProduct(productName, price, category, quantity, savePath);

        if (success) {
            response.sendRedirect("AdminServlet");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    private boolean insertProduct(String productName, double price, String category, int quantity, String imagePath) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon", "root", "root");
            String sql = "INSERT INTO products (productName, price, category, qty, imageName) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, productName);
            pstmt.setDouble(2, price);
            pstmt.setString(3, category);
            pstmt.setInt(4, quantity);
            pstmt.setString(5, imagePath);

            int rowsInserted = pstmt.executeUpdate();
            conn.close();
            return rowsInserted > 0;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}