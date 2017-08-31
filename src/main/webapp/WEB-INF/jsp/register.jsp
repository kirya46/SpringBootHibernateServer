<!DOCTYPE html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>
</head>
<body>
<form:form id="regForm" modelAttribute="avatar" action="registerProcess" method="post" >
    <table align="center">

        <tr>
            <td>
                <form:label path="id">ID</form:label>
            </td>
            <td>
                <form:password path="id" name="id" id="id" />
            </td>
        </tr>


        <tr>
            <td>
                <form:label path="name">Name</form:label>
            </td>
            <td>
                <form:password path="name" name="name" id="name" />
            </td>
        </tr>

        <tr>
            <td></td>
            <td>
                <form:button id="register" name="register">Register</form:button>
            </td>
        </tr>

        <%--SEPARATE ROW--%>
        <tr></tr>


        <tr>
            <td></td>
            <td><a href="home.jsp">Home</a>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>