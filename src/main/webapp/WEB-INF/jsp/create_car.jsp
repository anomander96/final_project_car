<%--
  Created by IntelliJ IDEA.
  User: andrew
  Date: 18.02.2021
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a car</title>
</head>
        <body>
            <form action="controller" method="post">
                <div class="container">
                    <div class="row centered-form">
                        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Create a new Admin</h3>
                                </div>
                                <div class="panel-body">
                                    <form role="form">
                                        <div class="row">
                                            <div class="col-xs-6 col-sm-6 col-md-6">
                                                <div class="form-group">
                                                    <input type="text" name="car_category_id" id="car_category_id" class="form-control input-sm" placeholder="Car category">
                                                </div>
                                            </div>
                                            <div class="col-xs-6 col-sm-6 col-md-6">
                                                <div class="form-group">
                                                    <input type="text" name="brand_name" id="brand_name" class="form-control input-sm" placeholder="Brand Name">
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <input type="text" name="model_name" id="model_name" class="form-control input-sm" placeholder="Model Name">
                                        </div>

                                        <div class="row">
                                            <div class="col-xs-6 col-sm-6 col-md-6">
                                                <div class="form-group">
                                                    <input type="text" name="color" id="color" class="form-control input-sm" placeholder="Color">
                                                </div>
                                            </div>
                                            <%--                                    <div class="col-xs-6 col-sm-6 col-md-6">--%>
                                            <%--                                        <div class="form-group">--%>
                                            <%--                                            <input type="password" name="password_confirmation" id="password_confirmation" class="form-control input-sm" placeholder="Confirm Password">--%>
                                            <%--                                        </div>--%>
                                            <%--                                    </div>--%>
                                        </div>

                                        <div class="row">
                                            <div class="col-xs-6 col-sm-6 col-md-6">
                                                <div class="form-group">
                                                    <input type="price" name="price" id="email" class="form-control input-sm" placeholder="Price">
                                                </div>
                                            </div>
                                        </div>

                                        <input type="submit" name="command" value="create_car" class="btn btn-info btn-block">

                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </body>
</html>
