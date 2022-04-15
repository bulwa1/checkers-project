package pl.edu.elka.prm2t.test;

public class Man {
    private int x;
    private int y;
    private Man[][] grid;
    private String color;

    Man(String color, int x, int y, Man[][] grid){
        this.color = color;
        this.x = x;
        this.y = y;
        this.grid = grid;
    }

//    private boolean checkIfLegal(){
//
//    }

    public String getColor(){
        return color;
    }

    public void showPos(){
        System.out.println(x);
        System.out.println(y);
    }

    public void move(int toX, int toY){
        // check if legal toX toY zasady
        // if true
        grid[x][y] = null;
        this.x = toX;
        this.y = toY;
        grid[toX][toY] = this;




    }

}
