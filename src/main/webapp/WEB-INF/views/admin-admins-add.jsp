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
            <form:form method="post" modelAttribute="adminDTO">
                First name: <form:input path="firstName"/><br/>
                Last name: <form:input path="lastName"/><br/>
                Email: <form:input path="username"/><br/>
                Password: <form:password path="password"/><br/>
                <button>Zatwierdź</button>
            </form:form>
        </div>
    </div>

</header>

<jsp:include page="footer.jsp"/>
<script src="../../static/js/app.js"></script>
</body>
</html>
