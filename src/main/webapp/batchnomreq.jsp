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
<div class="nominations">

<table border="2">

<tr>
<th>Employee Id</th>
<th>Employee Name</th>
</tr>
<c:forEach items="${emplist}" var="emp">

<tr>
<td>${emp.userId}</td>
<td>${emp.firstName}</td>
</tr>

</c:forEach>

</table>


</div>

<div class="nominations">

<table border="2">

<tr>
<th>Batch Id</th>
</tr>
<c:forEach items="${list }" var="batch">
<tr>
<td>${batch.batchId }</td>
</tr>
</c:forEach>

</table>
</div>

<div class="nominations">

<table border="2">

<tr>
<th>Status</th>
<th>Action</th>
</tr>
<c:forEach items="${brlist }" var="br">
<tr>
<td>${br.status }</td>
<td><a href="nomaccept?nomid=${br.nominationid}">Accept</a></td>
</tr>
</c:forEach>

</table>

</div>

<%-- <div class="formdata1">
<h2>List of Requests</h2>

<c:forEach items="${list}" var="admin1">
<table border="1" class="t1">
<tr>
<th>EmployeeId</th>
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
<td>${admin1.getUserId()}</td>
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
<a href="batchaccept2?name=${admin1.getUserId()}"><button>Approve</button></a>
<a href="batchreject2?name=${admin1.getUserId()}"><button>Reject</button></a>
</td>
</tr>
</table>
</c:forEach>
${message}
</div> --%>
</body>
</html>