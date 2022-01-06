<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mohsen
  Date: 1/5/2022
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PROGRAM</title>
</head>
<body>

<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>day</th>
        <th>time</th>
        <th>lesson</th>
    </tr>

    <c:forEach var="meeting" items="${meetings}">
        <tr>
            <th>${meeting.day}</th>
            <th>${meeting.time}</th>
            <th>${meeting.lesson}</th>
        </tr>
    </c:forEach>
</table>

</body>
</html>
