<%--
  Created by IntelliJ IDEA.
  User: armanhambaryan
  Date: 16.01.26
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Customer</title>
</head>
<body>
<a href="/">Home</a><br>
<a href="customers">Customers</a>

<form action="addcustomer" method="post">
    Name : <input type="text" name="name"><br>
    SurName : <input type="text" name="surname"><br>
    LicneseNUmber : <input type="text" name="licensenumber"><br>
    Phone : <input type="text" name="phone"><br>
    Email : <input type="text" name="email"><br>
    <input type="submit" value="Add Customer">


</form>



</body>
</html>
