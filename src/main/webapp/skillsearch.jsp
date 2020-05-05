<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script>
function advSearch(str) {

	if(str.charAt(0)=='s')
		{
		
		document.getElementById("advsearch").innerHTML="<option value='skillname'>Skill Name</option>"+"<option value='skillfamily'>SF</option>";
		}
	else if(str.charAt(0)=='m')
	{

		document.getElementById("advsearch").innerHTML="<option value='technplogy'>Technology</option><option value='proficiencylevel'>Proficiency Level</option>";
		} 
	else 
		{
		document.getElementById("advsearch").innerHTML="<option value='stratdate'>Start Date</option><option value='enddate'>End Date</option>";
		
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


<form action="search">
<table>
<tr>
<td>Basic Search
<select name="bsearch" onchange="advSearch(this.value)">
<option value="">Select Basic Search</option>
<option value="skill">Skill</option>
<option value="module">Module</option>
<option value="batch">Batch</option>

</select>
</td>

<td>

Advanced Search
<select id="advsearch" name="advsearch">

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
${skill}
</c:forEach>

</div>


</body>
</html>