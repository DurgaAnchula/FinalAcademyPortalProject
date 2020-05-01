<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="right">
<h1>ACADEMY PORTAL</h1>
	<%-- batchID
    2. Skill ID
    3. Module ID
    4. Technology
    5. Faculty ID
    6. Batch Start Date
    7. Batch End Date
    8. Batch Capacity
    9. Classroom Name*/--%>


<div class="formdata">
<form:form action="batchreg" modelAttribute="batches" method="post">
<!-- First Name, Last Name, Age, Gender, Contact Number, Admin Id, Password -->
<h2>Batch Registration</h2>
<table>
<tr>
<td>SkillId:</td>
</tr>
<tr>
<td>ModuleId:</td>
</tr>
<tr>
<td>Technology:</td>
</tr>
<tr>
<td>FacultyId:</td>
</tr>
<tr>
<td>BatchStartDate:</td>
<td><form:input path="BatchStartDate" id="BatchStartDate" id="BatchStartDate"/></td>
</tr>
<tr>
<td>BatchEndDate:</td>
<td><form:input path="BatchEndDate" id="BatchEndDate" id="BatchEndDate"/>
</tr>
<tr>
<td>ClassRoomName:</td>
<td><form:input path="classroomname" id="classroomname" id="classroomname"/></td>
</tr>

</table>
</form:form>
</div>
</body>
</html>