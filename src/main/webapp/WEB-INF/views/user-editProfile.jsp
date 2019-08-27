<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="head.jsp"/>

<body>

<header>

    <jsp:include page="user-menu.jsp"/>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <form:form method="post" modelAttribute="userDTO">
                Email: <form:input placeholder="${userDTO.username}" path="username"/><br/>
                Imię: <form:input placeholder="${userDTO.firstName}" path="firstName"/><br/>
                Nazwisko: <form:input placeholder="${userDTO.lastName}" path="lastName"/><br/>
                Hasło: <form:password placeholder="${userDTO.password}" path="password"/><br/>
                Powtórz hasło: <form:password placeholder="${userDTO.password}" path="confirmedPassword"/><br/>
                <button>Zatwierdź</button>
            </form:form>
        </div>
    </div>

</header>

<jsp:include page="footer.jsp"/>

</body>
</html>
