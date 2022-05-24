package pl.edu.elka.prm2t.checkers;



public abstract class Man {
    private int x;
    private int y;
    private final Man[][] grid;

    Man(int x, int y, Man[][] grid) {
        this.x = x;
        this.y = y;
        this.grid = grid;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean checkIfAnyMovePossible(){
        if (grid[x][y] instanceof WhiteMan) {
            if(grid[x+1][y+1] == null || grid[x-1][y+1] == null){
            return true;}
        }
        if (grid[x][y] instanceof BlackMan) {
            if(grid[x+1][y-1] == null || grid[x-1][y-1] == null){
            return true;}
        }
        if (grid[x][y] instanceof King) {
            if (grid[x + 1][y - 1] == null || grid[x - 1][y - 1] == null || grid[x + 1][y + 1] == null || grid[x - 1][y + 1] == null){
            return true;}
        }
        return false;
    }

    public boolean checkIfMoveForwardPossible(int toX, int toY) {
        boolean xChecker = false;
        boolean yChecker = false;
        boolean emptyPosition = false;
        if (grid[x][y] instanceof WhiteMan) {
            if (x - toX == 1 || x - toX == -1) {
                xChecker = true;
            }
            if (y - toY == 1) {
                yChecker = true;
            }
        }
        if (grid[x][y] instanceof BlackMan) {
            if (x - toX == 1 || x - toX == -1) {
                xChecker = true;
            }
            if (y - toY == -1) {
                yChecker = true;
            }
        }
        if (grid[x][y] instanceof King) {
            if (x - toX == 1 || x - toX == -1) {
                xChecker = true;
            }
            if (y - toY == -1 || y - toY == 1) {
                yChecker = true;
            }
        }
        if (grid[toX][toY] == null) {
            emptyPosition = true;
        }
        return xChecker && yChecker && emptyPosition;
    }


    public void moveForward(int toX, int toY) {
            if (checkIfMoveForwardPossible(toX, toY)) {
//                becomeKing(toX, toY);
                grid[x][y] = null;
                this.x = toX;
                this.y = toY;
                grid[toX][toY] = this;

                System.out.println(checkIfTakePossible());


//            else gracz przegrywa; break;
        }
    }

    // sprawdza, czy jest jakakolwiek figura do zbicia
    public boolean checkIfTakePossible() {
        if (grid[x][y] instanceof WhiteMan) {
            if (grid[x + 1][y - 1] instanceof BlackMan || grid[x + 1][y - 1] instanceof BlackKing) {
                if (grid[x + 2][y - 1] == null) return true;
            }
            if (grid[x - 1][y - 1] instanceof BlackMan || grid[x - 1][y - 1] instanceof BlackKing) {
                if (grid[x - 2][y - 1] == null) return true;
            }
        }
        if (grid[x][y] instanceof BlackMan) {
            if (grid[x + 1][y + 1] instanceof WhiteMan || grid[x + 1][y + 1] instanceof WhiteKing) {
                if (grid[x + 2][y + 1] == null) return true;
            }
            if (grid[x - 1][y + 1] instanceof WhiteMan || grid[x - 1][y + 1] instanceof WhiteKing) {
                if (grid[x - 2][y + 1] == null) return true;
            }
        }
        if (grid[x][y] instanceof WhiteKing) {
            if (grid[x + 1][y - 1] instanceof BlackMan || grid[x + 1][y - 1] instanceof BlackKing) {
                if (grid[x + 2][y - 1] == null) return true;
            }
            if (grid[x - 1][y - 1] instanceof BlackMan || grid[x - 1][y - 1] instanceof BlackKing) {
                if (grid[x - 2][y - 1] == null) return true;
            }
            if (grid[x + 1][y + 1] instanceof BlackMan || grid[x + 1][y + 1] instanceof BlackKing) {
                if (grid[x + 2][y + 1] == null) return true;
            }
            if (grid[x - 1][y + 1] instanceof BlackMan || grid[x - 1][y + 1] instanceof BlackKing) {
                if (grid[x - 2][y + 1] == null) return true;
            }
        }
        if (grid[x][y] instanceof BlackKing) {
            if (grid[x + 1][y - 1] instanceof WhiteMan || grid[x + 1][y - 1] instanceof WhiteKing) {
                if (grid[x + 2][y - 1] == null) return true;
            }
            if (grid[x - 1][y - 1] instanceof WhiteMan || grid[x - 1][y - 1] instanceof WhiteKing) {
                if (grid[x - 2][y - 1] == null) return true;
            }
            if (grid[x + 1][y + 1] instanceof WhiteMan || grid[x + 1][y + 1] instanceof WhiteKing) {
                if (grid[x + 2][y + 1] == null) return true;
            }
            if (grid[x - 1][y + 1] instanceof WhiteMan || grid[x - 1][y + 1] instanceof WhiteKing) {
                if (grid[x - 2][y + 1] == null) return true;
            }
        }
        return false;
    }
}

