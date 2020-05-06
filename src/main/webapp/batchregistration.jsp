<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Batch Registration</title>
<link rel="stylesheet" type="text/css" href="/style1.css"/>
<script>
function modulesNames(str) {
	
  var xhttp;    
  if (str == "") {
    document.getElementById("respText").innerHTML = "";
    return;
  }
  xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
        
      document.getElementById("respText").innerHTML = this.responseText;
    }
  };
  xhttp.open("GET", "http://localhost:9198/getModules?q="+str, true);
  xhttp.send();
}



function facultyNames(str) {
	
	  var xhttp;    
	  if (str == "") {
	    document.getElementById("factultyText").innerHTML = "";
	    return;
	  }
	  xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	        
	      document.getElementById("facultyText").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "http://localhost:9198/getfaculty?q="+str, true);
	  xhttp.send();
	}



</script>



</head>
<body>
<h1>ACADEMY PORTAL</h1>


<div class="formdata">


<form:form action="batchreg" modelAttribute="batch" method="post">

<table>
<h1>Batch Registration</h1>
<tr>
<td> 
Skill : 
</td>
<td> 
<form:select  path="skillId" name="skill" onchange="modulesNames(this.value)"> 
<option value="">Select Skill</option>
<c:forEach items="${skills }" var="skill">

<option value="${skill.skillid}">${skill.skillid}-${skill.skillname}-${skill.skillfamily}</option>


</c:forEach>

</form:select>


 </td>
</tr>


<tr>

<td> Module :</td>
<td>
<form:select path="moduleId" id="respText" name ="moduleid">


</form:select>
</td>

</tr>
<tr>

<td>Technology : </td>

<td>
<form:select path="technology" name="tech" onchange="facultyNames(this.value)">
<option  value=""></option>
<c:forEach items="${techs}" var="t">
<option  value="${t}">${t}</option>

</c:forEach>



</form:select>

</td>
</tr>

<tr>
<td>Faculty </td>
<td>
<form:select path="facultyId" id="facultyText" name="faculty">

</form:select>
 </td>
</tr>

<tr>
<td> Start Date </td>
<td><form:input path="batchStartDate" type="text" name ="startdate"/> </td>

</tr>
<tr>
<td> End Date </td>
<td><form:input path="batchEndDate" type="text" name ="enddate"/> </td>

</tr>

<tr>
<td> Batch Capcity </td>
<td>
<form:select path="batchCapacity" name ="capcity">
<option>5</option>
<option>10</option>

<option>20</option>

<option>25</option>

<option>30</option>

</form:select>

</td>

</tr>

<tr>
<td>  Class Room Name </td>
<td>

<form:select name ="classroom" path="classroom">
<option>Viveka Nanda Hall-1</option>
<option>Viveka Nanda Hall-2</option>



</form:select>

 </td>

</tr>
<tr>


<td>
<form:hidden path="status" value="no"/>
</td>
<td>
<input type="submit" value="Register Batch">
</td>
 </tr>

</table>



</form:form>



</div>





</body>
</html>