package pl.edu.elka.prm2t.checkers;

public class BlackMan extends Man{
    BlackMan(int x, int y, Man[][] grid){
        super(x, y, grid);
    }

    @Override
    public void move(int toX, int toY){
        super.move(toX, toY);
        if (toY == 7){
            becomeKing(this);
        }
    }
}
