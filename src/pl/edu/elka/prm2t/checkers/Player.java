package pl.edu.elka.prm2t.checkers;

import java.util.ArrayList;

public abstract class Player {
    protected static ArrayList<Man> menList = new ArrayList<>();
    protected Board boardRef;

    Player(Board boardRef){
        this.boardRef = boardRef;
    }

    public void moveMan(int fromX, int fromY, int toX, int toY){
        boardRef.getGrid()[fromX][fromY].move(toX, toY);
    }

    public static ArrayList<Man> getMenList() {
        return menList;
    }

    //pionki powstają w 3 rzędach, asymetrycznie, na co drugim polu

    protected void createNewMen(){
        //
    }
    // TO DO TakeScannerKing (bije też do tyłu)
    // wszystko trzeba wrzucić do takiej pętli, żeby skanowało wielokrotne bicie
    public void TakeScanner(ArrayList<Man> figureList) {
        for (Man figure : figureList) {
            int x = figure.getXPos();
            int y = figure.getYPos();

            // testowanie wszystkich pól w okolicy pętlą
            // jak istnieje bicie to dodać do listy przymusowych ruchów (może jakoś zaznaczyć pionek z przymusem bicia)
            // powinno się aktywować na początku tury gracza!!!!!
        }
    }
    public void MoveScanner(Man figure){
        int x = figure.getXPos();
        int y = figure.getYPos();
            // bada wszystkie teoretycznie możliwe ruchy
            // odpala się, gdy TakeScanner nie wykryje bicia;
            // zaznacza pola, na które można się ruszyć danym pionem;
            // jak nie znajdzie możliwych ruchów, to gracz przegrywa;
            // MOŻEMY PRZYJĄĆ WARIANT, GDZIE KRÓL SIĘ RUSZA TAK JAK PIONEK, ALE MOŻE TEŻ BIĆ DO TYŁU
        }




    }






