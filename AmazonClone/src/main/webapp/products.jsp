<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.amazon.RegisterUser"%>
<%@ page import="com.amazon.Product"%>
<%@ page import="com.amazon.ProductDAO"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Products Page</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: Arial, sans-serif;
	background-color: #f0f2f5;
}

.container {
	max-width: 1300px;
	margin: 0 auto;
	padding: 5px 20px;
}

.site-header {
	background-color: #232f3e;
	color: #ffffff;
	padding: 5px 0;
}

.header-content {
	display: flex;
	align-items: center;
}

.logo img {
	height: 30px;
	margin-right: 30px;
}

.search-bar input[type="text"] {
	padding: 6px;
	border: none;
	width: 280px;
	border-radius: 3px;
	margin-right: 10px;
}

.search-bar button {
	padding: 8px 20px;
	background-color: #febd69;
	margin-right: 5px;
	border: none;
	border-radius: 3px;
	color: #232f3e;
	cursor: pointer;
}

.site-nav ul {
	list-style-type: none;
	display: flex;
}

.site-nav ul li {
	margin-right: 20px;
}

.site-nav ul li a {
	color: #ffffff;
	text-decoration: none;
}

.user-info {
	margin-left: 40px;
	display: flex;
	align-items: center;
}

.user-info span {
	margin-right: 10px;
}

.user-info a {
	color: #ffffff;
	text-decoration: none;
}

/* Main content styles */
.products-container {
	display: grid;
	grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
	gap: 20px;
}

.product {
	border: 2px solid #ccc;
	padding: 5px;
	margin-bottom: 5px;
	width: 280px;
	height: 330px;
	display: inline-block;
	vertical-align: top;
}

.product img {
	max-width: 100%;
	height: 160px;
}

button-container {
	display: inline-block;
}

.button-container form {
	display: inline;
	margin-right: 25px;
	/* Optional: Adds some spacing between the buttons */
}

.product h3 {
	font-size: 18px;
	margin-bottom: 10px;
}

.product p {
	margin-bottom: 10px;
}

.product button {
	padding: 15px 10px;
	background-color: #febd69;
	border: none;
	border-radius: 3px;
	color: #232f3e;
	cursor: pointer;
	margin-right: 11px;
}

/* Footer styles */
.site-footer {
	background-color: #232f3e;
	color: #ffffff;
	padding: 20px 0;
	margin-top: 20px;
	text-align: center;
}

.footer-nav ul {
	list-style-type: none;
	display: flex;
	justify-content: center;
	margin-bottom: 10px;
}

.footer-nav ul li {
	margin-right: 20px;
}

.footer-nav ul li a {
	color: #ffffff;
	text-decoration: none;
}

.copyright {
	margin-top: 10px;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="app.js"></script>

</head>
<body>
	<!-- Header -->
	<header class="site-header">
		<div class="container">
			<div class="header-content">
				<div class="logo">
					<img src="images/logo.png" alt="Amazon Logo" height="20px">
				</div>
				<div class="search-bar">
					<input type="text" placeholder="Search...">
					<button>Search</button>
				</div>
				<nav class="site-nav">
					<ul>
						<li><a href="homePage.jsp">Home</a></li>
						<li><a href="order.jsp">Your Orders</a></li>

						<li><a href="cart.jsp">Cart</a></li>
					</ul>
				</nav>
				<div class="user-info">
					<span>Welcome, ${param.name} &nbsp &nbsp
						&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span> <a href="login.html">Sign
						Out</a>

				</div>
			</div>
		</div>
	</header>


	<main class="container">
		<h1>Product List</h1>


		<div>
		

			<%
			ProductDAO productDAO = new ProductDAO();
			RegisterUser reg = new RegisterUser();
			%>
			<%
			List<Product> products = productDAO.getProductList();
			%>

			<%
			for (Product product : products) {
			%>
			<div class="product">
				<img src="images/<%=product.getImageName()%>"
					alt="<%=product.getProductName()%>">
				<h3><%=product.getProductName()%></h3>

				<p>
					<strong>Category:</strong>
					<%=product.getCategory()%></p>
				<p>

					<strong>Price:</strong> Rs:
					<%=product.getPrice()%></p>
				<div class="button-container">
					<form action="AddToCartServlet" method="post">
						<input type="hidden" name="productId" value="<%=product.getId()%>">
						<input type="hidden" name="name" value="${param.name}"> <input
							type="hidden" name="id" value="${param.id}">

						<button type="submit">Add to Cart</button>
					</form>
					<form action="UserCheckOut" method="post">
						<input type="hidden" name="productId" value="<%=product.getId()%>">
						<input type="hidden" name="name" value="${param.name}"> <input
							type="hidden" name="id" value="${param.id}">
						<button type="submit">Buy Now</button>
					</form>
				</div>
			</div>
			
			<%
			}
			%>
		</div>
	</main>

	<footer class="site-footer">
		<div class="container">
			<nav class="footer-nav">
				<ul>
					<li><a href="#">About Us</a></li>
					<li><a href="#">Careers</a></li>
					<li><a href="#">Privacy Policy</a></li>
					<li><a href="#">Terms of Service</a></li>
				</ul>
			</nav>
			<div class="copyright">&copy; 2024 Your Amazon Clone Project</div>${param.id}
			
		</div>
	</footer>
</body>
</html>