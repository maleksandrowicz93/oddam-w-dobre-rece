<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">

<jsp:include page="head.jsp"/>

<body>

<jsp:include page="header.jsp"/>

<section class="stats">
    <div class="container container--85">
        <div class="stats--item">
            <em>${bagsAmountOfAllOnes}</em>
            <h3>Oddanych worków</h3>
            <p>Dary zawierają:
                <c:forEach var="product" items="${products}" varStatus="iterating">
                    <c:choose>
                        <c:when test="${iterating.last}">
                            ${product}.
                        </c:when>
                        <c:otherwise>
                            ${product},
                        </c:otherwise>
                    </c:choose>
                </c:forEach></p>
        </div>

        <div class="stats--item">
            <em>${organizationsAmountOfAllOnes}</em>
            <h3>Wspartych organizacji</h3>
            <p>Pomagającym:
                <c:forEach var="typeOfHelp" items="${helpFor}" varStatus="iterating">
                    <c:choose>
                        <c:when test="${iterating.last}">
                            ${typeOfHelp}.
                        </c:when>
                        <c:otherwise>
                            ${typeOfHelp},
                        </c:otherwise>
                    </c:choose>
                </c:forEach></p>
        </div>

        <div class="stats--item">
            <em>${gitsAmountOfAllOnes}</em>
            <h3>Zorganizowanych zbiórek</h3>
            <p>W następujących lokalizacjach:
                <c:forEach var="localization" items="${localizations}" varStatus="iterating">
                    <c:choose>
                        <c:when test="${iterating.last}">
                            ${localization}.
                        </c:when>
                        <c:otherwise>
                            ${localization},
                        </c:otherwise>
                    </c:choose>
                </c:forEach></p>
        </div>
    </div>
</section>

<section class="steps">
    <h2>Wystarczą 4 proste kroki</h2>

    <div class="steps--container">
        <div class="steps--item">
            <span class="icon icon--hands"></span>
            <h3>Wybierz rzeczy</h3>
            <p>ubrania, zabawki, sprzęt i inne</p>
        </div>
        <div class="steps--item">
            <span class="icon icon--arrow"></span>
            <h3>Spakuj je</h3>
            <p>skorzystaj z worków na śmieci</p>
        </div>
        <div class="steps--item">
            <span class="icon icon--glasses"></span>
            <h3>Zdecyduj komu chcesz pomóc</h3>
            <p>wybierz zaufane miejsce</p>
        </div>
        <div class="steps--item">
            <span class="icon icon--courier"></span>
            <h3>Zamów kuriera</h3>
            <p>kurier przyjedzie w dogodnym terminie</p>
        </div>
    </div>

    <a href="/register" class="btn btn--large">Załóż konto</a>
</section>

<section class="about-us">
    <div class="about-us--text">
        <h2>O nas</h2>
        <p>Celem naszej organizacji jest stworzenie miejsca, w którym każdy będzie mógł oddać niepotrzebne rzeczy
            zaufanym instytucjom.<br>
            Wiele ludzi ma w domu rzeczy, których nie używa, ale są one w dobrym stanie i chce przekazać je osobom,
            którym się mogą przydać - nie wie jednak jak w prosty sposób to zrobić.<br>
            Jest wiele dostępnych rozwiązań, ale wiele z nich wymaga dodatkowego wysiłku lub nie budzą one zaufania. W
            zweryfikowane miejsca trzeba pojechać, a nie ma na to czasu lub dojazd nie jest najprostszy. Natomiast kontenery
            pod domem lub lokalne zbiórki są niezweryfikowane i nie wiadomo czy te rzeczy faktycznie trafią do
            potrzebujących.</p>
        <img src="../../static/images/signature.svg" class="about-us--text-signature" alt="Signature"/>
    </div>
    <div class="about-us--image"><img src="../../static/images/about-us.jpg" alt="People in circle"/></div>
</section>

