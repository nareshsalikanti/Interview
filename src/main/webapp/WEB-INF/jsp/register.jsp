<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Registration</title>
        </head>
        <body>
            <form:form id="regForm" modelAttribute="student" action="registerProcess" method="post">
                <table align="left">
                <H1>Enter Student details</H1>
                    <tr>
                        <td>
                            <form:label path="name">Enter Student name</form:label>
                        </td>
                        <td>
                            <form:input path="name" name="studentname" id="studentname" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="address">Enter address</form:label>
                        </td>
                        <td>
                            <form:input path="address" name="address" id="address" />
                        </td>
                    </tr>
                  
                   
                    <tr>
                        <td></td>
                        <td>
                            <form:button id="register" name="register">Register</form:button>
                        </td>
                    </tr>
                    <tr></tr>
                   
                </table>
            </form:form>
        </body>
        </html>