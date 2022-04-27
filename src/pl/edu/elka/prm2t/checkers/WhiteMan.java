package pl.edu.elka.prm2t.checkers;

public class WhiteMan extends Man{

    WhiteMan(int x, int y, Man[][] grid){
        super(x, y, grid);
    }

    @Override
    public void move(int toX, int toY){
        super.move(toX, toY);
        if (toY == 0){
            becomeKing(this);
        }
    }
}
