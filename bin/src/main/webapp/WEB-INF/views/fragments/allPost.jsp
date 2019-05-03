<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jaroslawwielowski
  Date: 18/01/2019
  Time: 00:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="/posts/add"/>
wszystkie posty
<c:forEach items="${posts}" var="onepost" end="9">
<table border="5" width="600" height="200" align="center">
    <tr height="10" >
        <td >${onepost.user.firstName} ${onepost.user.lastName}</td>
    </tr>
    <tr>
        <td>${onepost.description}</td>
    </tr>
</table>
</c:forEach>
</body>
</html>
