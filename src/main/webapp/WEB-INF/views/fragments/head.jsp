<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%--<link href="../../css/style.css" rel="stylesheet" type="text/css">--%>
<style><%@include file="/WEB-INF/css/style.css"%></style
<div id="header">
    <table border="5"  align="center" class="classs">
        <tr>
            <td id="profile_photo" rowspan="3"><a  href="/"><img src="${user.profilePic.picture}"/></a></td>
            <td><b><a href="/user/${user.id}">${user.firstName} ${user.lastName}</a></b></td>
            <td colspan="3" rowspan="2"><b><h1>LOGO</h1></b></td>
            <td><b><a href="/logout/${user.id}">wyloguj</a></b></td>
        </tr>
        <tr>
            <td><b>-</b></td>
            <td><b>-</b></td>
        </tr>
        <tr>
            <td><b>znajomi</b></td>
            <td><b>zdjęcia</b></td>
            <td><b>wiadomości</b></td>
            <td><b>powiadomienia</b></td>
            <td><b>zaproszenia</b></td>
        </tr>
    </table>
</div>


<%--<td colspan="x">...</td>--%>
<%--<td rowspan="y">...</td>--%>
