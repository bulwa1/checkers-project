package pl.edu.elka.prm2t.checkers;


import javax.swing.*;
import java.util.ArrayList;


public class Game {
    private ArrayList<String> history = new ArrayList<>();
    private Man lastMovedFigure;


    private int turn = 1;
    private final Board mainBoard;
    private final Player playerWhite;
    private final Player playerBlack;
    private final Screen s;
    private boolean takeAgain;

    Game(Screen s) {
        mainBoard = new Board();
        playerWhite = new WhitePlayer(mainBoard);
        playerBlack = new BlackPlayer(mainBoard);
        this.s = s;
        history.add(save());

    }


    public void undo(){
            int lastBoardIndex = history.size() - 2;
            if(history.size() == 1){
                reset();
                return;
            }
            try{
                loadLastMove(history.get(lastBoardIndex));
                history.remove(lastBoardIndex);
            }catch (IndexOutOfBoundsException e){
                System.out.println("No more moves to undo!");
            }


    }

    public int getTurn() {
        return turn;
    }

    private void setTurn(int number) {
        turn = number;
    }

    /**
     * Obsługa tur i wielekrotnego bicia
     * @param movedFigure
     * @param typeOfMove
     */
    public void nextTurn(Man movedFigure, String typeOfMove){

        history.add(save());
        lastMovedFigure = movedFigure;

        if(mainBoard.whiteMenList.size() == 0){
            JOptionPane.showMessageDialog(null, "Player Black Wins!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("BLACKS WIN");
        }

        if(mainBoard.blackMenList.size() == 0){
            JOptionPane.showMessageDialog(null, "Player White Wins!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("WHITES WIN");
        }

        if(typeOfMove.equals("capture")){
            if(turn % 2 == 0 && mainBoard.checkForCapture("black").size() > 0){
                System.out.println("BLACK TAKES AGAIN");
                takeAgain = true;
                return;
            }

            if(turn % 2 != 0 && mainBoard.checkForCapture("white").size() > 0){
                System.out.println("WHITE TAKES AGAIN");
                takeAgain = true;
                return;
            }
        }

        takeAgain = false;
        turn++;
        s.nextTurn();

        if(turn % 2 == 0){
            System.out.println("Black's turn");
        }

        if(turn % 2 != 0){
            System.out.println("White's turn");
        }

    }

    /**
     * Figury z przymusem bicia
     * @return
     */
    public ArrayList<Man> obligatedMen(){
        String color = "white";
        if (turn % 2 == 0) color = "black";

        if(takeAgain){
            ArrayList<Man> obligatedMan = new ArrayList<>();
            if(lastMovedFigure.checkForTakes() == true){
                obligatedMan.add(lastMovedFigure);
                s.setObligatedMenFields(obligatedMan);
            }
            if(lastMovedFigure.checkForTakes() == false){
                takeAgain = false;
                turn++;
                s.setObligatedMenFields(obligatedMan);
                return obligatedMan;
            }
            return obligatedMan;
        }

        s.setObligatedMenFields(mainBoard.checkForCapture(color));
        return mainBoard.checkForCapture(color);
    }


    public Man getFigure(int x, int y){
        return mainBoard.getGrid()[x][y];
    }

    /**
     * Sprawdzanie, czy pionki doszły do końca planszy -> awans na damkę
     */
    public void checkForPlayerPromotion(){
        for (int i = 0; i < 8; i++) {
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

    /**
     * Zapis stanu gry do pliku
     * @return
     */
    public String save(){

        String savedGame = "";

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Man man = mainBoard.getGrid()[j][i];
                if (man instanceof WhiteMan) savedGame += "w";
                if (man instanceof WhiteKing) savedGame += "W";
                if (man instanceof BlackMan) savedGame += "b";
                if (man instanceof BlackKing) savedGame += "B";
                if (man == null) savedGame += "x";
            }
        }

        return savedGame + ";" + turn;
    }

    public void loadLastMove(String savedGame){
        clear();
        int turnNumber = Integer.parseInt(savedGame.split(";")[1]);
        setTurn(turnNumber);
        newGrid(savedGame);
        obligatedMen();
        s.repaint();
    }

    /**
     * Wczytanie stanu
     * @param savedGame
     */
    public void load(String savedGame){
        clear();
        history = new ArrayList<String>();
        int turnNumber = Integer.parseInt(savedGame.split(";")[1]);
        setTurn(turnNumber);
        newGrid(savedGame);
        obligatedMen();
        s.repaint();
    }

    private void clear(){
        mainBoard.clear();
    }

    /**
     * Reset gry
     */
    public void reset(){
        turn = 1;
        history = new ArrayList<String>();
        mainBoard.clear();
        playerWhite.createNewMen();
        playerBlack.createNewMen();
        obligatedMen();
        s.repaint();
    }

    /**
     * Tworzenie figur na planszy
     * @param savedBoard
     */
    public void newGrid(String savedBoard){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char character = savedBoard.charAt(j + i*8);
                Man newMan = null;
                if(character == 'w' ) newMan = new WhiteMan(j, i, mainBoard);
                if(character == 'W' ) newMan = new WhiteKing(j, i, mainBoard);
                if(character == 'b' ) newMan = new BlackMan(j, i, mainBoard);
                if(character == 'B' ) newMan = new BlackKing(j, i, mainBoard);
                if(character != 'x'){
                    mainBoard.addToGrid(newMan);
                }
            }
        }
    }

    public Board getMainBoard() {
        return mainBoard;
    }
}


