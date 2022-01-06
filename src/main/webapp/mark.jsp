<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Mohsen
  Date: 1/5/2022
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <meta name="_csrf" th:content="${_csrf.token}"/>
        <meta name="_csrf_header" th:content="${_csrf.headerName}"/>
    </head>
    <title>MARK</title>
</head>
<body>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>mark</th>
    </tr>

    <c:forEach var="enroll" items="${enrolls}">
        <tr>
            <th>${enroll.id}</th>
            <th>${enroll.user.username}</th>
            <th>${enroll.mark}</th>
        </tr>
    </c:forEach>
</table>

<%--@elvariable id="mark" type="java.lang.String"--%>
<form:form method="post" action="/mark" modelAttribute="mark">
    <div>
        <table>
            <tr>
            <tr><input type="text" name="id" value=""></tr>
            <tr><input type="text" name="mark" value=""> </tr>
            <tr><input type="submit" value="Save"> </tr>
            </tr>
        </table>
    </div>
</form:form>

<%--<form action="/mark" method="post">--%>
<%--    <table>--%>
<%--        <tr>--%>
<%--        <tr><input type="text" name="id" value=""> </tr>--%>
<%--        <tr><input type="text" name="mark" value=""> </tr>--%>
<%--        <tr><input type="submit" value="Save"> </tr>--%>
<%--        </tr>--%>
<%--    </table>--%>

<%--</form>--%>

<%--@elvariable id="enroll" type="com.mohsen.demo1.auth.model.Enroll"--%>
<%--<form:form method="post" action="/mark" modelAttribute="enroll">--%>
<%--<table>--%>
<%--    <tr>--%>
<%--        <td><form:label path="id">id</form:label></td>--%>
<%--        <td><form:input path="id"/></td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td><form:label path="mark">mark</form:label></td>--%>
<%--        <td><form:input path="mark"/></td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td><input type="submit" value="Submit"/></td>--%>
<%--    </tr>--%>
<%--</form:form>--%>
</body>
</html>
