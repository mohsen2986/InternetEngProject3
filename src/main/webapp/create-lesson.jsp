<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1> CREATE LESSON</h1>
<%--@elvariable id="lesson" type="com.mohsen.demo1.auth.model.Lesson"--%>
<form:form method="post" action="/create-lesson" modelAttribute="lesson">
    <div>
    <table>
        <tr>
            <td>Name:</td>
            <td><form:input path="name" id="name"/></td>

        </tr>
        <tr>
            <td>sunday</td>
            <td><input type="radio" name="sunday" value="8-10">8-10</td>
            <td><input type="radio" name="sunday" value="10-12">10-12</td>
            <td><input type="radio" name="sunday" value="10-12">12-2</td>
            <td><input type="radio" name="sunday" value="10-12">2-4</td>
            <td><input type="radio" name="sunday" value="10-12">4-6</td>
            <td><input type="radio" name="sunday" value="10-12">6-8</td>
        </tr>
        <tr>
            <td>monday</td>
            <td><input type="radio" name="monday" value="8-10">8-10</td>
            <td><input type="radio" name="monday" value="10-12">10-12</td>
            <td><input type="radio" name="monday" value="10-12">12-2</td>
            <td><input type="radio" name="monday" value="10-12">2-4</td>
            <td><input type="radio" name="monday" value="10-12">4-6</td>
            <td><input type="radio" name="monday" value="10-12">6-8</td>
        </tr>
        <tr>
            <td>tuesday</td>
            <td><input type="radio" name="tuesday" value="8-10">8-10</td>
            <td><input type="radio" name="tuesday" value="10-12">10-12</td>
            <td><input type="radio" name="tuesday" value="10-12">12-2</td>
            <td><input type="radio" name="tuesday" value="10-12">2-4</td>
            <td><input type="radio" name="tuesday" value="10-12">4-6</td>
            <td><input type="radio" name="tuesday" value="10-12">6-8</td>
        </tr>
        <tr>
            <td>wednesday</td>
            <td><input type="radio" name="wednesday" value="8-10">8-10</td>
            <td><input type="radio" name="wednesday" value="10-12">10-12</td>
            <td><input type="radio" name="wednesday" value="10-12">12-2</td>
            <td><input type="radio" name="wednesday" value="10-12">2-4</td>
            <td><input type="radio" name="wednesday" value="10-12">4-6</td>
            <td><input type="radio" name="wednesday" value="10-12">6-8</td>
        </tr>
        <tr>
            <td>thursday</td>
            <td><input type="radio" name="thursday" value="8-10">8-10</td>
            <td><input type="radio" name="thursday" value="10-12">10-12</td>
            <td><input type="radio" name="thursday" value="10-12">12-2</td>
            <td><input type="radio" name="thursday" value="10-12">2-4</td>
            <td><input type="radio" name="thursday" value="10-12">4-6</td>
            <td><input type="radio" name="thursday" value="10-12">6-8</td>
        </tr>
        <tr>
            <td>friday</td>
            <td><input type="radio" name="friday" value="8-10">8-10</td>
            <td><input type="radio" name="friday" value="10-12">10-12</td>
            <td><input type="radio" name="friday" value="10-12">12-2</td>
            <td><input type="radio" name="friday" value="10-12">2-4</td>
            <td><input type="radio" name="friday" value="10-12">4-6</td>
            <td><input type="radio" name="friday" value="10-12">6-8</td>
        </tr>
        <tr>
            <td>saturday</td>
            <td><input type="radio" name="saturday" value="8-10">8-10</td>
            <td><input type="radio" name="saturday" value="10-12">10-12</td>
            <td><input type="radio" name="saturday" value="10-12">12-2</td>
            <td><input type="radio" name="saturday" value="10-12">2-4</td>
            <td><input type="radio" name="saturday" value="10-12">4-6</td>
            <td><input type="radio" name="saturday" value="10-12">6-8</td>
        </tr>

        <%--@elvariable id="users" type="com.mohsen.demo1.auth.model"--%>
        <form:form modelAttribute="users" action="result" method="get" >
            <select  path="selectred_user" array="users" name="selected_user">
                <c:forEach var="user_" items="${users}">
                    <option value="${user_.username}">
                        <c:out value="${user_.username}"/>
                    </option>
                </c:forEach>
            </select>
        </form:form>

        <tr>
            <td></td>
            <td><input type="submit" value="Create"/></td>
        </tr>
    </table>
    </div>
</form:form>