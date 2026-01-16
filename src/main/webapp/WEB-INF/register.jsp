<%--
  Created by IntelliJ IDEA.
  User: armanhambaryan
  Date: 16.01.26
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<a href = "/home">Home</a>

<% String message = (String) session.getAttribute("message");%>
<% if (message != null && !message.isEmpty()) { %>
<p style="color: red"><%=message%>
</p>
<%session.removeAttribute("message");%>
<%}%>
<form action="/register" method="post">
  <input type="text" name="name" placeholder="Name"><br>
  <input type="text" name="surname" placeholder="Surname"><br>
  <input type="text" name="username" placeholder="Username"><br>
  <input type="password" name="password" placeholder="Password"><br>
  Role <select name="role">
  <option value="ADMIN">Admin</option>
  <option value="USER">User</option>
</select><br>
  <input type="submit" value="Register">
</form>

</body>
</html>
