<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Module Registration page</title>
<link rel="stylesheet" type="text/css" href="/style1.css"/>

</head>

<body>
<h1>ACADEMY PORTAL</h1>

<div class="formdata">
<form:form name="modulesform" onclick="return validate()" action="modulereg" modelAttribute="modules" method="post">
<!-- First Name, Last Name, Age, Gender, Contact Number, Admin Id, Password -->
<h2>Modules Registration</h2>
<table>

<tr>
<td>Technology</td>
<td><form:input path="Technology" id="technology" name="technology"/></td>
</tr>
<tr>
<td>Proficiency Level</td>
<td><form:input path="Proficiencylevel" id="Proficiencylevel" name="Proficiencylevel"/></td>
</tr>
<tr>
<td>Execution Type:</td>
<td>
<form:select path="Executiontype" id="executiontype" name="executiontype" class="select-box">
<option   selected="selected" value="e-learning">E-Learning</option>
  <option value="classroomtraining">ClassRoom Training</option>
</form:select>
</td>
</tr>
<tr>
<td>Certification Type:</td>
<td>
<form:select path="Certificationtype" id="certificationtype" name="certificationtype" class="select-box">
<option   selected="selected" value="internal">Internal</option>
  <option value="external">External</option>
</form:select>
</td>
</tr>

<tr>
<td>CertificationName:</td>
<td><form:input path="certificationname" id="certificationname" name="certificationname"/></td>
</tr>
<tr>
</table>
<input type="submit" value ="Register" class="formsubmitbutton"/>
</form:form>
</div>
<br>
<a href="logout" class="a2">Back</a><br>
${message}



<script type="text/javascript">

function validate(){
	var technology=document.forms["modulesform"]["Technology"];
	if(technology.value=='')
		{
		technology.style.border="2px solid red";
	alert("please update the mandatory fields");	
	return false
		}
	
	var executiontype=document.forms["modulesform"]["Executiontype"];
	if(executiontype.value=='')
	{
	executiontype.style.border="2px solid red";
alert("please update the mandatory fields");	
return false
	}

	var certificationtype=document.forms["modulesform"]["certificationtype"];
	if(certificationtype.value=='')
	{
		certificationtype.style.border="2px solid red";
alert("please update the mandatory fields");	
return false
	}
	var certificationname=document.forms["modulesform"]["certificationname"];
	if(certificationname.value=='')
	{
		certificationname.style.border="2px solid red";
alert("please update the mandatory fields");	
return false
	}
}
</script>
</body>
</html>--%>