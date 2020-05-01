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
	
	var firstname = document.forms["adminform"]["firstName"];
	
	if(firstname.value=='')
		{
		
		firstname.style.border="2px solid red";
	alert("please update the mandatory fields");	
	return false
		}
	var firstNamePattern = new RegExp("^[a-zA-Z0-9 ]{6,20}$");
	if(!firstNamePattern.test(firstname.value))
		{
		alert("Invalid First name");	
		return false
		}	
	var lastname = document.forms["adminform"]["lastName"];
	if(lastname.value=='')
		{
		lastname.style.border="2px solid red";
	alert("please update the mandatory fields");	
	return false
		}
	var lastNamePattern = new RegExp("^[a-zA-Z0-9 ]{6,20}$");
	if(!lastNamePattern.test(lastname.value))
		{
		alert("Invalid Last name");	
		return false
		}	
	var dob = document.forms["adminform"]["DOB"];
	if(dob.value=='')
		{
		dob.style.border="2px solid red";
	alert("please update the mandatory fields");	
	return false
		}
	var DOBPattern = new RegExp("^([0-9]{2})-([0-9]{2})-([0-9]{4})$");
	if(!DOBPattern.test(dob.value))
		{
		alert("Invalid Date Of birth");	
		return false
		}	
	var gender = document.forms["adminform"]["gender"].value;
	if(gender.value=='')
		{
		gender.style.border="2px solid red";
	alert("please update the mandatory fields");	
	return false
		}
	var contactno = document.forms["adminform"]["contactNumber"];
	
	if(contactno.value=='')
		{
		contactno.style.border="2px solid red";
	alert("please update the mandatory fields");	
	return false
		}
	
	var ContactnoPattern = new RegExp("^(0|[+91]{3})?[7-9][0-9]{9}$");
	if(!ContactnoPattern.test(contactno.value))
		{
		alert("Invalid Contact Number");	
		return false
		}	
	var email = document.forms["adminform"]["Email"];
	
	if(email.value=='')
		{
		email.style.border="2px solid red";
	alert("please update the mandatory fields");	
	return false
		}
	var EmailPattern = new RegExp("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$");
	if(!EmailPattern.test(email.value))
		{
		alert("Invalid Email");	
		return false
		}	
	var password = document.forms["adminform"]["password"];
	if(password.value=='')
		{
		password.style.border="2px solid red";
	alert("Please update mandatory fields");	
	return false
		}
	var PasswordPattern = new RegExp("^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{7,15}$");
	if(!PasswordPattern.test(password.value))
		{
		alert("Invalid password");	
		return false
		}	
	var answer1 = document.forms["adminform"]["answer1"];
	if(answer1.value=='')
		{
		answer1.style.border="2px solid red";
	alert("Please update the mandatory fields");	
	return false
		}
	var answer2 = document.forms["adminform"]["answer2"];
	if(answer2.value=='')
		{
		answer2.style.border="2px solid red";
	alert("please update the mandatory fields");	
	return false
		}
	var answer3 = document.forms["adminform"]["answer3"];
	if(answer3.value=='')
		{
		answer3.style.border="2px solid red";
	alert("please update  the mandatory fields");	
	return false
		}
	
		
}
</script>
</head>
<body align="right">
<h1>ACADEMY PORTAL</h1>

<div class="formdata">
<form:form name="adminform" onsubmit="return validate()" action="adminreg" modelAttribute="admin" method="post">
<!-- First Name, Last Name, Age, Gender, Contact Number, Admin Id, Password -->
<h2>Admin Registration</h2>
<table>

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
<td><form:radiobutton path="gender" value="female"  name="gender" />Female
<form:radiobutton path="gender" value="male" name="gender" />Male
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
<td>Secret Question 1:</td>
<td>
<form:select path="secretquestion1" id="secretquestion1" class="select-box" >
<option  selected="selected" value="What is your Birthdate?">What is your Birthdate?</option>
  <option value="In which school you have studied first?">In which school have you studied first?</option>
  <option value="What is your favourite color?">What is your favourite color?</option>
</form:select>
</td>
</tr>
<tr>
<td colspan="2" align="right">
<form:input path="answer1" id="answer1" placeholder="Answer" width="170px" />
</td>
</tr>
<tr>
<td>Secret Question 2:</td>
<td>
<form:select path="secretquestion2" id="secretquestion2" class="select-box" >
<option  selected="selected" value="What is your favourite place?">What is your favourite place?</option>
  <option value="What is your parent's anniversary?">What is your parent's anniversary?</option>
  <option value="What is your highest education?">What is your highest education?</option>
</form:select>
</td>
</tr>
<tr>
<td colspan="2" align="right">
<form:input path="answer2" id="answer2" placeholder="Answer" width="170px" />
</td>
</tr>
<tr>
<td>Secret Question 3:</td>
<td>
<form:select path="secretquestion3" id="secretquestion3" class="select-box" >
<option  selected="selected" value="What is your favourite comic?">What is your favourite comic?</option>
  <option value="What is your hometown?">What is your hometown?</option>
  <option value="In what town or city did you meet your spouse/partner?">In what town or city did you meet your spouse/partner?</option>
</form:select>
</td>
</tr>
<tr>
<td colspan="2" align="right">
<form:input path="answer3" id="answer3" placeholder="Answer" width="170px" />
</td>
</tr>
</table>
<input type="submit" value ="submit" class="formsubmitbutton"/>
<br>
Already having account?<a href="adminlogin">Login</a>
</form:form>
</div>
<br>
<br>
${message}
<br>
${msg}
</body>
</html>