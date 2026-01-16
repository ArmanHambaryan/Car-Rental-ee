<%@ page import="model.Customer" %>
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
    <title>Customers</title>
</head>

<% List<Customer> customers = (List<Customer>) request.getAttribute("customers"); %>

<body>
<a href="/home">Home</a>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>SurName</th>
        <th>LicneseNumber</th>
        <th>phone</th>
        <th>Email</th>
    </tr>
    <% for (Customer customer : customers) { %>
    <tr>
        <td><%=customer.getId() %>
        </td>
        <td><%=customer.getName()  %>
        </td>
        <td><%=customer.getSurname()  %>
        </td>
        <td><%=customer.getLicenseNumber() %>
        </td>
        <td><%=customer.getPhone() %>
        </td>
        <td><%= customer.getEmail()%>
        <td>
            <a href="deletecustomer?id=<%= customer.getId() %>" onclick="return confirm('Are you sure?');">Delete
            </a>
            <a href="changecustomer?id=<%= customer.getId() %>">Update</a>
        </td>

        </td>

    </tr>

    <%}%>
</table>

</body>
</html>
