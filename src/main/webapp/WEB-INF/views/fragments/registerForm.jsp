<%--
  Created by IntelliJ IDEA.
  User: jaroslawwielowski
  Date: 19/12/2018
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>register</title>
</head>
<body>
<%--@elvariable id="user" type="pl.coderslab.finalproject.entity.User"--%>

<form:form method="post"
           modelAttribute="user" action="/register">
    <form:input path="firstName" placeholder="Imię"/><br>
    <form:input path="lastName" placeholder="Nazwisko" /><br>
    <form:input path="email" placeholder="Email"/><br>
    <form:password path="password" placeholder="Hasło" /><br>
    <form:select path="userDetails.sex" items="${sex}" /><br>

    Data Urodzenia: <br>
    <form:select path="userDetails.dayOfBirth" items="${dayOfBirth}"/>
    <form:select path="userDetails.monthOfBirth" items="${monthOfBirth}" />
    <form:select path="userDetails.yearsOfBirth" items="${yearOfBirth}" /><br>
    <input type="submit" value="Rejestracja"><br>
</form:form>



</body>
</html>
