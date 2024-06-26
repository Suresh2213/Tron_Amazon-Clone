<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Amazon Admin Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .container {
            max-width: 1200px;
            margin: auto;
        }
        .header {
            text-align: center;
            margin-bottom: 20px;
        }
        .product-management, .user-orders {
            border: 1px solid #ccc;
            padding: 20px;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
        }
        table, th, td {
            border: 1px solid #ccc;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
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
<body>
    <div class="container">
        <div class="header">
            <h1>Welcome to Amazon Admin Panel</h1>
        </div>
        
        <!-- Product Management Section -->
        <div class="product-management">
            <h2>Product Management</h2>
            <a href="addProduct.jsp" class="btn">Add New Product</a>
            <a href="adminModule.html" class="btn">Back to Admin Home</a>
            <table>
                <thead>
                    <tr>
                        <th>Product ID</th>
                        <th>Product Name</th>
                        <th>Price</th>
                        <th>Category</th>
                        <th>Quantity</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="product" items="${products}">
                        <tr>
                            <td>${product.id}</td>
                            <td>${product.productName}</td>
                            <td>${product.price}</td>
                            <td>${product.category}</td>
                            <td>${product.qty}</td>
                            <td>
                                <a href="updateProduct.jsp?id=${product.id}">Update</a> | 
                                <a href="DeleteProductServlet?id=${product.id}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        
        <!-- User Orders Section -->
        <div class="user-orders">
            <h2>User Orders</h2>
            <table>
                <thead>
                    <tr>
                        <th>Order ID</th>
                        <th>User ID</th>
                        <th>Product ID</th>
                        <th>Product Name</th>
                        <th>Category</th>
                        <th>Quantity</th>
                        <th>Total Amount</th>
                        <th>Order Date</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="order" items="${orders}">
                        <tr>
                            <td>${order.id}</td>
                            <td>${order.userId}</td>
                            <td>${order.productId}</td>
                            <td>${order.productName}</td>
                            <td>${order.category}</td>
                            <td>${order.quantity}</td>
                            <td>${order.totalAmount}</td>
                            <td>${order.orderDate}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>