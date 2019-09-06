<img alt="Logo" src="static/images/header-bg.jpg">

# "Oddam w dobre ręce".
## Informacje o projekcie.

> Cel projektu.

Celem projektu jest stworzenie miejsca, w którym każdy będzie mógł oddać niepotrzebne rzeczy zaufanym instytucjom.

> Skąd pomysł na projekt?

-  Użytkownik ma w domu rzeczy, których nie używa, ale są  one w dobrym stanie i chce przekazać je osobom, którym się mogą przydać - nie wie jednak jak w prosty sposób to zrobić.
- Jest wiele dostępnych rozwiązań, ale wiele z nich wymaga dodatkowego wysiłku lub nie budzą one zaufania.
W zweryfikowane miejsca trzeba pojechać, a nie ma na to czasu lub nie ma jak tam pojechać. Natomiast kontenery pod domem lub lokalne zbiórki są niezweryfikowane i nie wiadomo czy te rzeczy faktycznie trafią do potrzebujących. 

## Technologie do użycia
- Spring MVC
- Spring Form
- Hibernate
- opcjonalnie Spring Security

## Wymagane funkcjonalności
1. *Landing page*, który ma zachęcać do skorzystania z aplikacji.
2. Profil administratora:
     - logowanie,
     - zarządzanie (**CRUD**) administratorami,
     - zarządzanie (**CRUD**) zaufanymi instytucjami,
     - przeglądanie, edycja, usuwanie zarejestrowanych użytkowników,
     - przegląd przekazanych darów.
3. Profil użytkownika:
     - rejestracja,
     - logowanie (ten sam formularz co dla administratora),
     - edycja własnego profilu,
     - dodawanie darów,
     - przeglądanie, edycja, kasowanie przekazanych darów,
     - zaznaczenie, że dar został komuś oddany (archiwizacja).
     
## Dodatkowe funkcjonalności
- potwierdzenie aktywacji konta poprzez wiadomość przesłaną na email podany przy rejestracji,
- obsługa zapomnianych haseł,
- walidacja poprawnego podania dwóch identycznych haseł,
- walidacja obsługi administratorów (np. brak możliwości skasowania ostatniego istniejącego administratora).
