<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Home</title>
<link rel="stylesheet" type="text/css" href="/style1.css">
</head>
<body class="header1">
<%
Long userid =(Long) session.getAttribute("name");
if(userid==null)
{
	response.sendRedirect("/employee/");
}
%>
<h1>Welcome <span><%=session.getAttribute("name")%></span></h1>
<ul class="a">
<li><a href="#" class="a1">My learnings</a></li><br>
<li><a href="skillsearch" class="a1">SearchPage</a><br>
<li><a href="#" class="a1">sortings</a></li><br>
<li><a href="#" class="a1">Batch Nomination</a></li><br>
<li><a href="#" class="a1">E-learning Nomination</a></li><br>
<li><a href="employeelogout" class="a1">Logout</a></li>
</ul>
</body>
</html>