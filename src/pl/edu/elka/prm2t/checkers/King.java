package pl.edu.elka.prm2t.checkers;

public abstract class King extends Man {

    King(int x, int y, Board board) {
        super(x, y, board);
        //super(x, y);
    }

//    @Override
//    public boolean checkIfTakePossible(int toX, int toY) {
//        return true;
//    }

    @Override
    public boolean checkIfMoveForwardPossible(int toX, int toY) {
        boolean xChecker = false;
        boolean yChecker = false;
        boolean emptyPosition = false;

        if (grid[x][y] instanceof King) {
            if (x - toX == 1 || x - toX == -1) {
                xChecker = true;
            }
            if (y - toY == -1 || y - toY == 1) {
                yChecker = true;
            }
            if (grid[toX][toY] == null) {
                emptyPosition = true;
            }
        }
        return xChecker && yChecker && emptyPosition;
    }
}