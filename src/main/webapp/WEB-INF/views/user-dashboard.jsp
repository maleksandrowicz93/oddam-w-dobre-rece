<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">

<jsp:include page="head.jsp"/>

<body>
<header class="header--form-page">

    <jsp:include page="user-menu.jsp"/>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Oddaj rzeczy, których już nie chcesz<br/>
                <span class="uppercase">potrzebującym</span>
            </h1>

            <div class="slogan--steps">
                <div class="slogan--steps-title">Wystarczą 4 proste kroki:</div>
                <ul class="slogan--steps-boxes">
                    <li>
                        <div><em>1</em><span>Wybierz rzeczy</span></div>
                    </li>
                    <li>
                        <div><em>2</em><span>Spakuj je w worki</span></div>
                    </li>
                    <li>
                        <div><em>3</em><span>Wybierz fundację</span></div>
                    </li>
                    <li>
                        <div><em>4</em><span>Zamów kuriera</span></div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Jeśli wiesz komu chcesz pomóc, możesz wpisać nazwę tej organizacji w
                wyszukiwarce. Możesz też filtrować organizacje po ich lokalizacji
                bądź celu ich pomocy.
            </p>
            <p data-step="4">
                Na podstawie Twoich kryteriów oraz rzeczy, które masz do oddania
                wybraliśmy organizacje, którym możesz pomóc. Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>
            <p data-step="5">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/5</div>

        <form:form modelAttribute="newGift" method="post">
            <!-- STEP 1: class .active is switching steps -->
            <div data-step="1" class="active">
                <h3>Zaznacz co chcesz oddać:</h3>

                <div class="form-group form-group--checkbox">
                    <label>
                        <form:checkbox path="products"
                                       name="products[]"
                                       value="clothes-to-use"
                        />
                        <span class="checkbox"></span>
                        <span class="description"
                        >ubrania, które nadają się do ponownego użycia</span
                        >
                    </label>
                </div>

                <div class="form-group form-group--checkbox">
                    <label>
                        <form:checkbox path="products"
                                       name="products[]"
                                       value="clothes-useless"
                        />
                        <span class="checkbox"></span>
                        <span class="description">ubrania, do wyrzucenia</span>
                    </label>
                </div>

                <div class="form-group form-group--checkbox">
                    <label>
                        <form:checkbox path="products"
                                       name="products[]"
                                       value="toys"/>
                        <span class="checkbox"></span>
                        <span class="description">zabawki</span>
                    </label>
                </div>

                <div class="form-group form-group--checkbox">
                    <label>
                        <form:checkbox path="products"
                                       name="products[]"
                                       value="books"/>
                        <span class="checkbox"></span>
                        <span class="description">książki</span>
                    </label>
                </div>

                <div class="form-group form-group--checkbox">
                    <label>
                        <form:checkbox path="products"
                                       name="products[]"
                                       value="other"/>
                        <span class="checkbox"></span>
                        <span class="description">inne</span>
                    </label>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 2 -->
            <div data-step="2">
                <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

                <div class="form-group form-group--inline">
                    <label>
                        Liczba 60l worków:
                        <form:input path="amountOfBags" type="number" name="bags" step="1" min="1"/>
                    </label>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 3 -->
            <div data-step="3">
                <h3>Lokalizacja:</h3>

                <div class="form-group form-group--dropdown">
                    <form:select path="localization" name="localization">
                        <option value="0">- wybierz -</option>
                        <option value="warsaw">Warszawa</option>
                        <option value="wroclaw">Wrocław</option>
                        <option value="poznan">Poznań</option>
                        <option value="gdansk">Gdańsk</option>
                    </form:select>
                </div>

                <div class="form-section">
                    <h4>Komu chcesz pomóc?</h4>
                    <div class="form-section--checkboxes">
                        <div class="form-group form-group--checkbox">
                            <label>
                                <form:checkbox path="helpFor" name="help[]" value="children"/>
                                    <%--<input type="checkbox" name="help[]" value="children">--%>
                                <span class="checkbox">dzieciom</span>
                            </label>
                        </div>

                        <div class="form-group form-group--checkbox">
                            <label>
                                <form:checkbox path="helpFor" name="help[]" value="mothers"/>
                                <span class="checkbox">samotnym matkom</span>
                            </label>
                        </div>

                        <div class="form-group form-group--checkbox">
                            <label>
                                <form:checkbox path="helpFor" name="help[]" value="homeless"/>
                                <span class="checkbox">bezdomnym</span>
                            </label>
                        </div>

                        <div class="form-group form-group--checkbox">
                            <label>
                                <form:checkbox path="helpFor" name="help[]" value="disabled"/>
                                <span class="checkbox">niepełnosprawnym</span>
                            </label>
                        </div>

                        <div class="form-group form-group--checkbox">
                            <label>
                                <form:checkbox path="helpFor" name="help[]" value="old"/>
                                <span class="checkbox">osobom starszym</span>
                            </label>
                        </div>
                    </div>
                </div>

                <div class="form-section">
                    <h4>Wpisz nazwę konkretnej organizacji (opcjonalnie)</h4>
                    <div class="form-group">
                        <form:textarea path="organizationName" rows="4" name="organization_search"/>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Szukaj</button>
                </div>
            </div>

            <!-- STEP 4 -->
            <div data-step="4">
                <h3>Wybierz organizacje, której chcesz pomóc:</h3>

                <c:forEach var="organization" items="${organizations}">
                    <div class="form-group form-group--checkbox">
                        <label>
                            <form:radiobutton path="organization" name="organization" value="old"/>
                            <span class="checkbox radio"></span>
                            <span class="description">
                  <div class="title">${organization.name}</div>
                  <div class="subtitle">
                    Cel i misja: ${organization.description}
                  </div>
                </span>
                        </label>
                    </div>
                </c:forEach>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 5 -->
            <div data-step="5">
                <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4>Adres odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Ulica <form:input path="address" name="address"/> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> Miasto <form:input path="city" name="city"/> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Kod pocztowy <form:input path="postcode" name="postcode"/>
                            </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Numer telefonu <form:input path="phone" name="phone"/>
                            </label>
                        </div>
                    </div>

                    <div class="form-section--column">
                        <h4>Termin odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Data <form:input path="date" type="date" name="date"/> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> Godzina <form:input path="time" type="time" name="time"/> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Uwagi dla kuriera
                                <form:textarea path="moreInfo" name="more_info" rows="5"/>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 6 -->
            <div data-step="6">
                <h3>Podsumowanie Twojej darowizny</h3>

                <div class="summary">
                    <div class="form-section">
                        <h4>Oddajesz:</h4>
                        <ul>
                            <li>
                                <span class="icon icon-bag"></span>
                                <span class="summary--text">${newGift.amountOfBags} worki
                                    <c:choose>
                                        <c:when test="${newGift.products.size()==1}">
                                            <c:forEach var="product" items="${newGift.products}">
                                                ${product}
                                            </c:forEach>
                                        </c:when>
                                        <c:otherwise>
                                            <c:forEach var="product" items="${newGift.products}">
                                                ${product},
                                            </c:forEach>
                                        </c:otherwise>
                                    </c:choose>
                                dla
                                <c:choose>
                                    <c:when test="${newGift.helpFor.size()==1}">
                                        <c:forEach var="who" items="${newGift.helpFor}">
                                            ${who}
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach var="who" items="${newGift.helpFor}">
                                            ${who},
                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>
                                </span>
                            </li>

                            <li>
                                <span class="icon icon-hand"></span>
                                <span class="summary--text"
                                >Dla fundacji "${newGift.organization.name}"
                                    w lokalizacji: ${newGift.organization.localization}</span>
                            </li>
                        </ul>
                    </div>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4>Adres odbioru:</h4>
                            <ul>
                                <li>${newGift.address}</li>
                                <li>${newGift.city}</li>
                                <li>${newGift.postcode}</li>
                                <li>${newGift.phone}</li>
                            </ul>
                        </div>

                        <div class="form-section--column">
                            <h4>Termin odbioru:</h4>
                            <ul>
                                <li>${newGift.date}</li>
                                <li>${newGift.time}</li>
                                <li>${newGift.moreInfo}</li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="submit" class="btn">Potwierdzam</button>
                </div>
            </div>

            <!-- STEP 7 -->
            <div data-step="7">
                <h2>
                    Dziękujemy za przesłanie formularza Na maila prześlemy wszelkie
                    informacje o odbiorze.
                </h2>
            </div>
        </form:form>
    </div>
</section>

<jsp:include page="footer.jsp"/>

</body>
</html>

