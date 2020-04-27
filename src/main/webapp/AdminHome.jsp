<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
<link rel="stylesheet" type="text/css" href="/style1.css">
</head>
<body class="header1">
<%
Long userid =(Long) session.getAttribute("name");
if(userid==null)
{
	response.sendRedirect("/admin/");
}
%>

<div class="header">
<h1>Welcome <span><%=session.getAttribute("name")%></span></h1>
<ul class="a">
<li><a href="req" class="a1">Faculty Registration Request</a></li><br>
<li><a href="skills" class="a1">Skills Registration</a></li><br>
<li><a href="modules" class="a1">Module Registration</a></li><br>
<li><a href="#" class="a1">skill/Module Mapping</a></li><br>
<li><a href="#" class="a1">Batch Registration</a></li><br>
<li><a href="#" class="a1">Batch Nomination Request</a></li><br>
<li><a href="#" class="a1">Report Management</a></li><br>
<li><a href="#" class="a1">Help Requests</a></li><br>
<li><a href="logout" class="a1">Logout</a></li>
</ul>
</div>
</body>
</html>