<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="head.jsp"/>

<body>

<header>

    <jsp:include page="admin-menu.jsp"/>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <c:choose>
                <c:when test="${user.role == 'BLOCKED'}">
                    Użytkownik został już zbalokowany.<br/>
                    Odblokować? <a href="${user.id}/unblock" role="button">Potwierdź</a>
                </c:when>
                <c:otherwise>
                    Napewno?<br/>
                    <a href="${user.id}/confirm" role="button">Potwierdź</a>
                </c:otherwise>
            </c:choose>
            <a href="/admin/users" role="button">Wróć</a>
        </div>
    </div>

</header>

<jsp:include page="footer.jsp"/>

</body>
</html>