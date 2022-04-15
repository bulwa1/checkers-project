package pl.edu.elka.prm2t.test;

import java.util.ArrayList;

public class Game {
    private ArrayList<String> movesHistory = new ArrayList<>();

   // public static void load()

    // public static void save()

    public static void init(){
        Board mainBoard = new Board();
        Player playerWhite = new Player("white", mainBoard);
        Player playerBlack = new Player("black", mainBoard);

        // program testowy
        // pokazuje 1 gdy na danym polu jest biały pionek
        // pokazuje 2 gdy na danym polu jest czarny pionek
        // pokazuje 0 gdy na dane pole jest puste
        System.out.println("Plansza początkowa:");
        mainBoard.displayGrid();

        System.out.println(" ");
        System.out.println("Plansza po ruchu:");

        playerWhite.moveMan(0, 6, 1, 5);

        mainBoard.displayGrid();
    }

    public static void main(String[] args) {
        init(); // program testowy
    }
}
