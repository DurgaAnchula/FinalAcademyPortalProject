<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset password</title>
<link rel="stylesheet" type="text/css" href="/style1.css"/>
<script type="text/javascript">
function validate(){
	var pwd=document.getElementById("password").value;
	 if(pwd==""){
			document.getElementById("password").style.borderColor = "red";
			alert("please update mandatory highlighted fields");
				return false;
			}
}

</script>
</head>
<body>
<div class="header">
<h1>Academy Portal</h1>
</div>
<h2>Reset password</h2>
<div class="formdata">
<div align="center">
<form:form onsubmit="return validate()" action="updatepwd" method="post" modelAttribute="name1">
<table>
<tr>
<tr>
<td>
<form:hidden path="uid"/>
</td>
</tr>
<tr>
<td>Password:</td>
<td><form:input path="pwd" class="formcontrol" id="pwd" type="password"/></td>
</tr>
</table>
<input type="submit" value="submit" class="formsubmitbutton"/>
</form:form>
Want to login?<a href="adminlogin">Click here</a>
<br>
<br>
${message}
</div>
</div>
</body>
</html>