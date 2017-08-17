<%--
  Created by IntelliJ IDEA.
  User: Семья
  Date: 07.08.2017
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Client view</title>
</head>
<body>
<a href="${pageContext.servletContext.contextPath}/views/clinic/AddClient.jsp">Добавить клиента</a>
<br/>
<a href="${pageContext.servletContext.contextPath}/views/clinic/AddPet.jsp">Добавить питомца</a>
<br/>
<br/>
<table border="1">
    <tr>
        <%--<td>Id</td>--%>
        <th>Имя клиента</th>
        <th>Питомцы</th>
        <th>Действия</th>
    </tr>
    <c:forEach items="${clients}" var="entry">
        <tr valign="top">
                <%--<td>${client.id}</td>--%>
            <td>${entry.key}</td>
            <td>
                <c:forEach items="${entry.value.pets}" var="petEntry">
                    ${petEntry.key}<br/>
                </c:forEach>
            </td>
            <td>
                    <%--<a href="${pageContext.servletContext.contextPath}/user/edit?id=${user.id}">Редактировать</a>--%>
                <a href="${pageContext.servletContext.contextPath}/client/delete?name=${client}">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
