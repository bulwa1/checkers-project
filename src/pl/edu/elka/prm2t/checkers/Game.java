package pl.edu.elka.prm2t.checkers;

import java.util.ArrayList;

public class Game {
    private final ArrayList<String> movesHistory = new ArrayList<>();
    private String gameStatus;

    // public static void load()

    // public static void save(){board.saveGrid(gameName);}

    // tworzenie atrybutów, aby można było się do następnie odnosić
    private int turn = 1;
    private final Board mainBoard;
    private final Player playerWhite;
    private final Player playerBlack;
    private final Screen s;

    Game(Screen s) {
        mainBoard = new Board();
        playerWhite = new WhitePlayer(mainBoard);
        playerBlack = new BlackPlayer(mainBoard);
        this.s = s;

    }

    public int getTurn() {
        return turn;
    }

    public void nextTurn(int fromX, int fromY, int toX, int toY){
//        mainBoard.getGrid()

        String mvMsg = "";

        if(turn % 2 == 0){
            mvMsg = "black;"+fromX+";"+fromY+";"+toX+";"+toY;
        }

        if(turn % 2 != 0){
            mvMsg = "white;"+fromX+";"+fromY+";"+toX+";"+toY;
        }

        System.out.println(mvMsg);

        System.out.println("Move " + turn);
        if(turn % 2 == 0 && mainBoard.checkForCapture("black").size() > 0){
            System.out.println("PONOWNE BICIE CZARNYCH");
            return;
        }

        if(turn % 2 != 0 && mainBoard.checkForCapture("white").size() > 0){
            System.out.println("PONOWNE BICIE BIAŁYCH");
            return;
        }

        turn++;
        s.nextTurn();

        if(turn % 2 == 0){
            System.out.println("Black's turn");
        }

        if(turn % 2 != 0){
            System.out.println("White's turn");
        }

    }

    public ArrayList<Man> obligatedMen(){
        String color = "white";
        if (turn % 2 == 0) color = "black";
        if (turn % 2 != 0) color = "white";
        return mainBoard.checkForCapture(color);
    }

    public Man getFigure(int x, int y){
        return mainBoard.getGrid()[x][y];
    }

    public void checkForPlayerPromotion(){
        for (int i = 0; i < 8; i++) {
//            System.out.println(mainBoard.getGrid()[i][0]);
            if(mainBoard.getGrid()[i][0] instanceof WhiteMan){
                playerWhite.promoteMan(mainBoard.getGrid()[i][0]);
            }
        }

        for (int i = 0; i < 8; i++) {
            if (mainBoard.getGrid()[i][7] instanceof BlackMan) {
                playerBlack.promoteMan(mainBoard.getGrid()[i][7]);
            }
        }
    }

    public Board getMainBoard() {
        return mainBoard;
    }
}


