<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="car" scope="request" type="com.example.final_project_car.model.entity.Car"/>

<html>
<head>
    <title>Car Info</title>
</head>
        <body>
<%--        <h3>Good choice, ${user.firstName}</h3>--%>
        <p>This ${car.modelName} is one of the best cars of </p>





        <form action="controller?command=go_to_order_page" method="post">
<%--            <input type="hidden" id="userId" name="userId" value="${user.userId}">--%>
            <input type="hidden" id="carId" name="carId" value="${car.carId}">
            <input type="submit" name="createOrder" value="Create order">
        </form>
        </body>
</html>
