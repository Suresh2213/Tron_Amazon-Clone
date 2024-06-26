package com.amazon;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amazon.ProductDAO;
import com.amazon.cart.CartDAO;
import com.amazon.Product;

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

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
        int quantity = 1; // You can customize this based on user input
        
        CartDAO cartDAO = new CartDAO();
        cartDAO.addToCart(productId,  id, productName,  price,  cat,  quantity);
        request.setAttribute("userName", name);
    	request.setAttribute("id", id);
        response.sendRedirect("productnew.jsp");
    }
}
