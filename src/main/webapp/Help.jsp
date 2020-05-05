<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>ACADEMY PORTAL</h1>
<div class="formdata">
<form:form action="helpreq" modelAttribute="help" method="post">
<table>
<h2>Help</h2>
<tr>
<td>Issue:</td>
<td><form:input path="issue" id="issue"/></td>
</tr>
<tr>
<td>Description:</td>
<td><form:textarea path="description" id="description" rows="10" cols="10"/></td>
</tr>
</table>
<input type="submit" value="submit" class="formsubmitbutton"/><br><br>
</form:form>
${message}
</body>
</html>