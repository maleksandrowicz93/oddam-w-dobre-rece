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
                Name: <form:input placeholder="${organizationDTO.name}" path="name"/><br/>
                Type: <form:input placeholder="${organizationDTO.type}" path="type"/><br/>
                Localization: <form:input placeholder="${organizationDTO.localization}" path="localization"/><br/>
                Address: <form:input placeholder="${organizationDTO.address}" path="address"/><br/>
                For whom: <form:input placeholder="${organizationDTO.forWhom}" path="forWhom"/><br/>
                Description: <form:textarea placeholder="${organizationDTO.description}" path="description"/><br/>
                <button>Zatwierdź</button>
            </form:form>
        </div>
    </div>

</header>

<jsp:include page="footer.jsp"/>
<script src="../../static/js/app.js"></script>
</body>
</html>