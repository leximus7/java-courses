<%--
  Created by IntelliJ IDEA.
  User: Семья
  Date: 06.08.2017
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/user/create" method="POST">
    <table border="1">
        <tr>
            <td align="right">Login :</td>
            <td>
                <input type="text" name="login">
            </td>
        </tr>
        <tr>
            <td align="right">Email :</td>
            <td>
                <input type="text" name="email">
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
