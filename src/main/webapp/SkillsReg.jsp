<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Skills Registration page</title>
<link rel="stylesheet" type="text/css" href="/style1.css"/>
<script type="text/javascript">

function validate(){
	var skillfamily=document.forms["skillsform"]["skillfamily"];
	if(skillfamily.value=='')
		{
		skillfamily.style.border="2px solid red";
	alert("please update the mandatory fields");	
	return false
		}
	

	var skillname=document.forms["skillsform"]["skillname"];
	if(skillname.value=='')
	{
	skillname.style.border="2px solid red";
alert("please update the mandatory fields");	
return false
	}
	

}

</script>
</head>

<body align="right">
<h1>ACADEMY PORTAL</h1>
</div>
<div class="formdata">
<form:form name="skillsform" onsubmit="return validate()" action="skillsreg" modelAttribute="skills" method="post">
<!-- First Name, Last Name, Age, Gender, Contact Number, Admin Id, Password -->
<table>
<h2>skills Registration</h2>
<tr>
<td>Skill family:</td>
<td>
<form:select path="skillfamily" id="skillfamily" name="skillfamily" class="select-box">
<option   selected="selected" value="technical">Technical</option>
  <option value="functional">Functional</option>
  <option value="behavioral">Behavioural</option>
</form:select>
</td>
</tr>
<tr>
<td>SkillName:</td>
<td><form:input path="skillname" id="skillname" name="skillname"/></td>
</tr>
</table>
<input type="submit" value ="Register" class="formsubmitbutton"/>
<a href="logout" class="a2">Back</a>
</form:form>
${message}
</body>
</html>