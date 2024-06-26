<%@ page import="com.amazon.Product" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Product</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .container {
            max-width: 600px;
            margin: auto;
            padding: 20px;
            border: 1px solid #ccc;
            background-color: #f9f9f9;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"], input[type="number"], input[type="file"], select {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }
        .btn {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
            text-decoration: none;
        }
        .btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
</head>
<body>
    <div class="container">
        <h2>Edit Product</h2>
        <%-- Retrieve the id parameter from the request --%>
        <% String productId = request.getParameter("id"); %>
        <form action="UpdateProductServlet" method="post">
          
                
                <input type="hidden" id="id" name="id" value="<%= productId %>">
            
            <div class="form-group">
                <label for="productName">Product Name</label>
                <input type="text" id="productName" name="productName" >
            </div>
            <div class="form-group">
                <label for="price">Price</label>
                <input type="text" id="price" name="price" >
            </div>
            <div class="form-group">
                <label for="category">Category</label>
                <input type="text" id="category" name="category">
            </div>
            <div class="form-group">
                <label for="qty">Quantity</label>
                <input type="text" id="qty" name="qty" >
            </div>
            <button type="submit" class="btn">Update Product</button>
        </form>
    </div>
</body>
</html>