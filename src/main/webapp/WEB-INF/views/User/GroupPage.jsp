<%--
  Created by IntelliJ IDEA.
  User: jaroslawwielowski
  Date: 17/01/2019
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %><html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <top>
        <jsp:include page="../fragments/head.jsp"/>
        <jsp:include page="../fragments/ExtraMenu.jsp"/>
        <table border="5" width="900" >
            <tr valign="top">
                <td width="150"  ><jsp:include page="/group/all"/></td>

                <td><jsp:include page="/group/all"/></td>

                <td width="150">twoi znajomi</td>
            </tr>
        </table>
    </top>
</center>
</body>
</html>
