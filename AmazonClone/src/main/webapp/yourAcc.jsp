<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your Account - Amazon Clone</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <style>
        .account-section {
            border: 1px solid #ddd;
            padding: 20px;
            margin-bottom: 20px;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        .account-section h3 {
            margin-bottom: 15px;
            display: flex;
            align-items: center; /* Align items vertically */
        }
        .account-section h3 img {
            margin-right: 10px; /* Adjust spacing between logo and text */
            height: 30px; /* Adjust height of the logo */
        }
        .account-section a {
            display: block;
            margin-bottom: 10px;
            color: #007bff;
            text-decoration: none;
        }
    </style>
</head>
<body>

<header class="bg-dark text-white text-center py-3">
  <a href="homePage.jsp">
    <img src="images/logo.png" alt="Amazon Logo" style="height: 30px; margin-right: 10px;"></a>
    <h1>Your Account</h1>

</header>

<div class="container my-5">
    <div class="row">
        <div class="col-md-6 account-section">
            <h3><img src="images/s1.png" alt="Logo"> Orders</h3>
            
            <a href="UserOrder?name=${userName}&id=${id}">Your Orders</a>
            <a href="404.html">Track Orders</a>
            <a href="404.html">Returns & Refunds</a>
        </div>
        <div class="col-md-6 account-section">
            <h3><img src="images/s2.png" alt="Logo"> Login & Security</h3>
            <a href="emailUpdate.jsp">Change Email</a>
            
            <a href="passForget.jsp">Change Password</a>
        </div>
        <div class="col-md-6 account-section">
            <h3><img src="images/s3.png" alt="Logo"> Prime</h3>
            <a href="404.html">Manage Prime Membership</a>
        </div>
        <div class="col-md-6 account-section">
            <h3><img src="images/s4.png" alt="Logo"> Gift Cards</h3>
            <a href="404.html">Check Balance</a>
            <a href="404.html">Redeem Gift Card</a>
        </div>
        <div class="col-md-6 account-section">
            <h3><img src="images/s5.png" alt="Logo"> Your Addresses</h3>
            <a href="404.html">Manage Addresses</a>
        </div>
        <div class="col-md-6 account-section">
            <h3><img src="images/s6.png" alt="Logo"> Payment Options</h3>
            <a href="404.html">Manage Payment Methods</a>
        </div>
        <div class="col-md-6 account-section">
            <h3><img src="images/s7.png" alt="Logo"> Customer Service</h3>
            <a href="404.html">Help & Support</a>
        </div>
        <div class="col-md-6 account-section">
            <h3><img src="images/s8.png" alt="Logo"> Back To Home</h3>
            <a href="homePage.jsp">HomePage</a>
        </div>
    </div>
</div>

<footer class="bg-dark text-white text-center py-3">
    <p>© 2024, Amazon Clone</p>
</footer>

</body>
</html>
