<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>

    <link rel="stylesheet" type="text/css"
          href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>


	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />

    <c:url value="/css/main.css" var="jstlCss"/>
    <link href="${jstlCss}" rel="stylesheet"/>

</head>
<body>

<div class="container">

    <div class="starter-template">
        <h1>Error:</h1>
        <br>Timestamp: ${timestamp}
        <br>Status: ${status}
        <br>Description: ${error}
        <br>Exception: ${exception}
        <br>Message: ${message}
        <br>Path: ${path}
        <br>Trace: ${trace}
    </div>

</div>


</body>

</html>
