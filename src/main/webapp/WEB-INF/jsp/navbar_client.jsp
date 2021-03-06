
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Navigation</title>
    <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script>
        // Prevent dropdown menu from closing when click inside the form
        $(document).on("click", ".navbar-right .dropdown-menu", function(e){
            e.stopPropagation();
        });
    </script>

    <style>
        body {
            font-family: 'Varela Round', sans-serif;
        }
        .form-control {
            box-shadow: none;
            border-radius: 4px;
        }
        .form-control:focus {
            border-color: #5c6ac4;
            box-shadow: 0 0 8px rgba(0,0,0,0.1);
        }

        .navbar {
            background: #fff;
            padding-left: 16px;
            padding-right: 16px;
            border-bottom: 1px solid #dfe3e8;
            border-radius: 0;
        }
        .nav img {
            border-radius: 50%;
            width: 36px;
            height: 36px;
            margin: -8px 0;
            float: left;
            margin-right: 10px;
        }
        .navbar .navbar-brand, .navbar .navbar-brand:hover, .navbar .navbar-brand:focus {
            padding-left: 0;
            font-size: 20px;
            padding-right: 50px;
        }
        .navbar .navbar-brand b {
            font-weight: bold;
            color: #5c6ac4;
        }
        .navbar .form-inline {
            display: inline-block;
        }
        .navbar ul.nav li {
            position: relative;
        }
        .navbar ul.nav li a {
            color: #888;
        }
        .search-box {
            position: relative;
        }
        .search-box input {
            padding-right: 35px;
            border-color: #dfe3e8;
            border-radius: 4px !important;
            box-shadow: none
        }
        .search-box .input-group-addon {
            min-width: 35px;
            border: none;
            background: transparent;
            position: absolute;
            right: 0;
            z-index: 9;
            padding: 7px;
            height: 100%;
        }
        .search-box i {
            color: #a0a5b1;
            font-size: 19px;
        }
        .navbar .nav .btn-primary, .navbar .nav .btn-primary:active {
            color: #fff;
            background: #5c6ac4;
            padding-top: 8px;
            padding-bottom: 6px;
            border-radius: 4px;
            vertical-align: middle;
            border: none;
            min-width: 120px;
            margin-top: 8px;
        }
        .navbar .navbar-right li:first-child a {
            padding-right: 30px;
        }
        .navbar .nav .btn-primary:hover, .navbar .nav .btn-primary:focus {
            color: #fff;
            outline: none;
            background: #5765c1;
        }
        .search-box .btn span {
            transform: scale(0.9);
            display: inline-block;
        }
        .navbar ul li i {
            font-size: 18px;
        }
        .navbar .dropdown-menu i {
            font-size: 16px;
            min-width: 22px;
        }
        .navbar ul.nav li.active a, .navbar ul.nav li.open > a {
            background: transparent !important;
        }
        .navbar .dropdown-menu {
            border-radius: 1px;
            border-color: #e5e5e5;
            box-shadow: 0 2px 8px rgba(0,0,0,.05);
        }
        .navbar .nav .dropdown-menu li a, .navbar .nav .dropdown-menu li a:hover, .navbar .nav .dropdown-menu li a:focus {
            padding: 8px 20px;
            line-height: normal;
        }
        .navbar .navbar-form {
            border: none;
        }
        .navbar .navbar-form-wrapper {
            padding: 0 15px;
        }
        .navbar .login-form label {
            color: #888;
            font-weight: normal;
        }
        .navbar .dropdown-menu.login-form {
            width: 280px;
            padding: 20px;
            left: auto;
            right: 0;
            font-size: 14px;
        }
        .navbar .nav .dropdown-menu.login-form a {
            padding: 0 !important;
            color: #5c6ac4;
            font-weight: normal;
        }
        .navbar .nav .dropdown-menu.login-form a:hover{
            text-decoration: underline;
        }
        .navbar .dropdown-menu.login-form .checkbox-inline {
            margin-top: 10px;
        }
        @media (min-width: 1200px){
            .form-inline .input-group {
                width: 300px;
                margin-left: 30px;
            }
        }
        @media (max-width: 768px){
            .navbar .dropdown-menu.login-form {
                width: 100%;
                padding: 10px 15px;
                background: transparent;
                border: none;
            }
            .navbar .form-inline {
                display: block;
            }
            .navbar .input-group {
                width: 100%;
            }
            .navbar .nav .btn-primary, .navbar .nav .btn-primary:active {
                display: block;
            }
        }
    </style>
</head>
        <body>
        <nav class="navbar navbar-default navbar-expand-lg navbar-light">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Car<b>Rental</b></a>
                <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
                    <span class="navbar-toggler-icon"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <!-- Collection of nav links, forms, and other content for toggling -->
            <div id="navbarCollapse" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li><a href="controller?command=go_to_home_page">Home</a></li>
                    <li><a href="controller?command=user_profile">My Profile</a></li>

                    <li class="active"><a href="controller?command=go_to_user_orders">My orders</a></li>
                    <%--<li><a href="#">Blog</a></li>
                    <li><a href="#">Contact</a></li>--%>
                </ul>
<%--                <form class="navbar-form form-inline">--%>
<%--                    <div class="input-group search-box">--%>
<%--                        <input type="text" id="search" class="form-control" placeholder="Search here...">--%>
<%--                        <span class="input-group-addon"><i class="material-icons">&#xE8B6;</i></span>--%>
<%--                    </div>--%>
<%--                </form>--%>
                <ul class="nav navbar-nav navbar-right">

<%--                    <li>admin: ${user.firstName}</li>--%>
                    <li><a href="controller?command=logout" class="btn btn-primary mt-1 mb-1">Logout</a></li>
                </ul>
            </div>
        </nav>
        </body>
</html>
