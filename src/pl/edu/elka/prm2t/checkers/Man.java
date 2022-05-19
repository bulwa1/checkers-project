package pl.edu.elka.prm2t.checkers;

import java.util.ArrayList;

public abstract class Man {
    private int x;
    private int y;
    private final Man[][] grid;

    Man(int x, int y, Man[][] grid){
        this.x = x;
        this.y = y;
        this.grid = grid;
    }

    public void showPos(){
        System.out.println(x);
        System.out.println(y);
    }

    public int getXPos(){
        return x;
    }

    public int getYPos(){
        return y;
    }


    // po wybraniu pola przez gracza będzie sprawdzane, czy ruch jest możliwy
    public void move(int toX, int toY){
        // check if legal toX toY zasady
        // if true
        grid[x][y] = null;
        this.x = toX;
        this.y = toY;
        grid[toX][toY] = this;

    }



    // to będzie się aktywować dopiero po ruchu, gdy będzie sprawdzane, czy pionek jest na końcu planszy
    // do poprawienia
    protected void becomeKing(Man manToRemove){
        grid[x][y] = null;
//        King promotedMan = new King(x, y, grid);
//        Player.getMenList().remove(manToRemove);
//        grid[x][y] = promotedMan;
//        Player.getMenList().add(promotedMan);
    }
}
