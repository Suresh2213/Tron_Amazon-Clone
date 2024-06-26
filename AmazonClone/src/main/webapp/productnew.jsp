<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Item Added to Cart</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f0f2f5;
    text-align: center;
}

.container {
    max-width: 600px;
    margin: 50px auto;
    padding: 20px;
    background-color: #fff;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0,0,0,0.1);
}

h1 {
    color: #232f3e;
}

.message {
    margin-bottom: 20px;
    font-size: 18px;
}

.buttons {
    margin-top: 20px;
    display: flex;
    flex-direction: column;
    align-items: center;
}

.buttons button {
    padding: 10px 20px;
    margin-bottom: 10px;
    border: none;
    border-radius: 3px;
    background-color: #febd69;
    color: #232f3e;
    cursor: pointer;
    width: 200px;
}

.buttons button:hover {
    background-color: #f0e5c3;
}
</style>
</head>
<body>
<div class="container">
    <h1>Item Added to Cart</h1>
    <p class="message">The item has been successfully added to your cart.</p>
    <div class="buttons">
        <form action="CartServlet" method="get">
            <input type="hidden" name="name" value="${userName}">
            <input type="hidden" name="id" value="${id}">
            <button type="submit">Show Cart</button>
        </form>
        <button onclick="location.href='homePage.jsp';">Back to Home</button>
    </div>
</div>
</body>
</html>
