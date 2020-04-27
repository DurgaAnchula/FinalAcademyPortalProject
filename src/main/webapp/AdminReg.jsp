<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Registration page</title>
<link rel="stylesheet" type="text/css" href="/style1.css"/>
<script type="text/javascript">
function validate(){
	var firstname = document.forms["adminform"]["firstName"].value;
	if(firstname=='')
		{
	alert("please update the mandatory fields");	
	return false
		}
	var firstNamePattern = new RegExp("^[a-zA-Z0-9 ]{6,20}$");
	if(!firstNamePattern.test(firstname))
		{
		alert("Invalid First name");	
		return false
		}	
	var lastname = document.forms["adminform"]["lastName"].value;
	if(lastname=='')
		{
	alert("please update the mandatory fields");	
	return false
		}
	var lastNamePattern = new RegExp("^[a-zA-Z0-9 ]{6,20}$");
	if(!lastNamePattern.test(lastname))
		{
		alert("Invalid Last name");	
		return false
		}	
	var dob = document.forms["adminform"]["DOB"].value;
	if(dob=='')
		{
	alert("please update the mandatory fields");	
	return false
		}
	var DOBPattern = new RegExp("^([0-9]{2})-([0-9]{2})-([0-9]{4})$");
	if(!DOBPattern.test(dob))
		{
		alert("Invalid Date Of birth");	
		return false
		}	
	var gender = document.forms["adminform"]["gender"].value;
	if(gender=='')
		{
	alert("please update the mandatory fields");	
	return false
		}
	var contactno = document.forms["adminform"]["contactNumber"].value;
	if(contactno=='')
		{
	alert("please update the mandatory fields");	
	return false
		}
	var ContactnoPattern = new RegExp("^((\+[1-9]{1,4}[ \-]*)|(\([0-9]{2,3}\)[ \-]*)|([0-9]{2,4})[ \-]*)*?[0-9]{3,4}?[ \-]*[0-9]{3,4}?$");
	if(!ContactnoPattern.test(contactno))
		{
		alert("Invalid Contact Number");	
		return false
		}	
	var Email = document.forms["adminform"]["Email"].value;
	if(Email=='')
		{
	alert("please update the mandatory fields");	
	return false
		}
	var EmailPattern = new RegExp("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$");
	if(!EmailPattern.test(EmailPattern))
		{
		alert("Invalid Email");	
		return false
		}	
	var password = document.forms["adminform"]["password"].value;
	if(password=='')
		{
	alert("please update the mandatory fields");	
	return false
		}
	var PasswordPattern = new RegExp("^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{7,15}$");
	if(!PasswordPattern.test(password))
		{
		alert("Invalid password");	
		return false
		}	
	var answer = document.forms["adminform"]["answer"].value;
	if(answer=='')
		{
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
<form:form name="adminform" onsubmit="return validate()" action="adminreg" modelAttribute="admin" method="post">
<!-- First Name, Last Name, Age, Gender, Contact Number, Admin Id, Password -->
<table>
<h2>Admin Registration</h2>
<tr>
<td>FirstName:</td>
<td><form:input path="firstName" id="firstName" name="firstName" /></td>
</tr>
<tr>
<td>LastName:</td>
<td><form:input path="lastName" id="lastName" name="lastName" /></td>
</tr>
<tr>
<td>DateOfBirth:</td>
<td><form:input path="DOB" id="DOB" name="DOB"/></td>
</tr>
<tr>
<td>Gender:</td>
<td><form:radiobutton path="gender" value="female" id="gender" name="gender" />Female
<form:radiobutton path="gender" value="male" id="gender" name="gender" />Male
</td>
</tr>
<tr>
<td>Contact Number:</td>
<td><form:input path="contactNumber" id="contactNumber" name="contactNumber" />
</td>
</tr>
<tr>
<td>Email:</td>
<td><form:input path="Email" id="Email" name="Email" /></td>
</tr>
<tr>
<td>Password</td>
<td><form:input path="password" id="password" type="password"/>
</tr>
<tr>
<td>Secret Question:</td>
<td>
<form:select path="secretQuestion" id="secretQuestion" class="select-box" >
<option  selected="selected" value="What is your Birthdate?">What is your Birthdate?</option>
  <option value="In which school you have studied first?">In which school you have studied first?</option>
  <option value="What is your favourite movie?">What is your favourite movie?</option>
</form:select>
</td>
</tr>
<tr>
<td colspan="2" align="right">
<form:input path="answer" id="answer" name="answer" placeholder="Answer" width="170px" />
</td>
</tr>
</table>
<input type="submit" value ="submit" class="formsubmitbutton"/>
</form:form>
Already having account?<a href="adminlogin">Login</a>
<br>
${message}
<br>
${msg}
</body>
</html>