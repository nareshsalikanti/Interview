<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.util.ArrayList" %> 
	<%@ page import="com.student.model.Student" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>

	<tr>
		<h1>All Students details</h1>
	</tr>

	<table style="border: 1px solid;">
		<tr>
			<td>id</td>
			<td>name</td>
			<td>address</td>
			<td>class</td>
		</tr>
	</table>
	<table style="border: 1px solid;">
   <% ArrayList users = (ArrayList)request.getAttribute("allStudents"); 
   for (int i = 0; i < users.size(); i++) { 
       Student user = (Student)users.get(i); %>  
       <tr>
       <td><% out.print(user.getId());   %></td>
       <td><% out.print(user.getName());   %></td>
       <td><% out.print(user.getAddress());   %></td>
        <td><% out.print(user.getClasses()); %></td>
       </tr>
   <% } %>
	<table>
		
		<tr>
		</tr>
		<tr>
		</tr>

	</table>
</body>
</html>