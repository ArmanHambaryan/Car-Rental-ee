<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: armanhambaryan
  Date: 16.01.26
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>

</head>
<% User user = (User) session.getAttribute("user"); %>

<body>
<a href="/addcar">Add Car </a> <br>
<a href="/addcustomer">Add Customer</a><br>
<a href="/addrental">Add Rental</a> <br>
<% if (user == null) { %>
<a style="color: black" href="/login">Login</a> | <a style="color: black" href="/register">Register</a>
<% } else { %>
<span style="color: black">Welcome <%=user.getName() + " " + user.getSurname()%></span> <a
        style="color:black;" href="/logout">Logout</a>
<%}%>


</body>
</html>
