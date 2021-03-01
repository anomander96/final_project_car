<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Cars list</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>

    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <script>
        if(document.getElementById('driver').checked) {
            document.getElementById('hiddenDriver').disabled = true;
        }
    </script>
</head>
<body>
<%@include file="navbar_client.jsp"%>
<h3>Choose your car</h3>

    <main class="m-3">
        <div>
            <table class="table table-striped table-hover" id="carsTable">
                <thead>
                <tr>
                    <th onclick="sortTable(0)">Car Class</th>
                    <th onclick="sortTable(1)">Brand Name</th>
                    <th onclick="sortTable(2)">Model Name</th>
                    <th onclick="sortTable(3)">Color</th>
                    <th onclick="sortTable(4)">Price/Day</th>
                    <th>Need A Driver?</th>
<%--                    <th>Choose Rent Date</th>--%>
                    <th>Rent Duration(Days)</th>
                    <th>Quick Order</th>
                </tr>
                </thead>

                <c:forEach items="${cars}" var="car">

                    <tr>
                        <c:if test="${car.carCategoryId == 1}">
                        <td>City Car (A class)</td>
                        </c:if>

                        <c:if test="${car.carCategoryId == 2}">
                            <td>Supermini (B class)</td>
                        </c:if>

                        <c:if test="${car.carCategoryId == 3}">
                            <td>Small Family (C class)</td>
                        </c:if>

                        <c:if test="${car.carCategoryId == 4}">
                            <td>Large Family (D class)</td>
                        </c:if>

                        <c:if test="${car.carCategoryId == 5}">
                            <td>Luxury (E class)</td>
                        </c:if>

                        <td>${car.brandName}</td>
                        <td>${car.modelName}</td>
                        <td>${car.color}</td>
                        <td>${car.price}$</td>
                        <form action="controller?command=create_order" method="post">
                        <td>
                            <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input" name ="withDriver" value="true" id="driver">
                                <input type="hidden" class="custom-control-input" name="withDriver" value="false" id="hiddenDriver">
                            <label class="custom-control-label">Yes/No</label>
                            </div>
                        </td>
                            <td>
                                <input type="number" name="rentDuration">
                            </td>
                        <td>
                                <input type="hidden" id="carId" name="carId" value="${car.carId}">
                                <input type="hidden" id="userId" name="userId" value="${user.userId}">
                            <input type="submit" name="BookButton" value="Order">
                        </td>
                        </form>
                    </tr>
                </c:forEach>
            </table>

            <center>
            <nav aria-label="Cars navigation">
                <ul class="pagination">
                    <c:if test="${currentPage != 1}">
                        <li class="page-item"><a class="page-link"
                         href="controller?command=cars_list&pageNumber=${currentPage - 1}">Previous</a>
                        </li>
                    </c:if>

                    <c:forEach begin="1" end="${numberOfPages}" var="i">
                        <c:choose>
                            <c:when test="${currentPage == i}">
                                <li class="page-item active"><a class="page-link">${i}
                                    <span class="sr-only">(current)</span></a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item active"><a class="page-link"
                                    href="controller?command=cars_list&pageNumber=${i}">${i}</a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

            <%--For displaying Next link --%>
                    <c:if test="${currentPage < numberOfPages}">
                        <li class="page-item"><a lass="page-link"
                            href="controller?command=cars_list&pageNumber=${currentPage + 1}">Next</a>
                        </li>
                    </c:if>
                </ul>
            </nav>
            </center>
        </div>
    </main>


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
                    switchcount ++;
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

