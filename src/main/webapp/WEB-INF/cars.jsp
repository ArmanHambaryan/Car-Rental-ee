<%@ page import="java.util.List" %>
<%@ page import="model.Car" %>
<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: armanhambaryan
  Date: 16.01.26
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Car" %>
<html>
<head>
    <title>Cars </title>
</head>
<body>
<a href="/home">Home</a>
<% List<Car> cars = (List<Car>) request.getAttribute("cars"); %>
<% User user = (User) session.getAttribute("user");%>

<table>
    <tr>
        <th>Id</th>
        <th>Picture</th>
        <th>Brand</th>
        <th>Model</th>
        <th>Year</th>
        <th>DailyRate</th>
        <th>Status</th>
    </tr>
    <% for (Car car : cars) { %>
    <tr>
        <td><%= car.getId() %>
        </td>
        <td>
        <%if (car.getPictureName() == null || car.getPictureName().isEmpty()) {%>
        <img width="50" src="/img/img.png">
        <% } else { %>
        <img width="50" src="/getImage?picture_name=<%=car.getPictureName()%>">
            <%}%>
        </td>
        <td><%= car.getBrand() %>
        </td>
        <td><%= car.getModel() %>
        </td>
        <td><%= car.getYear() %>
        </td>
        <td><%= car.getDailyRate() %>
        </td>
        <td><%= car.getStatus() %>
        <td>
            <a href="deletecar?id=<%= car.getId() %>" onclick="return confirm('Are you sure?');">Delete
            </a>
            <a href="changecar?id=<%= car.getId() %>">Update</a>
        </td>

        </td>

    </tr>

    <%}%>
</table>
</body>
</html>
