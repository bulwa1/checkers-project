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



        //mainBoard.getGrid()

//        System.out.println(playerWhite);
    }

    public void checkForPlayerPromotion(){
//        System.out.println(123);
        for (int i = 0; i < 8; i++) {
//            System.out.println(mainBoard.getGrid()[i][0]);
            if(mainBoard.getGrid()[i][0] instanceof WhiteMan){
                playerWhite.promoteMan(i, 0);
            }
        }

    }

    public Board getMainBoard() {
        return mainBoard;
    }
}


