
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin panel</title>
<%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">--%>
    <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
        <body>
        <%@include file="navbar_admin.jsp"%>

                <div class="jumbotron">
                    <center>
                    <h2 class="display-4">Hello, ${user.firstName}</h2>
                    <p class="lead">Welcome to admin panel</p>
                    </center>
                    <hr class="my-4">
                    <p>Choose option:</p>

                    <p class="lead">
                        <a class="btn btn-primary btn-lg" href="controller?command=go_to_create_admin" role="button">Create Admin</a>
                    </p>

                    <p class="lead">
                        <a class="btn btn-primary btn-lg" href="controller?command=go_to_create_car" role="button">Create Car</a>
                    </p>
                </div>


        </body>
</html>
