<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create an account</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} ${pageContext.request.isUserInRole("ADMIN")}| <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
    </c:if>
    <sec:authorize access="isAuthenticated()">
        YES, you are logged in!
    </sec:authorize>


    <sec:authorize access="hasAuthority('ROLE_ADMIN')">
        <H2>ADMIN</H2>
    </sec:authorize>
    <sec:authorize access="hasAuthority('ROLE_AMOZESH')">
        <H2>AMOZESH</H2>
        <button class="btn btn-lg btn-primary" id="submit" onclick="location.href ='/lesson'" >Lessons</button>
        <button class="btn btn-lg btn-primary" id="submit" onclick="location.href ='/term'" >TERM</button>
    </sec:authorize>
    <sec:authorize access="hasAuthority('ROLE_OSTAD')">
        <H2>OSTAD</H2>
        <button class="btn btn-lg btn-primary" id="submit" onclick="location.href ='/program'" >PROGRAM</button>
        <button class="btn btn-lg btn-primary" id="submit" onclick="location.href ='/mark'" >MARKS</button>
    </sec:authorize>
    <sec:authorize access="hasAuthority('ROLE_DANESHJO')">
        <H2>DANESHJO</H2>
        <button class="btn btn-lg btn-primary" id="submit" onclick="location.href ='/select-lessons'" >SELECT LESSON</button>
        <button class="btn btn-lg btn-primary" id="submit" onclick="location.href ='/program'" >PROGRAM</button>
    </sec:authorize>






<%--    <form action="/test" method="get">--%>
<%--        <input type="submit" value="Submit">--%>
<%--    </form>--%>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>