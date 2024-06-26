<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cart</title>
    <style>
        /* Your existing CSS styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
            padding: 20px;
        }
        h2 {
            color: #333;
        }
        .container {
            max-width: 1200px;
            margin: auto;
        }
        .product-management {
            border: 1px solid #ccc;
            padding: 20px;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .btn {
            padding: 8px 12px;
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
            margin-right: 10px;
        }
        .btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Cart Details for ${userName}</h2>
        
        <!-- Cart Table Section -->
        <div class="product-management">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Product ID</th>
                        <th>User ID</th>
                        <th>Product Name</th>
                        <th>Price</th>
                        <th>Category</th>
                        <th>Quantity</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="cartItem" items="${cartItems}">
                        <tr>
                            <td>${cartItem.getId()}</td>
                            <td>${cartItem.getProductId()}</td>
                            <td>${cartItem.getUserId()}</td>
                            <td>${cartItem.getProductName()}</td>
                            <td>${cartItem.getPrice()}</td>
                            <td>${cartItem.getCategory()}</td>
                            <td>${cartItem.getQuantity()}</td>
                            <td>
                                <a href="CheckoutServlet?id=${cartItem.getId()}&userId=${id}&productId=${cartItem.getProductId()}&productName=${cartItem.getProductName()}&price=${cartItem.getPrice()}&category=${cartItem.getCategory()}&quantity=${cartItem.getQuantity()}" class="btn">Checkout</a>
                                <a href="DeleteFromCartServ?id=${cartItem.getId()}&userid=${id}" class="btn">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        
        <!-- Back to Home Link -->
        <div class="product-management">
            <a href="homePage.jsp" class="btn">Back to Home</a>
        </div>
    </div>
</body>
</html>