<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RegistrationRequestList</title>
<link rel="stylesheet" type="text/css" href="/style1.css"/>
</head>
<body>
<div class="formdata1">
<h2>List of Requests</h2>

<c:forEach items="${list}" var="admin">
<table border="1" class="t1">
<tr>
<th>FirstName</th>
<th>LastName</th>
<th>DOB</th>
<th>Contact Number</th>
<th>Email</th>
<th>UserId</th>
<th>Gender</th>
<th>Status</th>
</tr>
<tr>
<td>${admin.getFirstName()}</td>
<td>${admin.getLastName()}</td>
<td>${admin.getDOB()}</td>
<td>${admin.getContactNumber()}</td>
<td>${admin.getEmail()}</td>
<td>${admin.getUserId()}</td>
<td>${admin.getGender()}</td>
<td>${admin.getStatus()}</td>
</tr>
<tr>
<td colspan="7" align="center">
<a href="accept?name=${admin.getUserId()}"><button>Accept</button></a>
<a href="reject?name=${admin.getUserId()}"><button>Reject</button></a>
</td>
</tr>
</table>
</c:forEach>
${message}
</div>
<%
RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
rd.include(request, response);
%>

</body>
</html>