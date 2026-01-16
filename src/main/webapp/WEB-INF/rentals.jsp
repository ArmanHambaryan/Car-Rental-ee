<%@ page import="model.Rental" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: armanhambaryan
  Date: 16.01.26
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rentals</title>
</head>
<body>
<a href="/home">Home</a>
<% List<Rental> rentals = (List<Rental>) request.getAttribute("rentals"); %>


<table>
    <tr>
        <th>Id</th>
        <th>CarId</th>
        <th>CustomerId</th>
        <th>StartDate</th>
        <th>EndDate</th>
        <th>TotalCost</th>
        <th>StatusRental</th>
    </tr>
    <% for (Rental rental : rentals) { %>
    <tr>
        <td><%= rental.getId() %>
        </td>
        <td><%= rental.getCarId() %>
        </td>
        <td><%= rental.getCustomerId() %>
        </td>
        <td><%= rental.getStartDate() %>
        </td>
        <td><%= rental.getEndDate() %>
        </td>
        <td><%= rental.getTotalCost() %>
        <td><%= rental.getStatus() %>
        <td>
            <a href="deleterental?id=<%= rental.getId() %>" onclick="return confirm('Are you sure?');">Delete
            </a>
            <a href="changerental?id=<%= rental.getId() %>">Update</a>
        </td>

        </td>

    </tr>

    <%}%>
</table>
</body>
</html>