<section class="help">
    <h2>Komu pomagamy?</h2>

    <ul class="help--buttons">
        <li data-id="1"><a href="#" class="btn btn--without-border active">Fundacjom</a></li>
        <li data-id="2"><a href="#" class="btn btn--without-border">Organizacjom pozarządowym</a></li>
        <li data-id="3"><a href="#" class="btn btn--without-border">Lokalnym zbiórkom</a></li>
    </ul>

    <!-- SLIDE 1 -->
    <div class="help--slides active" data-id="1">
        <p>W naszej bazie znajdziesz listę zweryfikowanych Fundacji, z którymi współpracujemy.
            Możesz sprawdzić czym się zajmują, komu pomagają i czego potrzebują.</p>

        <ul class="help--slides-items">
            <li>
                <div class="col">
                    <div class="title">Fundacja "Dbam o Zdrowie"</div>
                    <div class="subtitle">Cel i misja: Pomoc dzieciom z ubogich rodzin.</div>
                </div>

                <div class="col">
                    <div class="text">ubrania, jedzenie, sprzęt AGD, meble, zabawki</div>
                </div>
            </li>

            <li>
                <div class="col">
                    <div class="title">Fundacja “Dla dzieci"</div>
                    <div class="subtitle">Cel i misja: Pomoc osobom znajdującym się w trudnej sytuacji życiowej.</div>
                </div>

                <div class="col">
                    <div class="text">ubrania, meble, zabawki</div>
                </div>
            </li>

            <li>
                <div class="col">
                    <div class="title">Fundacja “Bez domu”</div>
                    <div class="subtitle">Cel i misja: Pomoc dla osób nie posiadających miejsca zamieszkania</div>
                </div>

                <div class="col">
                    <div class="text">ubrania, jedzenie, ciepłe koce</div>
                </div>
            </li>
        </ul>

        <ul class="help--slides-pagination">
            <li><a href="#" class="btn btn--small btn--without-border active" data-page="1">1</a></li>
            <li><a href="#" class="btn btn--small btn--without-border" data-page="2">2</a></li>
            <li><a href="#" class="btn btn--small btn--without-border" data-page="3">3</a></li>
        </ul>
    </div>

    <!-- SLIDE 2 -->
    <div class="help--slides" data-id="2">
        <p>W naszej bazie znajdziesz listę zweryfikowanych Organizacji pozarządowych, z którymi współpracujemy.
            Możesz sprawdzić czym się zajmują, komu pomagają i czego potrzebują.</p>
        <ul class="help--slides-items">
            <li>
                <div class="col">
                    <div class="title">Organizacja 1</div>
                    <div class="subtitle">Lorem ipsum dolor sit amet consectetur.</div>
                </div>

                <div class="col">
                    <div class="text">Lorem ipsum dolor sit amet consectetur adipisicing elit.</div>
                </div>
            </li>

            <li>
                <div class="col">
                    <div class="title">Organizacja 2</div>
                    <div class="subtitle">Lorem ipsum dolor sit amet consectetur.</div>
                </div>

                <div class="col">
                    <div class="text">Lorem ipsum dolor sit amet consectetur adipisicing elit.</div>
                </div>
            </li>

            <li>
                <div class="col">
                    <div class="title">Organizacja 3</div>
                    <div class="subtitle">Lorem ipsum dolor sit amet consectetur.</div>
                </div>

                <div class="col">
                    <div class="text">Lorem ipsum dolor sit amet consectetur adipisicing elit.</div>
                </div>
            </li>

            <li>
                <div class="col">
                    <div class="title">Organizacja 4</div>
                    <div class="subtitle">Lorem ipsum dolor sit amet consectetur.</div>
                </div>

                <div class="col">
                    <div class="text">Lorem ipsum dolor sit amet consectetur adipisicing elit.</div>
                </div>
            </li>
        </ul>

        <ul class="help--slides-pagination">
            <li><a href="#" class="btn btn--small btn--without-border active" data-page="1">1</a></li>
            <li><a href="#" class="btn btn--small btn--without-border" data-page="2">2</a></li>
            <li><a href="#" class="btn btn--small btn--without-border" data-page="3">3</a></li>
            <li><a href="#" class="btn btn--small btn--without-border" data-page="4">4</a></li>
            <li><a href="#" class="btn btn--small btn--without-border" data-page="5">5</a></li>
        </ul>
    </div>

    <!-- SLIDE 3 -->
    <div class="help--slides" data-id="3">
        <p>W naszej bazie znajdziesz listę zweryfikowanych lokalnych zbiórek, z którymi współpracujemy.
            Możesz sprawdzić czym się zajmują, komu pomagają i czego potrzebują.</p>
        <ul class="help--slides-items">
            <li>
                <div class="col">
                    <div class="title">Lokalna zbiórka 1</div>
                    <div class="subtitle">Lorem ipsum dolor sit amet consectetur.</div>
                </div>

                <div class="col">
                    <div class="text">Lorem ipsum dolor sit amet consectetur adipisicing elit.</div>
                </div>
            </li>

            <li>
                <div class="col">
                    <div class="title">Lokalna zbiórka 2</div>
                    <div class="subtitle">Lorem ipsum dolor sit amet consectetur.</div>
                </div>

                <div class="col">
                    <div class="text">Lorem ipsum dolor sit amet consectetur adipisicing elit.</div>
                </div>
            </li>
        </ul>

        <ul class="help--slides-pagination">
            <li><a href="#" class="btn btn--small btn--without-border active" data-page="1">1</a></li>
            <li><a href="#" class="btn btn--small btn--without-border" data-page="2">2</a></li>
        </ul>
    </div>
</section>

<jsp:include page="footer.jsp"/>

</body>
</html>