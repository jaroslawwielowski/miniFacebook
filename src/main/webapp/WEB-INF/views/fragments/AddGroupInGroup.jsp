<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<table border="5" align="center" width="100" height="20">
    <td align="right">
        <%--@elvariable id="newGroup" type="pl.coderslab.finalproject.entity.UserGroup"--%>
        <form:form method="post"
                   modelAttribute="newGroup" action="add">
            <form:input path="groupName" cols="92" rows="10" placeholder="Nazwa grupy"/><br>
            <input type="submit" value="dodaj grupę" >
        </form:form>
    </td>
</table>