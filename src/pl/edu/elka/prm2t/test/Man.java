package pl.edu.elka.prm2t.test;

public class Man {
    private int x;
    private int y;
    private final Man[][] grid;
    private final String color;

    Man(String color, int x, int y, Man[][] grid){
        this.color = color;
        this.x = x;
        this.y = y;
        this.grid = grid;
    }

    private boolean checkIfLegal(){
        return true;
    }

    public String getColor(){
        return color;
    }


    public void showPos(){
        System.out.println(x);
        System.out.println(y);
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
    public void becomeKing(Man manToRemove){
        grid[x][y] = null;
        King promotedMan = new King(color, x, y, grid);
        Player.getMenList().remove(manToRemove);
        Player.getMenList().add(promotedMan);
    }
}
