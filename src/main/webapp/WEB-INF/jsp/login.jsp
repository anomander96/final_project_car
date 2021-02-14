<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Login</title>

        <style>
            /*@import url(https://fonts.googleapis.com/css?family=Prosto+One);*/

            *
            {
                -webkit-transition: all 0.3s ease;
            }

            body
            {
                overflow: hidden;
                margin: 0px;
                padding: 0px;
                font-family: 'Prosto One', cursive;

                /*background: url('https://subtlepatterns.com/patterns/egg_shell.png');*/
                /*_background: #eee;*/
            }

            #login-form
            {
                color: #777;
                border: 0px solid #afafaf;
                width: 30%;
                margin-left: 35%;
                margin-top: 120px;
                text-align: center;
                padding: 40px;
                padding-top: 20px;
                border-radius: 3px;
                box-shadow: 0px 0px 8px #777;
                background: rgba(255, 255, 255, 0.6);
            }

            input
            {
                color: #777;
                font-weight: bold;
                width: 70%;
                padding: 10px;
                margin: 10px;
                border: 1px solid #afafaf;
                border-radius: 3px;
                background: rgba(255, 255, 255, 0.5);
                outline: none;
            }

            input[type="button"]
            {
                color: white;
                width: 30%;
                border: 0px solid transparent;
                outline: none;
                cursor: pointer;
            }

            #login
            {
                background: #51AC74;
            }

            #register
            {
                background: #5C8AE6;
            }
        </style>
    </head>

    <body>
<%--        <div id="login-form">--%>
<%--            <h3>Login</h3>--%>
<%--            <form action="controller" method="post">--%>
<%--            <input type="text" name="login" placeholder="Login"/>--%>
<%--            <br>--%>
<%--            <input type="password" name="password" placeholder="Password" />--%>
<%--            <br>--%>
<%--            <input type="submit" name="command" id="login" value="login" />--%>
<%--            </form>--%>
<%--        </div>--%>

        <div>
            <form class="form-signin" action="controller" method="POST">
                <h1 class="h3 mb-3 font-weight-normal">Form</h1>
<%--                <label for="login"><fmt:message key="loginInput" /></label>--%>
                <input type="text" id="login" class="form-control" placeholder="Login" name="login">

<%--                <label for="pass"><fmt:message key="passwordInput" /></label>--%>
                <input type="password" id="pass" class="form-control mt-1" placeholder="Password" name="password">

                <button class="btn btn-lg btn-primary btn-block my-3" type="submit" name="command" value="login">GO</button>
            </form>
        </div>

    </body>
</html>
