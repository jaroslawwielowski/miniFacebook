<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--@elvariable id="post" type="pl.coderslab.finalproject.entity.Post"--%>
<table border="5" align="center" width="600" height="200">
    <td align="right">
<form:form method="post"
           modelAttribute="newpost" action="add">
    <form:textarea path="description" cols="100" rows="10" placeholder="Jak Ci mija dzień?"/><br>
    <input type="submit" value="dodaj post" >
</form:form>
    </td>
</table>
