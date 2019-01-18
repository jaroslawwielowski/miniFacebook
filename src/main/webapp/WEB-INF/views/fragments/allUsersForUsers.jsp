<%--
  Created by IntelliJ IDEA.
  User: jaroslawwielowski
  Date: 18/01/2019
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %><html>
<head>
    <title>Title</title>
</head>
<body>

<table border="5">


    <td><b>Imię</b></td>
    <td><b>Nazwisko</b></td>

    <td><b>znajomość</b></td>


    </tr>
    <c:forEach items="${users}" var="user">
        <tr>


            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td><a href="addToFriend/${user.id}">dodaj</a><br>
        </tr>
    </c:forEach>
</table>
</body>
</html>
