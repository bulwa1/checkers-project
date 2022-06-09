package pl.edu.elka.prm2t.checkers;

public abstract class King extends Man {

    King(int x, int y, Board board) {
        super(x, y, board);
        //super(x, y);
    }

    @Override
    public boolean checkIfTakePossible(int toX, int toY) {
        return false;
    }
}

