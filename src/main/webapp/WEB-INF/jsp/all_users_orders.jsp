<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Orders</title>
    <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
        <body>
        <%@include file="navbar_admin.jsp"%>
        <div>
            <table class="table table-striped table-hover">

                <thead>
                <tr>
                    <th>Order ID</th>
                    <th>User ID</th>
                    <th>Car ID</th>
                    <th>Order Status</th>
                    <th>With Driver</th>
                    <td>Order Time</td>
                    <th>Rent Duration</th>
                    <th>Total Price</th>
                    <th>Approve Order</th>
                    <th>Decline Order</th>
                    <th>Close Order</th>
                </tr>
                </thead>
                <c:forEach items="${orders}" var="order">
                    <tr>
                        <td>${order.orderId}</td>
                        <td>${order.userId}</td>
                        <td>${order.carId}</td>

                        <c:if test="${order.orderStatusId == 1}">
                            <td>PENDING</td>
                        </c:if>

                        <c:if test="${order.orderStatusId == 2}">
                            <td>APPROVED</td>
                        </c:if>

                        <c:if test="${order.orderStatusId == 3}">
                            <td>CANCELED</td>
                        </c:if>

                        <c:if test="${order.orderStatusId == 4}">
                            <td>PAID</td>
                        </c:if>

                        <c:if test="${order.orderStatusId == 5}">
                            <td>CLOSED</td>
                        </c:if>

                        <c:if test="${order.withDriver == false}">
                            <td>NO</td>
                        </c:if>

                        <c:if test="${order.withDriver == true}">
                            <td>YES</td>
                        </c:if>

                        <td>${order.createDate}</td>

                        <c:choose>
                            <c:when test="${order.rentDuration=='1'}">
                                <td>${order.rentDuration} day</td>
                            </c:when>
                            <c:otherwise>
                                <td>${order.rentDuration} days</td>
                            </c:otherwise>
                        </c:choose>

                        <td>${order.totalPrice}$</td>
                        <td>
                            <form action="controller?command=change_order_status_on_approved" method="post">
                            <input type="hidden" name="orderId" value="${order.orderId}">
                            <input type="submit" name="approve" value="Approve">
                            </form>
                        </td>
                        <td>
                            <form action="controller?command=change_order_status_on_canceled" method="post">
                                <input type="hidden" name="orderId" value="${order.orderId}">
                                <input type="submit" name="decline" value="Decline">
                            </form>
                        </td>
                        <td>
                            <form action="controller?command=change_order_status_on_closed" method="post">
                                <input type="hidden" name="orderId" value="${order.orderId}">
                                <input type="submit" name="close" value="Close">
                            </form>
                        </td>
                    </tr>
                </c:forEach>



<%--                <thead>--%>
<%--                <tr>--%>
<%--                    <th>Order ID</th>--%>
<%--                    <th>User ID</th>--%>
<%--                    <th>Order Status</th>--%>
<%--                    <th>With Driver</th>--%>
<%--                    <th>Rent Hours</th>--%>
<%--                    <th>Total Price</th>--%>
<%--                </tr>--%>
<%--                </thead>--%>
<%--                <c:forEach items="${orders}" var="order">--%>
<%--                    <tr>--%>
<%--                        <td>${order.orderId}</td>--%>
<%--                        <td>${order.userId}</td>--%>

<%--                        <c:if test="${order.orderStatusId == 1}">--%>
<%--                            <td>PENDING</td>--%>
<%--                        </c:if>--%>

<%--                        <c:if test="${order.withDriver == false}">--%>
<%--                            <td>NO</td>--%>
<%--                        </c:if>--%>

<%--                        <c:if test="${order.withDriver == true}">--%>
<%--                            <td>YES</td>--%>
<%--                        </c:if>--%>

<%--                        <td>${order.rentDuration}</td>--%>
<%--                        <td>${order.totalPrice}</td>--%>
<%--                    </tr>--%>
<%--                </c:forEach>--%>
            </table>
        </div>
        </body>
</html>
