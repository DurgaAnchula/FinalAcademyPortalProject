<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BatchRequestList</title>
<link rel="stylesheet" type="text/css" href="/style1.css"/>
</head>
<body>
<div class="formdata1">
<h2>List of Requests</h2>

<c:forEach items="${list}" var="admin1">
<table border="1" class="t1">
<tr>
<th>BatchId</th>
<th>SkillId</th>
<th>ModuleId</th>
<th>Technology</th>
<th>BatchStartDate</th>
<th>BatchEnddate</th>
<th>BatchCapacity</th>
<th>ClassRoomName</th>
<th>Status</th>
</tr>
<tr>
<td>${admin1.getBatchId()}</td>
<td>${admin1.getSkillId()}</td>
<td>${admin1.getModuleId()}</td>
<td>${admin1.getTechnology()}</td>
<td>${admin1.getBatchStartDate()}</td>
<td>${admin1.getBatchEndDate()}</td>
<td>${admin1.getBatchCapacity()}</td>
<td>${admin1.classroom}</td>
<td>${admin1.getStatus()}</td>
</tr>
<tr>
<td colspan="7" align="center">
<a href="batchaccept1?name=${admin1.getBatchId()}"><button>Approve</button></a>
<a href="batchreject1?name=${admin1.getBatchId()}"><button>Reject</button></a>
</td>
</tr>
</table>
</c:forEach>
${message}
</div>
</body>
</html>