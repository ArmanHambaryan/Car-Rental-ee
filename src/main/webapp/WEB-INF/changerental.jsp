<%@ page import="model.Rental" %><%--
  Created by IntelliJ IDEA.
  User: armanhambaryan
  Date: 16.01.26
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change Rental</title>
</head>
<% Rental rental = (Rental) request.getAttribute("rental"); %>
<body>
<a href="/home">Home</a><br>
<a href="/rentals">Rentals</a>


<form action="changerental" method="post">
    <input type="hidden" name="id" value="<%=rental.getId()%>">
    Carid: <input type="number" name="carid" value="<%=rental.getCarId()%>"><br>
    Customerid: <input type="number" name="customerid" value="<%=rental.getCustomerId() %>"><br>
   Startdate: <input type="date" name="startdate" value="<%=rental.getStartDate()%>"><br>
    EndDate: <input type="date" name="enddate" value="<%=rental.getEndDate()%>"><br>
   TotalCost: <input type="number" name="totalcost" value="<%=rental.getTotalCost()%>"><br>
    StatusRental: <input type="text" name="statusRental" value="<%=rental.getStatus()%>"><br>
    <input type="submit" value="Change Rental">

</form>

</body>
</html>
