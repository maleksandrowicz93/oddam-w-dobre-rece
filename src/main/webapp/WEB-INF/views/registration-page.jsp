<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">

<jsp:include page="head.jsp"/>

<body>

<jsp:include page="menu.jsp"/>

<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form modelAttribute="newUser" method="post">
        <div class="form-group">
            <form:input placeholder="email" path="username"/>
        </div>
        <div class="form-group">
            <form:input placeholder="imię" path="firstName"/>
        </div>
        <div class="form-group">
            <form:input placeholder="nazwisko" path="lastName"/>
        </div>
        <div class="form-group">
            <form:password placeholder="hasło" path="password"/>
        </div>
        <div class="form-group">
            <form:password placeholder="powtórz hasło" path="confirmedPassword"/>
        </div>
        <div class="form-group form-group--buttons">
            <a href="/login" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>

<jsp:include page="footer.jsp"/>
<script src="../../static/js/app.js"></script>
</body>
</html>
