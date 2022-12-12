<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Update registration</h2>
<form action="update" method="post">
email<input type="text" name="email" value="<%=request.getAttribute("email") %>">
city<input type="text" name="city" value="<%=request.getAttribute("city") %>">
<input type="submit" value="update">
</form>
</body>
</html>