<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>

	<script>
		function validateform() {
			var name = document.myform.studentname.value;
			var address = document.myform.address.value;

			if (name == null || name == "") {
				alert("Name can't be blank");
				document.myform.name.focus();
				return false;
			} else if (address.length < 1) {
				alert("address can't be blank.");
				document.myform.address.focus();
				return false;
			}
		}
	</script>
	<form:form id="regForm" modelAttribute="student"
		action="registerProcess" method="post" name="myform"
		onsubmit="return validateform()">
		<table align="left">
			<H1>Enter Student details</H1>
			<tr>
				<td><form:label path="name">Enter Student name</form:label></td>
				<td><form:input path="name" name="studentname" id="studentname" />
				</td>
			</tr>
			<tr>
				<td><form:label path="address">Enter address</form:label></td>
				<td><form:input path="address" name="address" id="address" />
				</td>
			</tr>
			<tr></tr>

		</table>
		<br />
		<br />
		<br />
		<br />
		<input type="submit" value="Register">

	</form:form>
</body>
</html>