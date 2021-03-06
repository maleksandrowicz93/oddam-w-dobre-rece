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
            <form:form method="post" modelAttribute="organizationDTO">
                Name: <form:input path="name"/><br/>
                Type: <form:input path="type"/><br/>
                Localization: <form:input path="localization"/><br/>
                Address: <form:input path="address"/><br/>
                For whom: <form:input path="forWhom"/><br/>
                Needs: <form:input path="needs"/><br/>
                Description: <form:textarea path="description"/><br/>
                <button>Zatwierdź</button>
            </form:form>
        </div>
    </div>

</header>

<jsp:include page="footer.jsp"/>

</body>
</html>