package pl.edu.elka.prm2t.checkers;

public class WhiteMan extends Man{

    WhiteMan(int x, int y, Board board){
        super(x, y, board);
    }

    @Override
    public boolean checkForTakes(){
        return checkIfTakePossible(x-2, y-2) || checkIfTakePossible(x+2, y-2);
    }
//    @Override public boolean checkIfTakePossible(int toX, int toY) {
//
//        if (toX < 0 || toX > 7) return false;
//        if (toY < 0 || toY > 7) return false;
//        int targetX = (x + toX) / 2;
//        int targetY = (y + toY) / 2;
//
//        if (x - toX == 2 || x - toX == -2) {
//            if (y - toY == 2) {
//                if (grid[x][y] instanceof WhiteMan) {
//                    if (grid[targetX][targetY] instanceof BlackMan || grid[targetX][targetY] instanceof BlackKing) {
//                        if (grid[toX][toY] == null) {
//                            if (y > toY) return true;
//                        }
//                    }
//                }
//            }
//        }
//        return false;
//    }

//    @Override
//    public boolean checkIfMoveForwardPossible(int toX, int toY){
//        boolean xChecker = false;
//        boolean yChecker = false;
//        boolean emptyPosition = false;
//
//        if (x - toX == 1 || x - toX == -1) {
//            xChecker = true;
//        }
//        if (y - toY == 1) {
//            yChecker = true;
//        }
//        if (grid[toX][toY] == null) {
//            emptyPosition = true;
//        }
//        return xChecker && yChecker && emptyPosition;
//    }



}


