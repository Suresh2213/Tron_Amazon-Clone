<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Password</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        * {
            margin: 0;
            padding: 0;
            font-family: "Amazon Ember", Arial, sans-serif;
        }
        .container {
            width: 390px;
            margin: 0 auto;
            border: 1px solid #ddd;
            padding: 20px;
            border-radius: 8px;
            font-family: "Amazon Ember", Arial, sans-serif;
        }
        .a-box-inner {
            border-radius: 8px;
            background-color: #fff;
            box-shadow: 0 0 0 4px #fffae7 inset;
            padding: 20px;
            position: relative;
        }
        h1 {
            font-weight: 400;
            font-size: 24px;
            margin-bottom: 15px;
        }
        p {
            font-family: Arial, sans-serif;
            margin-bottom: 15px;
        }
        input[type="email"] {
            width: 97%;
            height: 35px;
            border: 1px solid #a6a6a6;
            border-radius: 3px;
            padding: 5px;
            margin-bottom: 15px;
            margin-top: 5px;
        }
        input[type="submit"] {
            width: 100%;
            height: 38px;
            background-color: #f1c860;
            border: 1px solid #a6a6a6;
            border-radius: 3px;
            cursor: pointer;
        }
        a {
            text-decoration: none;
            color: #0066c0;
        }
        a:hover {
            text-decoration: underline;
        }
        .error-message, .success-message {
            color: red;
            border: 1px solid red;
            padding: 10px;
            border-radius: 5px;
            margin-bottom: 15px;
            background-color: #fbe9e9;
        }
        .success-message {
            color: green;
            border: 1px solid green;
            background-color: #e9fbe9;
        }
        footer {
            margin-top: 20px;
            text-align: center;
        }
        .a-divider {
            margin: 20px 0;
        }
        .a-divider-inner {
            height: 1px;
            background: #ddd;
        }
        img {
            height: 45px;
            width: 140px;
            display: block;
            margin-top: 10px;
            margin-left: auto;
            margin-right: auto;
        }
        .link:hover {
            color: orange;
        }
    </style>
</head>
<body>
    <a href="#"><img src="https://zeevector.com/wp-content/uploads/LOGO/Amazon-India-Logo-PNG-HD.png" alt="amazon"></a>
    <br><br>
    <div class="container">
        <div class="a-box-inner">
        <%
                String errorMessage = (String) request.getAttribute("errorMessage");
                if (errorMessage != null) {
            %>
                <div class="error-message">
                    <p>There was a problem</p>
                    <p><%= errorMessage %></p>
                </div>
            <%
                }
                String successMessage = (String) request.getAttribute("successMessage");
                if (successMessage != null) {
            %>
                <div class="success-message">
                    <p><%= successMessage %></p>
                </div>
            <%
                }
            %>
        </div><br>
            <h1>Update Email</h1>
            <form   action="UpdateEmailNew" method="post">
                <input type="hidden" name="identifier" value="<%= request.getAttribute("identifier") %>">
                <label for="email" class="a-form-label"><b>New Email</b></label>
                <input type="email" name="email" placeholder="New email" required>
                <input type="submit" value="Update Email">
            </form>
            <br>
            <a class="link"  href="yourAcc.html">Back To Account</a>
        <footer>
            <a class="link" href="#">Conditions of Use</a> | 
            <a class="link" href="#">Privacy Notice</a> | 
            <a class="link" href="#">Help</a>
            <br><br>
            <p>© 1996-2024, Amazon.com, Inc. or its affiliates</p>
        </footer>
    </div>
</body>
</html>
