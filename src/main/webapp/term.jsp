<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<h1> CREATE LESSON</h1>
<%--@elvariable id="term" type="com.mohsen.demo1.auth.model.Term"--%>
<%--@elvariable id="termConfiguration" type="com.mohsen.demo1.auth.model.TermConfiguration"--%>
<form:form method="post" action="/term" modelAttribute="term">

    <div>
        <table>
            <tr>
                <td>Name:</td>
                <td><form:input path="date" id="date"/></td>
            </tr>
        </table>
<%--    </div>--%>

    <%--@elvariable id="termConfiguration" type="com.mohsen.demo1.auth.model.TermConfiguration"--%>
    <form:form modelAttribute="termConfiguration">
        <table>
            <tr>
                <td>TERM CONFIGURATION</td>
                <td>
                    <input type="datetime-local" name="${termConfiguration.unitSelectionInterval}" value="">
                    <input type="datetime-local" name="${termConfiguration.unitSelectionIntervalEnd}" value="">
                </td>
            </tr>
        </table>
    </form:form>
    <input type="submit" value="Submit">
    </div>


    <%--    <table>--%>
<%--        <tr>--%>
<%--            <td>Name:</td>--%>
<%--            <td><form:input path="name" id="name"/></td>--%>

<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td></td>--%>
<%--            <td><input type="submit" value="Create"/></td>--%>
<%--        </tr>--%>
<%--    </table>--%>
</form:form>

<%--<form action="/term" method="post">--%>

<%--    <input type="text" name="${term.date}">--%>
<%--    <spring:bind path="termConfiguration">--%>
<%--        <input type="datetime-local" name="${termConfiguration.unitSelectionInterval}" value=""><br/>--%>
<%--    </spring:bind>--%>

<%--    <input type="submit" value="Create"/>--%>
<%--</form>--%>