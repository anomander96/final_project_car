<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Accidents</title>
</head>
        <body>
        <%@include file="navbar_client.jsp"%>
        <table class="table table-striped table-hover" id="carsTable">
            <thead>
            <tr>
                <th>Accident ID</th>
                <th>Accident Category</th>
                <th>Order ID</th>
                <th>Description</th>
                <th>Accident Time</th>
                <th>Additional Fee</th>
                <th>Accident Payment</th>
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
                        <form action="controller?command=make_payment" method="post">
                            <input type="submit" name="make_payment" value="Pay">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        </body>
</html>
