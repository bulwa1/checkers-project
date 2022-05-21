package pl.edu.elka.prm2t.checkers;

import java.util.ArrayList;

public abstract class Player {
    protected static ArrayList<Man> figureList = new ArrayList<>();
    protected Board boardRef;

    Player(Board boardRef){
        this.boardRef = boardRef;
    }

    public void moveMan(int fromX, int fromY, int toX, int toY){
        boardRef.getGrid()[fromX][fromY].moveForward(toX, toY);
    }

    public static ArrayList<Man> getFigureList() {
        return figureList;
    }

    //pionki powstają w 3 rzędach, asymetrycznie, na co drugim polu

    protected void createNewMen(){
        //
    }

    }






