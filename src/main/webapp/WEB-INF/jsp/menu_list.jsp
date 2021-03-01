<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
        <body>
        <%@include file="navbar_client.jsp"%>


        <center>
        <div class="jumbotron" align="center">
            <h2 class="display-4">Welcome, ${user.firstName}!</h2>
            <p>
                Our company provides car rental services. Get acquainted with our fleet and choose the car of your dreams
            </p>
            <p class="lead"></p>
            <hr class="my-4">
            <p class="lead">
                <form action="controller?command=cars_list&pageNumber=1" method="post">
                    <input class="btn btn-primary" type="submit" name="carsList" value="Choose car">
                </form>
            </p>
        </div>
        </center>

        <div class="container">

            <h1 class="font-weight-light text-center text-lg-left mt-4 mb-0">Some of our cars</h1>

            <hr class="mt-2 mb-5">

            <div class="row text-center text-lg-left">

                <div class="col-lg-3 col-md-4 col-6">
                    <a href="controller?command=cars_list&pageNumber=1" class="d-block mb-4 h-100">
                        <img class="img-fluid img-thumbnail" src="https://www.carouselrentacar.gr/wp-content/uploads/2017/10/TOYOTA_YARIS-400x300.png" alt="">
                    </a>
                </div>
                <div class="col-lg-3 col-md-4 col-6">
                    <a href="controller?command=cars_list&pageNumber=1" class="d-block mb-4 h-100">
                        <img class="img-fluid img-thumbnail" src="https://www.micauto.com/images/frota/51521634264_s.png" alt="">
                    </a>
                </div>
                <div class="col-lg-3 col-md-4 col-6">
                    <a href="controller?command=cars_list&pageNumber=1" class="d-block mb-4 h-100">
                        <img class="img-fluid img-thumbnail" src="https://www.abc-leasing.com/images/vehicle-page/cb8f0cb6-a362-40e9-8275-08848397b1b4/mercedes-benz-a-class-a-class-diesel-hatchback-a180d-amg-line-executive-5dr-auto.jpg" alt="">
                    </a>
                </div>
                <div class="col-lg-3 col-md-4 col-6">
                    <a href="controller?command=cars_list&pageNumber=1" class="d-block mb-4 h-100">
                        <img class="img-fluid img-thumbnail" src="https://www.abc-leasing.com/images/vehicle-page/87372c74-1d99-44b4-b819-14581a6b03a4/bmw-4-series-4-series-coupe-420i-m-sport-2dr--professional-media-.jpg" alt="">
                    </a>
                </div>
                <div class="col-lg-3 col-md-4 col-6">
                    <a href="controller?command=cars_list&pageNumber=1" class="d-block mb-4 h-100">
                        <img class="img-fluid img-thumbnail" src="https://acepickapart.com/wp-content/uploads/2020/06/edge-1-400x300.png" alt="">
                    </a>
                </div>
                <div class="col-lg-3 col-md-4 col-6">
                    <a href="controller?command=cars_list&pageNumber=1" class="d-block mb-4 h-100">
                        <img class="img-fluid img-thumbnail" src="https://thenewswheel.com/wp-content/uploads/2016/12/2012-Toyota-Prius-grey-exterior-car-400x300.jpg" alt="">
                    </a>
                </div>
                <div class="col-lg-3 col-md-4 col-6">
                    <a href="controller?command=cars_list&pageNumber=1" class="d-block mb-4 h-100">
                        <img class="img-fluid img-thumbnail" src="https://www.carouselrentacar.gr/wp-content/uploads/2014/12/FIAT_PANDA-400x300.png" alt="">
                    </a>
                </div>
                <div class="col-lg-3 col-md-4 col-6">
                    <a href="controller?command=cars_list&pageNumber=1" class="d-block mb-4 h-100">
                        <img class="img-fluid img-thumbnail" src="https://www.whatcar.com/car-leasing/images/imagery/large/dacia-sandero-hatchback-09-tce-essential-5dr_9073_400x525.jpg" alt="">
                    </a>
                </div>
                <div class="col-lg-3 col-md-4 col-6">
                    <a href="controller?command=cars_list&pageNumber=1" class="d-block mb-4 h-100">
                        <img class="img-fluid img-thumbnail" src="https://www.allsaveutah.com/wp-content/images/rental-car.jpg" alt="">
                    </a>
                </div>
                <div class="col-lg-3 col-md-4 col-6">
                    <a href="controller?command=cars_list&pageNumber=1" class="d-block mb-4 h-100">
                        <img class="img-fluid img-thumbnail" src="https://imgctcf.aeplcdn.com/thumbs/p-nc-k-ver202002061303/images/car-data/big/kia-carnival-15381.jpg" alt="">
                    </a>
                </div>
                <div class="col-lg-3 col-md-4 col-6">
                    <a href="controller?command=cars_list&pageNumber=1" class="d-block mb-4 h-100">
                        <img class="img-fluid img-thumbnail" src="https://www.firstcarrental.com.mt/assets/images/medium3.jpg" alt="">
                    </a>
                </div>
                <div class="col-lg-3 col-md-4 col-6">
                    <a href="controller?command=cars_list&pageNumber=1" class="d-block mb-4 h-100">
                        <img class="img-fluid img-thumbnail" src="https://www.firstcarrental.com.mt/assets/images/large3.jpg" alt="">
                    </a>
                </div>
            </div>
        </div>

        </body>
</html>
