<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@include file="new_header.jsp"%>--%>

<html>
<head>
    <title>Title</title>
    <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
        <body>
        <%@include file="navbar_client.jsp"%>

        <div class="jumbotron">
            <h2 class="display-4">Welcome, ${user.firstName}!</h2>
            <p class="lead"></p>
            <hr class="my-4">
            <p>Choose your car</p>
            <p class="lead">
                <form action="controller?command=cars_list&pageNumber=1" method="post">
                    <input class="btn btn-primary" type="submit" name="carsList" value="Go to car list">
                </form>
            </p>
        </div>

        </body>
</html>
