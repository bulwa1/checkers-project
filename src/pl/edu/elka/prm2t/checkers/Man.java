
package pl.edu.elka.prm2t.checkers;
public abstract class Man {
    protected int x;
    protected int y;
    protected final Man[][] grid;
    protected Board board;

    Man(int x, int y, Board board) {
        this.x = x;
        this.y = y;
        this.board = board;
        this.grid = board.getGrid();
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    // możliwe że nie działa
    public boolean checkIfAnyMovePossible() {
        if (grid[x][y] instanceof WhiteMan) {
            if (grid[x + 1][y - 1] == null || grid[x - 1][y - 1] == null) {
                return true;
            }
        }
        if (grid[x][y] instanceof BlackMan) {
            if (grid[x + 1][y + 1] == null || grid[x - 1][y + 1] == null) {
                return true;
            }
        }
        if (grid[x][y] instanceof King) {
            if (grid[x + 1][y - 1] == null || grid[x - 1][y - 1] == null || grid[x + 1][y + 1] == null || grid[x - 1][y + 1] == null) {
                return true;
            }
        }
        return false;
    }


    public boolean checkIfMoveForwardPossible(int toX, int toY) {
    return false;
    }


    protected void capture(int fromX, int fromY, int toX, int toY) {
        int targetX = (fromX + toX) / 2;
        int targetY = (fromY + toY) / 2;

        if (grid[targetX][targetY] instanceof Man) {
            board.removeFigure(grid[targetX][targetY]);
        }
    }


    public void moveForward(int toX, int toY) {
        grid[x][y] = null;
        this.x = toX;
        this.y = toY;
        grid[toX][toY] = this;
    }

    public boolean checkForTakes() {
        return false;
    }

    public boolean checkIfTakePossible(int toX, int toY) {
        return false;
    }

    public void undoMove(int toX, int toY){
        grid[x][y] = null;
        this.x = toX;
        this.y = toY;
        grid[toX][toY] = this;
    }

    public String move(int toX, int toY) {
        if (checkForTakes()) {
            if (checkIfTakePossible(toX, toY)) {
                capture(x, y, toX, toY);
                grid[x][y] = null;
                this.x = toX;
                this.y = toY;
                grid[toX][toY] = this;
                System.out.println("capture");
                return "capture";
            }
        } else if (x - toX == -1 || x - toX == 1) {
            if (y - toY == -1 || y - toY == 1) {
                if (checkIfMoveForwardPossible(toX, toY)) {
                    moveForward(toX, toY);
                    System.out.println("normal move");
                    return "normal";
                }
            }
        }
        return "none";
    }
}




