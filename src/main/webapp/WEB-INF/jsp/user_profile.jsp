<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" scope="request" type="com.example.final_project_car.model.entity.User"/>
<html>
<head>
    <title>Your profile</title>
</head>
    <body>
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
