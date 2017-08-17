<%--
  Created by IntelliJ IDEA.
  User: Семья
  Date: 07.08.2017
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add client</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/client/add" method="POST">
    <table border="1">
        <tr>
            <td align="right">Name :</td>
            <td>
                <input type="text" name="name">
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
