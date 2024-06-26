<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Checkout</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
            padding: 20px;
        }
        .container {
            max-width: 600px;
            margin: auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h2 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
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
        }
        .btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Confirm Your Order</h2>
        <table>
            <tr>
                <th>Product Name</th>
                <td>${productName}</td>
            </tr>
            <tr>
                <th>Price</th>
                <td>${price}</td>
            </tr>
            <tr>
                <th>Category</th>
                <td>${category}</td>
            </tr>
            <tr>
                <th>Quantity</th>
                <td>${quantity}</td>
            </tr>
        </table>
        <form action="CheckoutServlet" method="post">
            <input type="hidden" name="cartId" value="${cartId}">
            <input type="hidden" name="userId" value="${userId}">
            <input type="hidden" name="productId" value="${productId}">
            <input type="hidden" name="productName" value="${productName}">
            <input type="hidden" name="price" value="${price}">
            <input type="hidden" name="category" value="${category}">
            <input type="hidden" name="quantity" value="${quantity}">
            <button type="submit" class="btn">Place Order</button>
        </form>
        <br>
        <a href="CartServlet?id=${userId}" class="btn">Back to Cart</a>
    </div>
</body>
</html>