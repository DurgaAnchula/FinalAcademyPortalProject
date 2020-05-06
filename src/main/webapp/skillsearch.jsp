<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/style1.css"/>
<script>
function advSearch(str) {

	if(str.charAt(0)=='s')
		{
		
		document.getElementById("advsearch").innerHTML="<option value='skillname'>Skill Name</option>"+"<option value='skillfamily'>SkillFamily</option>"
		+"<option value='sm'>Skill/Module</option>";
		}
	else if(str.charAt(0)=='m')
	{

		document.getElementById("advsearch").innerHTML="<option value='technology'>Technology</option><option value='proficiencylevel'>Proficiency Level</option>"
			+"<option value='sm'>Skill/Module</option>";
		} 
	else if(str.charAt(0)=='b')
		{
		document.getElementById("advsearch").innerHTML="<option value='startdate'>Start Date</option><option value='enddate'>End Date</option>";
		
		}
	else
		{
		document.getElementById("advsearch").innerHTML="<option value='firstName'>FirstName</option><option value='lastName'>LastName</option>";

		}
 /*  var xhttp;    
  if (str == "") {
    document.getElementById("respText").innerHTML = "";
    return;
  }
  xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("advsearch").innerHTML = this.responseText;
    }
  };
  xhttp.open("GET", "http://localhost:9198/getskillNames?q="+str, true);
  xhttp.send(); */
}
</script>


</head>
<body>
<div class="formdata2">

<form action="search">
<table>
<tr>
<td>Basic Search
<select name="bsearch" onchange="advSearch(this.value)">
<option value="">Select Basic Search</option>
<option value="skill">Skill</option>
<option value="module">Module</option>
<option value="batch">Batch</option>
<option value="faculty">Faculty</option>
</select>
</td>

<td>

Advanced Search
<select id="advsearch" name="advsearch" >

</select>

 </td>
 <td>
 <input type="text" name="searchKey" placeholder="enter search key">
 </td>
 <td><input type="submit" value="Search"></td>
</tr>

</table>

</form>
<div>
<c:forEach items="${searchresult}" var="skill">
<table border="1" class="t1">
<tr>
<th>skillid</th><th>skillfamily><th>skillname</th>
<tr><td>${skill.skillid}</td>
<td>${skill.skillfamily}</td>
<td>${skill.skillname}</td></tr>
</table>
</c:forEach>

</div>
<div>
<c:forEach items="${searchresult1}" var="faculty">
<table border="1" class="t1">
<tr><th>FacultyId</th><th>FirstName</th><th>LastName</th><th>SkillFamily</th><th>SkillName</th><th>TeachingTime</th><th>ContactNumber</th></tr>
<tr><td>${faculty.userId}</a></td>
<td>${faculty.firstName}</td>
<td>${faculty.lastName}</td>
<td>${faculty.skillfamily}</td>
<td>${faculty.skillname}</td>
<td>${faculty.teachingtime}</td>
<td>${faculty.contactNumber}</td></tr>
</table>
</c:forEach>
</div>
<div>

<c:forEach items="${searchresult2}" var="b">
<table border="1" class="t1">
<tr><th>BatchId</th><th>SkillId</th><th>ModuleId</th><th>FacultyId</th><th>Technology</th><th>StartDate</th><th>EndDate</th><th>Capacity</th><th>ClassroomName</th></tr>
<tr><td><a href="enrollforbatch?bid=${b.batchId}">${b.batchId}</a></td>
<td>${b.skillId}</td>
<td>${b.moduleId}</td>
<td>${b.facultyId}</td>
<td>${b.technology}</td>
<td>${b.batchStartDate}</td>
<td>${b.batchEndDate}</td>
<td>${b.batchCapacity}</td>
<td>${b.classroom}</td></tr>
</table>
</c:forEach>
</div>
<div>
<c:forEach items="${searchresult3}" var="m">
<table border="1" class="t1">
<tr><th>Module ID</th><th>Technology</th><th>ProficiencyLevel</th><th>ExecutionType</th><th>CertificationType</th><th>CertificationName</th></tr>
<tr><td>${m.mid }</td><td>${m.technology}</td><td>${m.proficiencylevel}</td><td>${m.executiontype}</td><td>${m.certificationtype}</td><td>${m.certificationname}</td></tr>
</table>
</c:forEach>
</div>
<br>
<a href="logout1"><button>Back</button></a>
</div>

<div>
<c:forEach items="${smlist }" var="sm">
${sm }
</c:forEach>


</div>
${nm}
</body>
</html>