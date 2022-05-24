package pl.edu.elka.prm2t.checkers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Board {

    private static final Man[][] grid = new Man[8][8];

    public Man[][] getGrid() {
        return grid;
    }


//    public void displayGrid() {
//        for (int j = 0; j < 8; j++) {
//            StringBuilder row = new StringBuilder();
//            for (int i = 0; i < 8; i++) {
//                if (grid[i][j] instanceof WhiteMan) row.append("w");
//                if (grid[i][j] instanceof WhiteKing) row.append("W");
//                if (grid[i][j] instanceof BlackMan) row.append("b");
//                if (grid[i][j] instanceof BlackKing) row.append("B");
//                if (grid[i][j] == null) row.append("0");
//
//            }
//            System.out.println(row);
//        }
//    }

    public void addToGrid(Man figure){
        int x = figure.getX();
        int y = figure.getY();
        grid[x][y] = figure;
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




//    public static void test(){
//        grid[0][0] = new Man(0,0,grid);
//
//        //grid[0][0].showPos();
//
//        grid[0][0].move(7, 7);
//
//
//        try{
//            grid[0][0].showPos();
//
//
//        }catch (NullPointerException e){
//            //
//        }
//        grid[7][7].showPos();
//
//    }


