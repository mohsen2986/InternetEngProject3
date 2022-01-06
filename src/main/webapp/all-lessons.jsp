<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<button class="btn btn-lg btn-primary" id="submit" onclick="location.href ='/create-lesson'" >create lesson</button>
