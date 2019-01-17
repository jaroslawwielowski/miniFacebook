<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%--<link href="../../css/style.css" rel="stylesheet" type="text/css">--%>
<style><%@include file="/WEB-INF/css/style.css"%></style>
<table border="5" align="center" id="header" class="list-view">
    <tr>
        <td rowspan="2"><b>Jesteś zalogowany jako ${user.firstName}</b></td>
        <td><b><a href="/">Start</a> </b></td>
        <td><b></b></td>
        <td><b></b></td>
        <td><b><a href="/logout/${user.id}">wyloguj</a></b></td>
    </tr>
    <tr>
        <td><b>znajomi</b></td>
        <td><b>zdjęcia</b></td>
        <td><b></b></td>
        <td><b></b></td>
    </tr>
</table>


<%--<td colspan="x">...</td>--%>
<%--<td rowspan="y">...</td>--%>
