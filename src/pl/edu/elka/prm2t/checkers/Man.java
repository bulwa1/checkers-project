
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


    /**
     * Sprawdzanie, czy ruch pionka na dane pole jest możliwy (czy jest poprawny)
     * @param toX pole końcowe X
     * @param toY pole końcowe Y
     * @return true, jeśli ruch jest poprawny
     */
    public boolean checkIfMoveForwardPossible(int toX, int toY) {
    return false;
    }

    /**
     * Zbijanie figury
     * @param fromX pole początkowe X
     * @param fromY pole początkowe Y
     * @param toX pole końcowe X
     * @param toY pole końcowe Y
     */
    protected void capture(int fromX, int fromY, int toX, int toY) {
        int targetX = (fromX + toX) / 2;
        int targetY = (fromY + toY) / 2;

        if (grid[targetX][targetY] instanceof Man) {
            board.removeFigure(grid[targetX][targetY]);
        }
    }

    /**
     * Ruszanie się pionkiem
     * @param toX pole końcowe X
     * @param toY pole końcowe Y
     */
    public void moveForward(int toX, int toY) {
        grid[x][y] = null;
        this.x = toX;
        this.y = toY;
        grid[toX][toY] = this;
    }

    /**
     * Sprawdzanie, czy dla danego pionka jest możliwe bicie
     * @return true, jeśli jest dostępne bicie
     */
    public boolean checkForTakes() {
        return false;
    }

    /**
     * Sprawdzenie, czy konkretne bicie jest poprawne
     * @param toX pole końcowe X
     * @param toY pole końcowe Y
     * @return true, jeśli jest poprawne
     */
    public boolean checkIfTakePossible(int toX, int toY) {
        return false;
    }

    /**
     * Cofanie ruchu - zmiana obecnego położenia pionka na dawne
     * @param toX pole końcowe X
     * @param toY pole końcowe Y
     */
    public void undoMove(int toX, int toY){
        grid[x][y] = null;
        this.x = toX;
        this.y = toY;
        grid[toX][toY] = this;
    }

    /**
     * Funkcja poruszjąca pionek - bada, czy jest możliwe bicie, a jeśli jest to nakazuje bić, w przeciwnym razie
     * pozwala na zwykłe poruszenie
     * @param toX pole końcowe X
     * @param toY pole końcowe Y
     * @return
     */
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




