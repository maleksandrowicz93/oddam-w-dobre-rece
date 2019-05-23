<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="head.jsp"/>

<body>

<header>

    <jsp:include page="admin-menu.jsp"/>

    <div class="slogan container container--90">
        <div class="slogan--item">
            Napewno?<br/>
            <a href="${admin.id}/confirm" role="button">Potwierdź</a>
            <a href="/admin/admins" role="button">Wróć</a>
        </div>
    </div>

</header>

<jsp:include page="footer.jsp"/>
<script src="../../static/js/app.js"></script>
</body>
</html>