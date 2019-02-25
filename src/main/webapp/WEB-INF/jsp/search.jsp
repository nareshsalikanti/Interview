<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<script>
		function validateform() {
			var name = document.myform.studentname.value;

			if (name == null || name == "") {
				alert("Name can't be blank");
				document.myform.name.focus();
				return false;
			}
		}
	</script>
	<form:form id="loginForm" modelAttribute="search" action="search"
		method="post" name="myform" onsubmit="return validateform()">
		<table align="left">
			<H1>Search Student</H1>
			<tr>
				<td><form:label path="studentname">Student name: </form:label>
				</td>
				<td><form:input path="studentname" name="studentname"
						id="studentname" /></td>
			</tr>


			<tr></tr>

		</table>
		<br />
		<br />

		<input type="submit" value="Search">
	</form:form>
	<table align="left">
		<tr>
			<td style="font-style: italic; color: red;">${message}</td>
		</tr>
	</table>
</body>
</html>