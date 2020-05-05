<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/style1.css">

<style type="text/css">
.form-popup {
  display: none;
  position: fixed;
  top: 0;
  width:auto;
  border: 3px solid #f1f1f1;
  z-index: 9;
}

/* Add styles to the form container */
.form-container {
  max-width: 600px;
  padding: 10px;
  background-color: white;
}

/* Full-width input fields */
.form-container input[type=text], .form-container input[type=password] {
  width: 100%;
  padding:5px;

  border: none;
  background: #f1f1f1;
}

/* When the inputs get focus, do something */
.form-container input[type=text]:focus, .form-container input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Set a style for the submit/login button */
.form-container .btn {
  background-color: #4CAF50;
  color: white;
  
  border: none;
  
  width: 100%;
  margin-bottom:10px;
  opacity: 0.8;
}

/* Add a red background color to the cancel button */
.form-container .cancel {
  background-color: red;
}

/* Add some hover effects to buttons */
.form-container .btn:hover, .open-button:hover {
  opacity: 1;
}

</style>
<meta charset="ISO-8859-1">
<title>Admin Home</title>

<script type="text/javascript">

function openForm()
{

	document.getElementById("moduleform").style.display = "block";
	}

function closeForm() {
	  document.getElementById("moduleform").style.display = "none";
	}

function validate(){
	
	var technology=document.forms["modulesform"]["technology"];
	
	if(technology.value=='')
		{
		technology.style.border="2px solid red";
	alert("please update the mandatory fields");	
	return false
		}
	
	var executiontype=document.forms["modulesform"]["executiontype"];
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
</head>
<body class="header1">
<%
Long userid =(Long) session.getAttribute("name");
if(userid==null)
{
	response.sendRedirect("/admin/");
}
%>

<div class="header">
<h1>Welcome <span><%=session.getAttribute("name")%></span></h1>
<ul class="a">
<li><a href="req" class="a1">Employee Registration Request</a></li><br>
<li><a href="req1" class="a1">Faculty Registration Request</a></li><br>
<li><a href="skills" class="a1">Skills Registration</a></li><br>
<li><button  onclick="openForm()">Module Registration</button></li><br>
<li><a href="mapModuleskill" class="a1">skill/Module Mapping</a></li><br>
<li><a href="batches" class="a1">Batch Registration</a></li><br>
<li><a href="#" class="a1">Batch Nomination Request</a></li><br>
<li><a href="Report.jsp" class="a1">Report Management</a></li><br>
<li><a href="#" class="a1">Help Requests</a></li><br>
<li><a href="adminlogout" class="a1">Logout</a></li>
</ul>
</div>


<div class="form-popup" id ="moduleform">
<h2>Modules Registration</h2>
<form name="modulesform" onsubmit="return validate()" action="modulereg"  method="post" class="form-container">
<!-- First Name, Last Name, Age, Gender, Contact Number, Admin Id, Password -->

<table>

<tr>
<td>Technology</td>
<td><input type="text" id="technology" name="technology"/></td>
</tr>
<tr>
<td>Proficiency Level</td>
<td><input type="text" id="Proficiencylevel" name="Proficiencylevel"/></td>
</tr>
<tr>
<td>Execution Type:</td>
<td>
<select id="executiontype" name="executiontype" class="select-box">
<option   selected="selected" value="e-learning">E-Learning</option>
  <option value="classroomtraining">ClassRoom Training</option>
</select>
</td>
</tr>
<tr>
<td>Certification Type:</td>
<td>
<select  id="certificationtype" name="certificationtype" class="select-box">
<option   selected="selected" value="internal">Internal</option>
  <option value="external">External</option>
</select>
</td>
</tr>

<tr>
<td>CertificationName:</td>
<td><input type="text" id="certificationname" name="certificationname"/></td>
</tr>
<tr>
<td>
<button type="submit"  class="btn formsubmitbutton ">Register</button>
<button type="button" class="btn cancel formsubmitbutton" onclick="closeForm()">Close</button>
</td>
</tr>
</table>
</form>
</div>





</body>
</html>