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

<c:forEach items="${list}" var="admin1">
<table border="1" class="t1">
<tr>
<th>FirstName</th>
<th>LastName</th>
<th>DOB</th>
<th>Contact Number</th>
<th>Email</th>
<th>UserId</th>
<th>Gender</th>
<th>SkillId</th>
<th>Skillfamily</th>
<th>SkillName</th>
<th>proficiencylevel</th>
<th>TeachingTime</th>
<th>Status</th>
</tr>
<tr>
<td>${admin1.getFirstName()}</td>
<td>${admin1.getLastName()}</td>
<td>${admin1.getDOB()}</td>
<td>${admin1.getContactNumber()}</td>
<td>${admin1.getEmail()}</td>
<td>${admin1.getUserId()}</td>
<td>${admin1.getGender()}</td>
<td>${admin1.getSkillid()}</td>
<td>${admin1.getSkillfamily()}</td>
<td>${admin1.getSkillname()}</td>
<td>${admin1.getProficiencylevel()}</td>
<td>${admin1.getTeachingtime()}</td>
<td>${admin1.getStatus()}</td>
</tr>
<tr>
<td colspan="7" align="center">
<a href="accept1?name=${admin1.getUserId()}"><button>Approve</button></a>
<a href="reject1?name=${admin1.getUserId()}"><button>Reject</button></a>
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
<a href="logout"><button>Back</button></a>
</html>