package pl.edu.elka.prm2t.checkers;

import java.util.ArrayList;

public abstract class Player {
    protected ArrayList<Man> figureList = new ArrayList<>();
    protected Board boardRef;

    Player(Board boardRef){
        this.boardRef = boardRef;
    }

    public void moveMan(int fromX, int fromY, int toX, int toY){
        boardRef.getGrid()[fromX][fromY].moveForward(toX, toY);
    }

    public void promoteMan(int x, int y){
        figureList.remove(boardRef.getGrid()[x][y]);
        boardRef.getGrid()[x][y] = null;
    }

    public ArrayList<Man> getFigureList() {
        return figureList;
    }


    protected void createNewMen(){
    }

    }





