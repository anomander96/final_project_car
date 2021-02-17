<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="new_header.jsp"%>

<html>
<head>
    <title>Title</title>
</head>
        <body>
            <header>
<%--                <%@include file="/WEB-INF/jsp/header.jsp"%>--%>
<%--                add a correct header when user is logged --%>
            </header>
            <h1>Menu_list</h1>
            <h3>Choose your car</h3>
            <form action="controller?command=cars_list" method="post">
<%--                <input type="hidden" id="userId" name="userId" value="${user.userId}">--%>
                <input type="submit" name="carsList" value="Go to a car list">
            </form>

            <form action="controller?command=create_order" method="post">

            </form>
        </body>
</html>
