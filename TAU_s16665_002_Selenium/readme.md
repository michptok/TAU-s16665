# Run

> By uruchomić paczkę testów wenątrz IDE uruchom plik "testng.xml" klikając PPM > Run
>
# Test Scenario

## 1. XkomPageTest

### addItemToTheCart
1. Wejdź na stronę "https://www.x-kom.pl/".
2. Sprawdź tytuł strony.
3. Wyszukaj "Logitech M590 Multi Device Silent grafitowy".
4. Przejdz do wyszukanego przedmiotu.
5. Dodaj do koszyka.
6. Zweryfikuj czy pokazał się komunikat "Produkt dodany do koszyka".

### redirectToLoginPage
1. Wejdź na stronę "https://www.x-kom.pl/".
2. Sprawdź tytuł stron.
3. Kliknij na przycisk "Twoje konto".
4. Kliknij na przycisk "Zamówienia".
5. Zweryfikuj czy przekierowało do ekranu logowania z nagłówkiem "Zaloguj się".

## TrjPageTest

### 2. addComment
1. Wejdź na stronę "https://www.trojmiasto.pl".
2. Sprawdź tytuł strony.
3. Wejdź w trzeci artykuł z bocznej sekcji wiadomości nieposiadający miniaturki.
4. Kliknij przycisk "Dodaj opinię".
5. Wprowadź dowolne dane w komentarzu w pola odpowiadające tytułowi, treści i autorowi.
6. Nie wysyłaj formularza, bo wielokrotny spam spowoduje blokadę. 😅 

### findPastaMiasta
1. Wejdź na stronę "https://www.trojmiasto.pl".
2. Sprawdź tytuł strony.
3. Przejdź do sekcji wyszukiwania jedzenia na telefon.
4. Wyszukaj najlepszego makaronu w Gdyni wpisując w formularzu "Pasta Miasta".
5. Zweryfikuj czy wynik wyszukiwania odpowiada szukanej treści.
