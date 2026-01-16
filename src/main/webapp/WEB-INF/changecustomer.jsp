<%@ page import="model.Customer" %><%--
  Created by IntelliJ IDEA.
  User: armanhambaryan
  Date: 16.01.26
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change Customer</title>
</head>
<% Customer customer = (Customer) request.getAttribute("customer"); %>
<body>
<a href="/home">Home</a><br>
<a href="/customers">Customers</a>


<form action="changecustomer" method="post">
    <input type="hidden" name="id" value="<%=customer.getId()%>">
    Name: <input type="text" name="name" value="<%=customer.getName()%>"><br>
    SurName: <input type="text" name="surname" value="<%=customer.getSurname()%>"><br>
    LicenseNumber <input type="text" name="licensenumber" value="<%=customer.getLicenseNumber()%>"><br>
    Phone: <input type="text" name="phone" value="<%=customer.getPhone()%>"><br>
    Email: <input type="text" name="email" value="<%=customer.getEmail()%>"><br>
    <input type="submit" value="Change Customer">

</form>

</body>
</html>
