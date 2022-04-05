<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>             
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight List</title>
</head>
<body>
<br>
<a href=HomePage.jsp style="color:black;text-decoration:none;font-size:35px;fontweight:bold;">Flight Booking</a>
<br><br>
<%
HttpSession sessiona = request.getSession(false);
@SuppressWarnings("unchecked")
List<String[]> flights=(List<String[]>)sessiona.getAttribute("flights");
if(flights!=null){
%>
<h1>Available Flights</h1>
<table border="1">
<tr>
<th>Name</th>
<th>Time</th>
<th>Price</th>
</tr>
<%
for(String[] flight:flights){
%>
<tr>
<td><%=flight[0]%></td>
<td><%=flight[1]%></td>
<td><%=flight[2]%></td>
</tr>
</table>
<a href=BookFlight.jsp>Book Now</a>
<%
}
%>
<%
}
else{
%>
<h1>There are no available flights</h1>
<%
}
%>
</body>
</html>