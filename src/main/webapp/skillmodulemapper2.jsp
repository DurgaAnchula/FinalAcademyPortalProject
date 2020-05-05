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
<body>
<div class="formdata2">
<form action="mapskillsandmodule1" method="post" >
<table>
<tr>
<td>
Skill Name : ${skill.skillname}
<input type="hidden" name="sid" value="${skill.skillid}">
Modules: 
<select name="module">

<c:forEach items="${mlist}" var="m">
<option value="${m.mid}">${m.mid }-${m.technology}-${m.proficiencylevel}-${m.executiontype}-${m.certificationtype}-${m.certificationname}</option>
</c:forEach>
</select>
</td>
</tr>
</table>
<input type="submit" value="Map"> 
</form>
</div>
</body>
</html>