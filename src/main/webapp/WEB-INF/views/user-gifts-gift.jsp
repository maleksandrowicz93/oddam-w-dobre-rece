<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="head.jsp"/>

<body>

<header>

    <jsp:include page="user-menu.jsp"/>

    <div class="slogan container container--90">
        <div>
            <table>
                <tr>
                    <td>organizacja</td>
                    <td>${gift.organization.name}</td>
                </tr>
                <tr>
                    <td>stan</td>
                    <td>${gift.state}</td>
                </tr>
                <tr>
                    <td>data utworzenia wpisu</td>
                    <td>${gift.dateOfGiftRegistration}</td>
                </tr>
                <tr>
                    <td>data przekazania daru</td>
                    <td>${gift.dateOfCollection}</td>
                </tr>
                <tr>
                    <td>dobra</td>
                    <td>${gift.type}</td>
                </tr>
                <tr>
                    <td>ilość worków</td>
                    <td>${gift.amountOfBags}</td>
                </tr>
            </table>
            <br/>
            <a href="/app/gifts" role="button">Wróć</a>
        </div>
    </div>

</header>

</body>
</html>
