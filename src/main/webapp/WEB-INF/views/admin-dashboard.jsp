<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">

<jsp:include page="head.jsp"/>

<body>

<header class="header--form-page">

    <jsp:include page="admin-menu.jsp"/>

    <br/><br/><a href="/admin/admins" class="btn" role="button">Zarządzaj administratorami</a><br/><br/>
    <br/><br/><a href="/admin/users" class="btn" role="button">Zarządzaj użytkownikami</a><br/><br/>
    <br/><br/><a href="/admin/organizations" class="btn" role="button">Zarządzaj organizacjami</a><br/><br/>

</header>

    <jsp:include page="footer.jsp"/>

</body>
</html>

