<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mobile Number Already in Use</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        * {
            margin: 0;
            padding: 0;
            font-family: "Amazon Ember", Arial, sans-serif;
        }
        .container {
            width: 390px;
            margin: 50px auto;
            border: 1px solid #ddd;
            padding: 20px;
            border-radius: 8px;
        }
        .a-box-inner {
            border-radius: 8px;
            background-color: #fff;
            box-shadow: 0 0 0 4px #fffae7 inset;
            padding: 20px;
            position: relative;
        }
        p {
            margin-bottom: 3px;
        }
        .a-icon-alert {
            height: 27px;
            width: 30px;
            position: absolute;
            left: 18px;
            top: 11px;
            background-image: url('https://m.media-amazon.com/images/G/01/x-locale/common/icons/sprite-site-wide-2-v2._CB276239818_.png');
            background-position: -283px -35px;
            background-repeat: no-repeat;
        }
        h4 {
            font-weight: 400;
            font-size: 17px;
            line-height: 1.255;
            color: #7c6200;
            margin-bottom: 15px;
        }	
        .error-message {
            color: red;
            font-size: 16px;
            margin-bottom: 20px;
        }
        a {
            text-decoration: none;
            color: #0066c0;
             margin-top: 5px;
        }
        a:hover {
            text-decoration: underline;
        }
        p.link:hover {
            color: orange;
        }
        footer {
            margin-top: 20px;
        }
        .a-divider.a-divider-section .a-divider-inner {
            height: 44px;
            margin-bottom: -18px;
            background: -webkit-linear-gradient(to bottom, rgba(0, 0, 0, .14), rgba(0, 0, 0, .03) 3px, transparent);
            background: linear-gradient(to bottom, rgba(0, 0, 0, .14), rgba(0, 0, 0, .03) 3px, transparent);
            z-index: 0;
            zoom: 1;
        }
        .ss:hover {
            cursor: pointer;
        }
       
        a:hover {
            text-decoration: underline;
        }
        .link:hover {
            color: orange;
        }
       
    </style>
</head>
<body>
    <div class="container">
        <div class="a-box-inner">
            <i class="a-icon a-icon-alert"></i>
            <h4 class="a-alert-heading">Mobile number already in use</h4>
            <div class="a-alert-content">
                <p class="error-message">
                    You indicated you are a new customer, but an account already exists with the mobile number <strong><%= request.getAttribute("mobileNumber") %></strong>
                </p>
                <p>Are you an existing customer?</p>
                <a class="link"  href="login.html">Sign-In</a>
                <br>
                <a  class="link"  href="passForget.html">Forgot your password?</a>
                <br>
                <br>
                <p>New to Amazon?</p>
                <a class="link" href="login.html">Create account with a different mobile number</a>
                <br><br><br>
                
                <div class="a-divider a-divider-section"><div class="a-divider-inner"></div></div>
                
                <footer>
                    <a class="link" href="#">Conditions of Use</a> | 
                    <a class="link" href="#">Privacy Notice</a> | 
                    <a class="link" href="#">Help</a>
                    <br><br>
                    <p>© 1996-2024, Amazon.com, Inc. or its affiliates</p>
                </footer>
            </div>
        </div>
    </div>
</body>
</html>
