<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/style1.css"/>
</head>
<body align="center">

<div class="formdata2">
<form action="skillmaper1" method="post">

<table>
<tr>
<td>
Select Skill :

<select name ="skill">
<c:forEach items="${skills}" var="skill">

<option>${skill.skillname}</option>
</c:forEach>
</select>
<br>
</td>
</tr>
</table>
<br>
<input type="submit" value="Map To Module">
</form>
</div>
</body>
</html>