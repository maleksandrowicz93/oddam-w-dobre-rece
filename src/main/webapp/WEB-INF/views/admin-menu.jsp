<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="container container--70">
    <ul class="nav--actions">
        <li class="logged-user">
            Witaj Agata
            <ul class="dropdown">
                <li><a href="/admin/profile">Profil</a></li>
                <li><a href="/admin/settings">Ustawienia</a></li>
                <li><a href="/admin/admins">Administratorzy</a></li>
                <li><a href="/admin/users">Użytkownicy</a></li>
                <li><a href="/admin/organizations">Organizajce</a></li>
                <li><a href="/admin/gifts">Dary</a></li>
                <li><a href="/logout">Wyloguj</a></li>
            </ul>
        </li>
    </ul>

    <ul>
        <li><a href="/admin" class="btn btn--without-border active">Start</a></li>
        <li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>
        <li><a href="#" class="btn btn--without-border">O nas</a></li>
        <li>
            <a href="#" class="btn btn--without-border"
            >Fundacje i organizacje</a
            >
        </li>
        <li><a href="#" class="btn btn--without-border">Kontakt</a></li>
    </ul>
</nav>