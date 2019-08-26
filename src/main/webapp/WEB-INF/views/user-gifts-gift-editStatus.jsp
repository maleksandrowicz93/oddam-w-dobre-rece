<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="head.jsp"/>

<body>

<header class="header--form-page">

    <jsp:include page="user-menu.jsp"/>

    <div class="slogan container container--90">
        <form:form modelAttribute="giftDTO" method="post">
            Czy dar został odebrany? <form:checkbox value="odebrane" path="status"/>
            <button class="btn">Zatwierdź</button>
        </form:form>
    </div>

</header>

<jsp:include page="footer.jsp"/>

</body>
</html>
