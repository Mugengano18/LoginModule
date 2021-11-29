<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
response.setHeader("cache-control","no-cache,no-store,must-revalidate value");
response.setHeader("Progrma", "no-cahe");///HTTO 1.0;
response.setHeader("Expires", "0");//proxies

if(session.getAttribute("username") == null){
	response.sendRedirect("LoginForm.jsp");
}
%>
<h1>Welcome Welcome</h1>
<form action="Logout" method="post">
<input type="submit" value="Logout">
</form>
</body>
</html>