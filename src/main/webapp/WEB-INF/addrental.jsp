<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Rental</title>
</head>
<body>
<a href="/">Home </a>
<a href="/rentals">Rentals</a>


<form action="addrental" method="post">
    Carid : <input type="text" name="carid"><br>
    Customerid: <input type="text" name="customerid"><br>
    StartDate: <input type="date" name="startdate"><br>
    EndDate: <input type="date" name="enddate"><br>
    TotalCost: <input type="number" name="totalcost"><br>
    Status : <select name="statusRental">
    <option value="active">ACTIVE</option>
    <option value="completed">COMPLETED</option>
    <option value="cancelled">CANCELLED</option>
</select><br>

    <input type="submit" value="Add Rental">


</form>


</body>
</html>
