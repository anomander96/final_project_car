<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Cars</title>
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
        <th>Car ID</th>
        <th onclick="sortTable(0)">Car Class</th>
        <th onclick="sortTable(1)">Brand Name</th>
        <th onclick="sortTable(2)">Model Name</th>
        <th onclick="sortTable(3)">Color</th>
        <th onclick="sortTable(4)">Price/Day</th>
        <th>Update Car</th>
        <th>Delete Car</th>
    </tr>
    </thead>

    <c:forEach items="${cars}" var="car">

        <tr>
            <td>${car.carId}</td>
            <td>${car.carCategoryId}</td>
            <td>${car.brandName}</td>
            <td>${car.modelName}</td>
            <td>${car.color}</td>
            <td>${car.price}$</td>
            <td>
                <form action="controller?command=go_to_update_car" method="post">
                    <input type="hidden" name="car_id" value="${car.carId}">
                <input type="submit" name="update_car" value="Update">
                </form>
            </td>
            <td>
                <form action="controller?command=delete_car" method="post">
                    <input type="hidden" name="car_id" value="${car.carId}">
                <input type="submit" name="delete_car" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>


<script>
    function sortTable(n) {
        var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
        table = document.getElementById("carsTable");
        switching = true;
        // Set the sorting direction to ascending:
        dir = "asc";
        /* Make a loop that will continue until
        no switching has been done: */
        while (switching) {
            // Start by saying: no switching is done:
            switching = false;
            rows = table.getElementsByTagName("TR");
            /* Loop through all table rows (except the
            first, which contains table headers): */
            for (i = 1; i < (rows.length - 1); i++) {
                // Start by saying there should be no switching:
                shouldSwitch = false;
                /* Get the two elements you want to compare,
                one from current row and one from the next: */
                x = rows[i].getElementsByTagName("TD")[n];
                y = rows[i + 1].getElementsByTagName("TD")[n];
                /* Check if the two rows should switch place,
                based on the direction, asc or desc: */
                if (dir === "asc") {
                    if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                        // If so, mark as a switch and break the loop:
                        shouldSwitch = true;
                        break;
                    }
                } else if (dir === "desc") {
                    if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                        // If so, mark as a switch and break the loop:
                        shouldSwitch = true;
                        break;
                    }
                }
            }
            if (shouldSwitch) {
                /* If a switch has been marked, make the switch
                and mark that a switch has been done: */
                rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                switching = true;
                // Each time a switch is done, increase this count by 1:
                switchcount++;
            } else {
                /* If no switching has been done AND the direction is "asc",
                set the direction to "desc" and run the while loop again. */
                if (switchcount === 0 && dir === "asc") {
                    dir = "desc";
                    switching = true;
                }
            }
        }
    }
</script>
</body>
</html>
