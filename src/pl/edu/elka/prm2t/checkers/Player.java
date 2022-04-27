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
}
