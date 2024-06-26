package com.amazon.cart;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GetCartData {
    public List<CartItem> getAllCartItems() {
        List<CartItem> cartItems = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon","root","root")) {
            String query = "SELECT * FROM cart";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                CartItem cart = new CartItem();
               
                cart.setProductId(resultSet.getInt("productid"));
                cart.setUserId(resultSet.getInt("userid"));
                cart.setProductName(resultSet.getString("productname"));
                cart.setPrice(resultSet.getDouble("price"));
                cart.setCategory(resultSet.getString("category"));
                cart.setQuantity(resultSet.getInt("quantity"));

                cartItems.add(cart);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cartItems;
    }
}