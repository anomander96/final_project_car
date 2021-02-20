<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Orders</title>
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
</head>
    <body>
    <%@include file="navbar_client.jsp"%>
        <div>
        <table class="table table-striped table-hover">
           <thead>
           <tr>
           <th>Order ID</th>
           <th>User ID</th>
           <th>Order Status</th>
           <th>With Driver</th>
           <th>Rent Hours</th>
           <th>Total Price</th>
           </tr>
           </thead>
            <c:forEach items="${orders}" var="order">
                <tr>
                    <td>${order.orderId}</td>
                    <td>${order.userId}</td>

                    <c:if test="${order.orderStatusId == 1}">
                    <td>PENDING</td>
                    </c:if>

                    <c:if test="${order.withDriver == false}">
                    <td>NO</td>
                    </c:if>

                    <c:if test="${order.withDriver == true}">
                        <td>YES</td>
                    </c:if>

                    <td>${order.rentDuration}</td>
                    <td>${order.totalPrice}</td>
                </tr>
            </c:forEach>
        </table>
        </div>
    </body>
</html>
