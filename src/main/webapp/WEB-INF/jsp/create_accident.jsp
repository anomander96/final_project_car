
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Accident</title>
    <style>
        body {
            color: #fff;
            background: #3598dc;
            font-family: 'Roboto', sans-serif;
        }
        .form-control{
            height: 41px;
            background: #f2f2f2;
            box-shadow: none !important;
            border: none;
        }
        .form-control:focus{
            background: #e2e2e2;
        }
        .form-control, .btn{
            border-radius: 3px;
        }
        .signup-form{
            width: 390px;
            margin: 30px auto;
        }
        .signup-form form{
            color: #999;
            border-radius: 3px;
            margin-bottom: 15px;
            background: #fff;
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            padding: 30px;
        }
        .signup-form h2 {
            color: #333;
            font-weight: bold;
            margin-top: 0;
        }
        .signup-form hr {
            margin: 0 -30px 20px;
        }
        .signup-form .form-group{
            margin-bottom: 20px;
        }
        .signup-form input[type="checkbox"]{
            margin-top: 3px;
        }
        .signup-form .row div:first-child{
            padding-right: 10px;
        }
        .signup-form .row div:last-child{
            padding-left: 10px;
        }
        .signup-form .btn{
            font-size: 16px;
            font-weight: bold;
            background: #3598dc;
            border: none;
            min-width: 140px;
        }
        .signup-form .btn:hover, .signup-form .btn:focus{
            background: #2389cd !important;
            outline: none;
        }
        .signup-form a{
            color: #fff;
            text-decoration: underline;
        }
        .signup-form a:hover{
            text-decoration: none;
        }
        .signup-form form a{
            color: #3598dc;
            text-decoration: none;
        }
        .signup-form form a:hover{
            text-decoration: underline;
        }
        .signup-form .hint-text {
            padding-bottom: 15px;
            text-align: center;
        }
    </style>
</head>
        <body>
               <%@include file="navbar_admin.jsp"%>

               <div class="signup-form">
                   <form action="controller?command=create_accident" method="post">
                       <h3>Accident creation</h3>
                       <hr>
                       <div class="form-group">
                           <input type="text" class="form-control" name="accident_category_id" placeholder="Accident Category ID (1-5)" required="required">
                       </div>
                       <div class="form-group">
                           <input type="text" class="form-control" name="order_id" placeholder="Order ID" required="required">
                       </div>
                       <div class="form-group">
                           <input type="text" class="form-control" name="description" placeholder="Add a short description" required="required">
                       </div>
                       <div class="form-group">
                           <input type="text" class="form-control" name="cost_per_damage" placeholder="Additional fee for a client" required="required">
                       </div>
                       <div class="form-group">
                           <button type="submit" class="btn btn-primary btn-lg">Add Accident</button>
                       </div>
                   </form>
               </div>
        </body>
</html>
