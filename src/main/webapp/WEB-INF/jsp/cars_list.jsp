<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Cars list</title>
</head>
<body>
<header>
    <%@include file="/WEB-INF/jsp/header.jsp"%>
    <%--                add a correct header when user is logged --%>
</header>
<h1>Cars list</h1>
<h3>Choose your car</h3>
<div>
    <table border="1">
        <thead>
        <tr>
            <th>Car category</th>
            <th>Brand Name</th>
            <th>Model Name</th>
            <th>Color</th>
            <th>Price</th>
            <th>Quick Order</th>
        </tr>
        </thead>

        <c:forEach items="${cars}" var="car">
            <tr>
                <td>${car.carCategoryId}</td>
                <td>${car.brandName}</td>
                <td>${car.modelName}</td>
                <td>${car.color}</td>
                <td>${car.price}</td>
                <td>
                    <form action="controller?command=car_info" method="post">
                        <input type="hidden" id="carId" name="carId" value="${car.carId}">
                    <input type="submit" name="BookButton" value="Book">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

