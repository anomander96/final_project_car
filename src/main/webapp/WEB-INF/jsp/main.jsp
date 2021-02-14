<%@page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Main</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <style>
        body {
            background: url('https://subtlepatterns.com/patterns/egg_shell.png');
            _background: #eee;
        }
    </style>
</head>
    <body>
<%--        &lt;%&ndash;  Блок зі слоганом під нього можна додати скриптик-галерею    &ndash;%&gt;--%>
<%--        <div>--%>
<%--            <h1>Rent A Car With Us</h1>--%>
<%--            <p>A best choices of cars only here</p>--%>
<%--            <p>Get yous right now</p>--%>
<%--        </div>--%>

<%--        &lt;%&ndash; Кнопка переходу в каталог, там вже редірект в каталог, далі користувач собі скролить та обирає машину--%>
<%--             біля іконок машин буде кнопка ореду, при натисканні фільтр, який перевіряє чи користувач залогінився&ndash;%&gt;--%>
<%--        <button>Choose your car</button>--%>

<html>
        <body>
        <header>
            <div>
                <%@include file="/WEB-INF/jsp/header.jsp" %>
            </div>
        </header>
        <%--        <jsp:forward page="WEB-INF/jsp/main.jsp"></jsp:forward>--%>
        <!-- some main content of index page here -->
        <div>
            <h1>Car rental app</h1>
            <h2>Welcome</h2>
        </div>

        <div>
            <button>
<%--                <a href="controller?command=login">Choose a car</a>--%>
                <a href="/WEB-INF/jsp/login.jsp">GO</a>
            </button>
        </div>


        <footer>
            <div>
                <%@include file="/WEB-INF/jsp/footer.jsp" %>
            </div>
        </footer>



    </body>
</html>
