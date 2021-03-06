<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="head.jsp"/>

<body>

<header class="header--form-page">

    <jsp:include page="admin-menu.jsp"/>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h2>Dodaj organizację</h2>
            <a href="organizations/add" class="btn" role="button">+ Dodaj</a>
        </div>
        <div>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Nazwa</th>
                    <th>Rodzaj</th>
                    <th>Zarządzaj</th>
                </tr>
                <c:forEach var="organization" items="${organizations}">
                    <tr>
                        <td>${organization.id}</td>
                        <td>${organization.name}</td>
                        <td>${organization.type}</td>
                        <td><a href="organizations/edit/${organization.id}" role="button">Edytuj</a>
                            <a href="organizations/delete/${organization.id}" role="button">Usuń</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</header>

<jsp:include page="footer.jsp"/>

</body>
</html>