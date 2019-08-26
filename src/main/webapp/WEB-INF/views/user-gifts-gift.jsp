<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="head.jsp"/>

<body>

<header class="header--form-page">

    <jsp:include page="user-menu.jsp"/>

    <div class="slogan container container--90">
        <div>
            <table>
                <tr>
                    <td>organizacja:</td>
                    <td>${gift.organization.name}</td>
                </tr>
                <tr>
                    <td>stan:</td>
                    <td>${gift.status}</td>
                </tr>
                <tr>
                    <td>data utworzenia wpisu:</td>
                    <td>${gift.dateOfGiftRegistration}</td>
                </tr>
                <tr>
                    <td>data przekazania daru:</td>
                    <td>${gift.dateOfCollection}</td>
                </tr>
                <tr>
                    <td>dobra:</td>
                    <td>${gift.products}</td>
                </tr>
                <tr>
                    <td>ilość worków:</td>
                    <td>${gift.amountOfBags}</td>
                </tr>
                <tr>
                    <td>Zmień status:</td>
                    <c:choose>
                        <c:when test="${gift.status=='nieodebrane'}">
                            <td><a href="${gift.id}/editStatus" class="btn" role="button">Edytuj</a></td>
                        </c:when>
                        <c:otherwise>
                            <td>Zmieniono</td>
                        </c:otherwise>
                    </c:choose>
                </tr>
            </table>
            <br/><br/><a href="/app/gifts" class="btn" role="button">Wróć</a><br/><br/>
        </div>
    </div>

</header>

<jsp:include page="footer.jsp"/>

</body>
</html>
