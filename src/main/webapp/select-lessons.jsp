<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>All Lessons</h1>
    <table border="2" width="70%" cellpadding="2">
        <tr>
         <th>id</th>
         <th>name</th>
        </tr>

        <c:forEach var="lesson" items="${lessons}">
            <tr>
                <th>${lesson.id}</th>
                <th>${lesson.name}</th>
            </tr>
        </c:forEach>
    </table>
    <table border="2" width="70%" cellpadding="2">
        <tr>
            <th>id</th>
            <th>name</th>
        </tr>

        <c:forEach var="lesson" items="${selected_lessons}">
            <tr>
                <th>${lesson.id}</th>
                <th>${lesson.name}</th>
            </tr>
        </c:forEach>


    </table>

<%--@elvariable id="term" type="java.lang.String"--%>
<form:form method="post" action="/add-select-lessons" modelAttribute="lesson_id">

<div>
    <table>
        <tr>
            <td>Name:</td>
            <td>
                <input type="text" name="lesson_id" value="">
            </td>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</div>
</form:form>
<%--    <form  action="/add-select-lessons" method="post" >--%>
<%--        <input name="lesson_id" type="text" class="form-control">--%>
<%--        <input type="submit" value="Submit">--%>
<%--    </form>--%>
<table>
    <%--@elvariable id="lesson_id" type="java.lang.String"--%>

<%--<form:form modelAttribute="lesson_id" action="/add-select-lessons">--%>
<%--        <tr>--%>
<%--            <td>--%>
<%--                <input name="${lesson_id}" value="">--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    <input type="submit" value="Submit">--%>
<%--</form:form>--%>
<%--</table>--%>



<%--<button class="btn btn-lg btn-primary" id="submit" onclick="location.href ='/create-lesson'" >Lessons</button>--%>
</table>