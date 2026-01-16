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
    <title>Login</title>
</head>
<body>

<% String message = (String) session.getAttribute("message");%>
<% if (message != null && !message.isEmpty()) { %>
<p style="color: red"><%=message%>
</p>
<%session.removeAttribute("message");%>
<%}%>
<form action="/login" method="post">
  <input type="text" name="username" placeholder="Username"><br>
  <input type="password" name="password" placeholder="Password"><br>
  <input type="submit" value="Login">
</form>

</body>
</html>
