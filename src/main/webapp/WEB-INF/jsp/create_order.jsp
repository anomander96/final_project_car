<jsp:useBean id="car" scope="request" type="com.example.final_project_car.model.entity.Car"/>
<jsp:useBean id="user" scope="request" type="com.example.final_project_car.model.entity.User"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Order</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
    <body>
            <div>
                <form action="controller?command=user_orders" method="post">

                    <div class="card" style="width: 18rem;">
                        <img class="card-img-top" src="https://ic.maxabout.us//cars/fiat/bravo//fiat_bravo_12.jpg" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Your order for ${car.brandName} ${car.modelName}</h5>
                            <p class="card-text"><strong>Now lets check your details</strong></p>
                            <p class="card-text">Client name: <strong>${user.firstName} ${user.lastName}</strong></p>
                            <p class="card-text">Need a driver? <input type="checkbox"></p>
                            <p class="card-text">Select the rent hours you need:</p>
                            <input type="text" id="rentHours" name="rentHours"><br>
                            <p></p>
                            <input type="hidden" id="carId" name="carId" value="${car.carId}">

                            <input type="submit" name="goToOrders" value="Go to your orders">
                        </div>
                    </div>
                </form>
            </div>
    </body>
</html>
