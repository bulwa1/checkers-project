package pl.edu.elka.prm2t.checkers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Board {

    private static final Man[][] grid = new Man[8][8];

    public Man[][] getGrid() {
        return grid;
    }

    private ArrayList<Man> whiteMenList = new ArrayList<>();

    private ArrayList<Man> blackMenList = new ArrayList<>();

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

    public void removeFigure(Man figure){
        int x = figure.getX();
        int y = figure.getY();
        if(figure instanceof WhiteMan){
            whiteMenList.remove(figure);
        }
        if(figure instanceof BlackMan){
            blackMenList.remove(figure);
        }
        grid[x][y] = null;

        System.out.println("White's figures: " + whiteMenList.size());
        System.out.println("Black's figures: " + blackMenList.size());
    }



    // nie testowane
    public void saveGrid() throws IOException {
        ArrayList<String> theBoardToSave = new ArrayList<>();
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                if (grid[i][j] instanceof WhiteMan) theBoardToSave.add("w");
                if (grid[i][j] instanceof WhiteKing) theBoardToSave.add("W");
                if (grid[i][j] instanceof BlackMan) theBoardToSave.add("b");
                if (grid[i][j] instanceof BlackKing) theBoardToSave.add("B");
                if (grid[i][j] == null) theBoardToSave.add("0");

            }
            theBoardToSave.add("/n");
        }
        for (String text : theBoardToSave) {
            while(text != null){
            FileOutputStream writer = new FileOutputStream("gameSave.txt", true);
            if (!text.equals("/n")) {
                writer.write(text.getBytes());
            }
            writer.flush();
            writer.close();
            }
        }
    }
}






