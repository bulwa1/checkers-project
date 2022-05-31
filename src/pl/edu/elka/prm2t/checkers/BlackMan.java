package pl.edu.elka.prm2t.checkers;

public class BlackMan extends Man{
    BlackMan(int x, int y, Board board){ super(x, y, board); }

    @Override
    public boolean checkForTakes(){
        return checkIfTakePossible(x-2, y+2) || checkIfTakePossible(x+2, y+2);
    }
}
