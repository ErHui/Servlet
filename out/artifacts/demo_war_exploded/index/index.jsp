<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/3/20
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>登录成功</p>
<c:forEach items="${userList}" var="user">
    <table style="border: 1px solid black">
    <tr>
        <td align="center">${user.id}</td>
        <td align="center">${user.user}</td>
        <td align="center">${user.pw}</td>
    </tr>
    </table>
</c:forEach>
</body>
</html>
