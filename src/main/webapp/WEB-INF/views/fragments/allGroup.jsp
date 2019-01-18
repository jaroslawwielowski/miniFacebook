<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %><html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="/group/add"/>
wszystkie grupy
<c:forEach items="${groups}" var="onegroup">
    <table border="5" width="150" height="30" >
        <tr height="10" >
            <td >${onegroup.groupName}</td>
        </tr>

    </table>
</c:forEach>
</body>
</html>
