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
            <form:form method="post" modelAttribute="userDTO">
                First name: <form:input placeholder="${userDTO.firstName}" path="firstName"/><br/>
                Last name: <form:input placeholder="${userDTO.lastName}" path="lastName"/><br/>
                Email: <form:input placeholder="${userDTO.username}" path="username"/><br/>
                Password: <form:password placeholder="${userDTO.password}" path="password"/><br/>
                <button>Zatwierdź</button>
            </form:form>
        </div>
    </div>

</header>

<jsp:include page="footer.jsp"/>

</body>
</html>
