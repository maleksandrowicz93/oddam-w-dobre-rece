<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="head.jsp"/>

<body>

<header class="header--form-page">

    <jsp:include page="user-menu.jsp"/>

    <div class="slogan container container--90">
        <div>
            <table>
                <tr>
                    <th>Status</th>
                    <th>Data odebrania</th>
                    <th>Data utworzenia wpisu</th>
                    <th>Informacje</th>
                </tr>
                <c:forEach var="gift" items="${gifts}">
                    <tr>
                        <td>${gift.status}</td>
                        <td>${gift.dateOfCollection}</td>
                        <td>${gift.dateOfGiftRegistration}</td>
                        <td><a href="gifts/${gift.id}" role="button">Info</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</header>

<jsp:include page="footer.jsp"/>

</body>
</html>