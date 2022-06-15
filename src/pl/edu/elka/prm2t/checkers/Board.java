package pl.edu.elka.prm2t.checkers;


import java.util.ArrayList;

public class Board {

    private Man[][] grid = new Man[8][8];

    public Man[][] getGrid() {
        return grid;
    }

    public ArrayList<Man> whiteMenList = new ArrayList<>();

    public ArrayList<Man> blackMenList = new ArrayList<>();

    /**
     * Sprawdzanie, czy dla figur danego koloru występuje bicie
     * @param color
     * @return lista figur, które muszą bić (może być pusta)
     */
    public ArrayList<Man> checkForCapture(String color){
        ArrayList<Man> menWhoMustTake = new ArrayList<>();

        if(color.equals("white")){
            whiteMenList.forEach((man) -> {
                if(man.checkForTakes() == true){
                    menWhoMustTake.add(man);
                }
            });
        }
        if(color.equals("black")){
            blackMenList.forEach((man) -> {
                if(man.checkForTakes() == true){
                    menWhoMustTake.add(man);
                }
            });
        }
        return menWhoMustTake;
    }

    /**
     * Dodanie figur z planszy do listy figur danego gracza
     * @param figure
     */
    public void addToGrid(Man figure){
        int x = figure.getX();
        int y = figure.getY();
        if(figure instanceof WhiteMan || figure instanceof WhiteKing){
            whiteMenList.add(figure);
        }
        if(figure instanceof BlackMan || figure instanceof BlackKing){
            blackMenList.add(figure);
        }
        grid[x][y] = figure;
    }

    public ArrayList<Man> getWhiteMenList() {
        return whiteMenList;
    }

    public ArrayList<Man> getBlackMenList() {
        return blackMenList;
    }

    /**
     * Usunięcie figury, zarówno z planszy, jak i z listy graczy
     * @param figure
     */
    public void removeFigure(Man figure){
        int x = figure.getX();
        int y = figure.getY();
        if(figure instanceof WhiteMan){
            whiteMenList.remove(figure);
        }
        if(figure instanceof BlackMan){
            blackMenList.remove(figure);
        }
        if(figure instanceof WhiteKing){
            whiteMenList.remove(figure);
        }
        if(figure instanceof BlackKing){
            blackMenList.remove(figure);
        }
        grid[x][y] = null;

        System.out.println("White's figures: " + whiteMenList.size());
        System.out.println("Black's figures: " + blackMenList.size());
    }


    public void clear(){
        grid = new Man[8][8];
        whiteMenList = new ArrayList<Man>();
        blackMenList = new ArrayList<Man>();
    }

}






