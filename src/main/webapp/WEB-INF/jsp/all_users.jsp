<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Users</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>

    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
        <body>
        <%@include file="navbar_admin.jsp" %>
                <table class="table table-striped table-hover" id="carsTable">
                    <thead>
                    <tr>
                        <th>User ID</th>
                        <th>User Role</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Login</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Status</th>
                    </tr>
                    </thead>

                    <c:forEach items="${users}" var="user">

                        <tr>
                            <td>${user.userId}</td>
                            <c:if test="${user.userRoleId == 1}">
                                <td>CLIENT</td>
                            </c:if>
                            <c:if test="${user.userRoleId == 2}">
                                <td>ADMIN</td>
                            </c:if>
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>
                            <td>${user.login}</td>
                            <td>${user.email}</td>
                            <td>${user.phone}</td>
                            <c:if test="${user.isBlocked == false}">
                                <td>Active</td>
                            </c:if>
                            <c:if test="${user.isBlocked == true}">
                                <td>Blocked</td>
                            </c:if>
                            <td>
                                <form action="controller?command=block_user" method="post">
                                    <input type="hidden" name="user_id" value="${user.userId}">
                                    <input type="submit" name="block_user" value="Block">
                                </form>
                            </td>
                            <td>
                                <form action="controller?command=delete_user" method="post">
                                    <input type="hidden" name="user_id" value="${user.userId}">
                                    <input type="submit" name="delete_user" value="Delete">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
        </body>
</html>
