package pl.edu.elka.prm2t.checkers;

import java.util.ArrayList;

public class Game {
    private final ArrayList<String> movesHistory = new ArrayList<>();
    private String gameStatus;

    // public static void load()

    // public static void save(){board.saveGrid(gameName);}

    // tworzenie atrybutów, aby można było się do następnie odnosić
    private final Board mainBoard;
    private final Player playerWhite;
    private final Player playerBlack;

    Game() {
        mainBoard = new Board();
        playerWhite = new WhitePlayer(mainBoard);
        playerBlack = new BlackPlayer(mainBoard);
    }

    public Board getMainBoard() {
        return mainBoard;
    }
}


