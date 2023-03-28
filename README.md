# Warcaby PRM2T

## O projekcie

Celem naszego projektu jest odtworzenie w języku Java klasycznej i ponadczasowej gry jaką są Warcaby.  Program będzie pozwalać na rozegranie partii pomiędzy dwoma rzeczywistymi graczami. Zapamiętywanie rezultatów rozgrywki zapewni zapis gry do pliku tekstowego oraz tym samym szybki odczyt danego stanu gry. W planach mamy implementację bota, który z którym gracz będzie mógł się zmierzyć.

## Schemat gry


0. Tura gracza 1
1. Sprawdzenie, czy gracz ma jeszcze figury [player.figureList] 
2. Gracz klika figurę, którą chce się ruszyć [granice pól do poprawy i ikona króla do dorobienia]
3. Sprawdzanie przymusów bicia dla wszystkich (w pętli dla figur gracza, ale też w pętli dla bicia wielokrotnego): [man.checkIfTakePossible]

    - jeśli występują, zaznaczamy figurę, która musi bić (np. pole na żółto) [trzeba zrobić respektowanie przymusu bicia, bo narazie jest tylko sprawdzanie]

    - jak nie ma, to sprawdza, czy dany pionek może się w ten sposób ruszyć (czyli o 1 pole do przodu): [man.checkIfAnyMovePossible]
     --> bicie nie występuje (byłoby wychwycone wcześniej) [man.moveForward]
4. Następuje ruch i jego konsekwencje na planszy
5. Nowa tura gracza 2

## Zasady gry

### Warcaby angielskie

- Plansza 8x8

- W przypadku przymusu bicia, wybierane jest dowolne bicie (niekoniecznie najlepsze)

- Pionki ruszają się oraz biją tylko do przodu

- Damki ruszają się do przodu i do tyłu, ale tylko o jedno pole

- Damki biją do przodu i do tyłu
