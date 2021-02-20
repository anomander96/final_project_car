<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" scope="request" type="com.example.final_project_car.model.entity.User"/>

<html>
<head>
    <title>Your profile</title>
    <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
    <body>
    <%@include file="navbar_client.jsp"%>
        <h2>Welcome ${user.firstName}</h2>
        <table border="1">
            <thead>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Login</th>
                <th>Password</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Passport</th>
<%--                <th>Is Blocked</th>--%>
            </tr>
            </thead>
            <tr>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.login}</td>
                <td>${user.password}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
                <td>${user.passport}</td>
            </tr>
        </table>
    </body>
</html>
