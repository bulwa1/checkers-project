package pl.edu.elka.prm2t.checkers;

import java.util.ArrayList;

public class Game {
    private final ArrayList<String> movesHistory = new ArrayList<>();
    private String gameStatus;

   // public static void load()

    // public static void save()

    // tworzenie atrybutów aby można było się do następnie odnosić
    private final Board mainBoard;
    private Player playerWhite;
    private Player playerBlack;

    Game(){
        mainBoard = new Board();
        playerWhite = new Player("white", mainBoard);
        playerBlack = new Player("black", mainBoard);
    }

    public Board getMainBoard() {
        return mainBoard;
    }

    public void init(){
        // program testowy
        // pokazuje w gdy na danym polu jest biały pionek
        // pokazuje W gdy na danym polu jest biała damka
        // pokazuje b gdy na danym polu jest czarny pionek
        // pokazuje B gdy na danym polu jest czarna damka
        // pokazuje 0 gdy na dane pole jest puste
        System.out.println("Plansza początkowa:");
        mainBoard.displayGrid();

        System.out.println(" ");
        System.out.println("Plansza po ruchu:");

        playerWhite.moveMan(0, 5, 1, 4);

        mainBoard.displayGrid();
    }

}

