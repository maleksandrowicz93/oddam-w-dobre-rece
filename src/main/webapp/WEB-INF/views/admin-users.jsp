<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="head.jsp"/>

<body>

<header class="header--form-page">

    <jsp:include page="admin-menu.jsp"/>

    <div class="slogan container container--90">
        <div>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Imię</th>
                    <th>Nazwisko</th>
                    <th>Email</th>
                    <th>Zablokowany</th>
                    <th>Zarządzaj</th>
                </tr>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.username}</td>
                        <td><c:choose>
                            <c:when test="${user.role == 'BLOCKED'}">
                                <c:out value="TAK"/>
                            </c:when>
                            <c:otherwise>
                                <c:out value="NIE"/>
                            </c:otherwise>
                        </c:choose></td>
                        <td><a href="users/edit/${user.id}" role="button">Edytuj</a>
                            <a href="users/block/${user.id}" role="button">Blokuj</a>
                            <a href="users/delete/${user.id}" role="button">Usuń</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</header>

<jsp:include page="footer.jsp"/>

</body>
</html>