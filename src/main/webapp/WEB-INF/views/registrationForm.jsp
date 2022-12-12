<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Enter your details !</h2>
<form action="registrationcontroller"  method="post">
<table>

<tr>
   <td>Name</td>
   <td><input type="text" name="name"></td>
</tr>

<tr>
   <td>Email ID</td>
   <td><input type="text" name="email"></td>
</tr>

<tr>
   <td>City</td>
   <td><input type="text" name="city"></td>
</tr>

<tr>
   <td>Phone Number</td>
   <td><input type="text" name="phone"></td>
</tr>

<tr>
   
   <td><input type="submit" value="Save"></td>
</tr>
    

<%
if(request.getAttribute("msg")!=null){
	out.println(request.getAttribute("msg"));
}
%>





</table>

</form>




</body>
</html>