<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Orders</title>
</head>
    <body>
        <div>
        <table>
           <thead>
           <tr>
           <th>Order ID</th>
           <th>User ID</th>
           <th>Order Status</th>
           <th>Create Date</th>
           <th>Driver</th>
           <th>Total Price</th>
           </tr>
           </thead>
            <c:forEach items="${orders}" var="order">
                <tr>
                    <td>${order.orderId}</td>
<%--                    <td>${order.userId}</td>--%>
<%--                    <td>${order.orderStatusId}</td>--%>
<%--                    <td>${order.createDate}</td>--%>
<%--                    <td>${order.withDriver}</td>--%>
<%--&lt;%&ndash;                    <td>${order.rentDuration}</td>&ndash;%&gt;--%>
<%--                    <td>${order.totalPrice}</td>--%>
                </tr>
            </c:forEach>
        </table>
        </div>
    </body>
</html>
