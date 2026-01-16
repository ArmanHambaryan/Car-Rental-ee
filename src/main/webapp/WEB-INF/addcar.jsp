<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add car</title>
</head>
<body>
<a href="/">Home </a>
<a href="/cars">Cars</a>

<form action="addcar" method="post">
    Brand : <input type="text" name="brand"><br>
    Model : <input type="text" name="model"><br>
    Year : <input type="text" name="year"><br>
    DailyRate : <input type="text" name="dailyRate"><br>
    Status : <select name="status">
    <option value="available">AVAILABLE</option>
    <option value="rented">RENTED</option>
    <option value="maintenance">MAINTENANCE</option>
</select><br>
    <input type="submit" value="Add car">


</form>


</body>
</html>
