<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Accidents</title>
    <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
        <body>
            <%@include file="navbar_admin.jsp"%>


            <table class="table table-striped table-hover" id="carsTable">
                <thead>
                <tr>
                    <th>Accident ID</th>
                    <th>Accident Category</th>
                    <th>Order ID</th>
                    <th>Description</th>
                    <th>Accident Time</th>
                    <th>Additional Fee</th>
                    <th>Delete Accident</th>
                </tr>
                </thead>

                <c:forEach items="${accidents}" var="accident">

                    <tr>
                        <td>${accident.accidentId}</td>

                        <c:if test="${accident.accidentCategoryId == 1}">
                        <td>SINGLE-CAR COLLISION</td>
                        </c:if>
                        <c:if test="${accident.accidentCategoryId == 2}">
                            <td>HEAD-ON COLLISION</td>
                        </c:if>
                        <c:if test="${accident.accidentCategoryId == 3}">
                            <td>VEHICLE ROLLOVER</td>
                        </c:if>
                        <c:if test="${accident.accidentCategoryId == 4}">
                            <td>MULTIPLE-VEHICLE COLLISION</td>
                        </c:if>
                        <c:if test="${accident.accidentCategoryId == 5}">
                            <td>SIDESWIPE COLLISION</td>
                        </c:if>
                        <td>${accident.orderId}</td>
                        <td>${accident.description}</td>
                        <td>${accident.accidentTime}</td>
                        <td>${accident.costPerDamage}$</td>
                        <td>
                            <form action="controller?command=delete_accident" method="post">
                                <input type="hidden" name="accident_id" value="${accident.accidentId}">
                            <input type="submit" name="delete_accident" value="Delete">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </body>
</html>
