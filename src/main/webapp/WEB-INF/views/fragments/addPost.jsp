<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--@elvariable id="post" type="pl.coderslab.finalproject.entity.Post"--%>
<form:form method="post"
           modelAttribute="post" action="posts/add">
    <form:textarea path="description" cols="30" rows="20" placeholder="Jak Ci mija dzień?"/>
    <input type="submit" value="dodaj">
</form:form>