<%@ page import="model.Car" %><%--
  Created by IntelliJ IDEA.
  User: armanhambaryan
  Date: 16.01.26
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change Car</title>
</head>
<% Car car = (Car) request.getAttribute("car"); %>
<body>
<a href="/home">Home</a><br>
<a href="/cars">Cars</a>

<form action="changecar" method="post">
    <input type="hidden" name="id" value="<%=car.getId()%>">
    Brand: <input type="text" name="brand" value="<%=car.getBrand()%>"><br>
    Model: <input type="text" name="model" value="<%=car.getModel()%>"><br>
    Year: <input type="text" name="year" value="<%=car.getYear()%>"><br>
    DailyRate: <input type="text" name="dailyRate" value="<%=car.getDailyRate()%>"><br>
    Status: <input type="text" name="status" value="<%=car.getStatus()%>"><br>
    <input type="submit" value="Change Car">

</form>

</body>
</html>
