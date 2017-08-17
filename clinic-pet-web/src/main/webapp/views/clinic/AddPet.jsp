<%--
  Created by IntelliJ IDEA.
  User: Семья
  Date: 07.08.2017
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/client/addpet" method="POST">
    <table border="1">
        <tr>
            <td align="right">Имя клиента:</td>
            <td>
                <input type="text" name="clientName">
            </td>
        </tr>
        <tr>
            <td align="right">Имя питомца:</td>
            <td>
                <input type="text" name="petName">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" align="center" value="submit"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
