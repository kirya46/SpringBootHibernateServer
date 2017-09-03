<!DOCTYPE html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>
</head>
<body>
<form:form id="regForm" modelAttribute="avatar" onsubmit="verify()" action="registerProcess" method="post">
    <table align="center">

        <tr>
            <td>
                <form:label path="name">User name</form:label>
            </td>
            <td>
                <form:price path="name" name="name" id="name"/>
            </td>
        </tr>


        <tr>
            <td>
                <form:label path="price">Password</form:label>
            </td>
            <td>
                <form:price path="price" name="price" id="price"/>
            </td>
        </tr>

        <tr>
            <td></td>
            <td>
                <form:button id="register" name="register">Register</form:button>
            </td>
        </tr>

    </table>
</form:form>

<%--verify from data--%>
<script type="text/javascript">
    function verify() {
        var name = document.getElementById("name").value;
        var pass = document.getElementById("price").value;

        if (name.length < 3 || pass.length < 3) {
            alert("Wrong format of:\nUser name: " + name +"\nPassword: " + pass);
            document.getElementById("regForm").setAttribute("action", "register");
            elem.submit();
            return false;
        }
        return true;
    }
</script>

</body>
</html>