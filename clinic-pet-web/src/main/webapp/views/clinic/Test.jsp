<%--
  Created by IntelliJ IDEA.
  User: Семья
  Date: 07.08.2017
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>

</head>
<body>
<table border="1">
    <tr>
        <%--<td>Id</td>--%>
        <th>Имя клиента</th>
        <th>Питомцы</th>
        <th>Действия</th>
    </tr>
    <tr valign="top">
        <%--<td>${client.id}</td>--%>
        <td>Иван</td>
        <td>пушок<br/>
            рекс
        </td>
        <td>
            <%--<a href="${pageContext.servletContext.contextPath}/user/edit?id=${user.id}">Редактировать</a>--%>
            <%--<a href="${pageContext.servletContext.contextPath}/client/delete?name=${client}">Удалить</a>--%>
        </td>
    </tr>
    <tr valign="top">
        <%--<td>${client.id}</td>--%>
        <td>Сергей</td>
        <td>котопес
        </td>
        <td>
            <%--<a href="${pageContext.servletContext.contextPath}/user/edit?id=${user.id}">Редактировать</a>--%>
            <%--<a href="${pageContext.servletContext.contextPath}/client/delete?name=${client}">Удалить</a>--%>
        </td>
    </tr>
</table>
</body>
</html>
