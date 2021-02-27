<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Sign Up</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="js/validator.js"></script>

    <style>
        body {
            color: #fff;
            background: #3598dc;
            font-family: 'Roboto', sans-serif;
        }
        .form-control{
            height: 41px;
            background: #f2f2f2;
            box-shadow: none !important;
            border: none;
        }
        .form-control:focus{
            background: #e2e2e2;
        }
        .form-control, .btn{
            border-radius: 3px;
        }
        .signup-form{
            width: 390px;
            margin: 30px auto;
        }
        .signup-form form{
            color: #999;
            border-radius: 3px;
            margin-bottom: 15px;
            background: #fff;
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            padding: 30px;
        }
        .signup-form h2 {
            color: #333;
            font-weight: bold;
            margin-top: 0;
        }
        .signup-form hr {
            margin: 0 -30px 20px;
        }
        .signup-form .form-group{
            margin-bottom: 20px;
        }
        .signup-form input[type="checkbox"]{
            margin-top: 3px;
        }
        .signup-form .row div:first-child{
            padding-right: 10px;
        }
        .signup-form .row div:last-child{
            padding-left: 10px;
        }
        .signup-form .btn{
            font-size: 16px;
            font-weight: bold;
            background: #3598dc;
            border: none;
            min-width: 140px;
        }
        .signup-form .btn:hover, .signup-form .btn:focus{
            background: #2389cd !important;
            outline: none;
        }
        .signup-form a{
            color: #fff;
            text-decoration: underline;
        }
        .signup-form a:hover{
            text-decoration: none;
        }
        .signup-form form a{
            color: #3598dc;
            text-decoration: none;
        }
        .signup-form form a:hover{
            text-decoration: underline;
        }
        .signup-form .hint-text {
            padding-bottom: 15px;
            text-align: center;
        }
    </style>
</head>
        <body>
                <div class="signup-form">
                    <form action="controller?command=registration" method="post">
                        <h2>Sign Up</h2>
                        <p>Please fill in this form to create an account!</p>
                        <hr>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-xs-6">
                                    <input type="text" id="first_name" class="form-control"
                                           onchange="validateFirstName()"
                                           name="first_name" placeholder="First Name" required="required">
                                </div>
                                <div class="col-xs-6">
                                    <input type="text" id="last_name" class="form-control"
                                           onchange="validateLastName()"
                                           name="last_name" placeholder="Last Name" required="required">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <input type="text" id="login" class="form-control"
                                   onchange="validateLogin()"
                                   name="login" placeholder="Login" required="required">
                        </div>
                        <div class="form-group">
                            <input type="password" id="password" class="form-control" onchange="validatePassword()"
                                   name="password" placeholder="Password" required="required">
                        </div>
                        <div class="form-group">
                            <input type="email" id="email" class="form-control"
                                   name="email" onchange="validateEmail()" placeholder="Email" required="required">
                        </div>
                        <div class="form-group">
                            <input type="tel" id="phone" class="form-control"
                                   name="phone" onchange="validatePhone()" placeholder="Phone" required="required">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="passport" placeholder="Passport ID" required="required">
                        </div>

                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-lg">Sign Up</button>
                        </div>
                    </form>
                    <div class="hint-text">Already have an account? <a href="controller?command=login">Login here</a></div>
                </div>
        </body>
</html>
