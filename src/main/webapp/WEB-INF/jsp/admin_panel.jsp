
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="navbar_admin.jsp"%>
<html>
<head>
    <title>Admin panel</title>
<%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">--%>
    <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
        <body>
                <div class="card" style="width: 18rem;">
                    <img class="card-img-top" src="..." alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Create a new Admin</h5>
<%--                        <p class="card-text"></p>--%>
                        <form action="controller?command=go_to_create_admin" method="post">
                        <input type="submit" name="createUser" value="Add admin">
<%--                        <a href="#" class="btn btn-primary">Go somewhere</a>--%>
                        </form>
                    </div>
                </div>

                <div class="card" style="width: 18rem;">
                    <img class="card-img-top" src="..." alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Add a new Car</h5>
                        <%--                        <p class="card-text"></p>--%>
                        <form action="controller?command=go_to_create_car" method="post">
                            <input type="submit" name="createUser" value="Add car">
                            <%--                        <a href="#" class="btn btn-primary">Go somewhere</a>--%>
                        </form>
                    </div>
                </div>

        </body>
</html>
