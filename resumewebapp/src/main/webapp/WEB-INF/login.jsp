<%--
  Created by IntelliJ IDEA.
  User: Zohrab
  Date: 2/5/2021
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%--<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>

<html>
<head>
    <title>Admin Login</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body class="login_background">

<form action="login" method="POST">
    <div class="col-4 container login_fix_">
        <center>
            <h1>Login:</h1>
        </center>
        <div class="form-group">
            <label>Email address</label>
            <input type="email" class="form-control" placeholder="email@example.com" name="username"/>
        </div>

        <div class="form-group">
            <label>Password</label>
            <input type="password" class="form-control" name="password" placeholder="Password" />

        </div>
        <button type="submit" class="btn btn-primary" name="login">Login</button>
    </div>

</form>

</body>
</html>
