package pl.edu.elka.prm2t.test;

import java.util.ArrayList;

public class Player {
    private ArrayList<Man> menList = new ArrayList<>(); // tymaczasowo publiczne
    private String color = "";
    private Board boardRef;

    Player(String color, Board boardRef){
        this.color = color;
        this.boardRef = boardRef;
        createNewMen(); // tymaczasowo w konstruktorze
    }

    public void moveMan(int fromX, int fromY, int toX, int toY){
        boardRef.getGrid()[fromX][fromY].move(toX, toY);
    }

    private void createNewMen(){
        if(color.equals("white")){
            for (int i = 0; i < 8; i++) {
                for (int j = 6; j <= 7 ; j++) {
                    Man manToAdd = new Man("white",i, j, boardRef.getGrid());
                    boardRef.getGrid()[i][j] = manToAdd;
                    menList.add(manToAdd);
                }
            }
        }

        if(color.equals("black")){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j <= 1 ; j++) {
                    Man manToAdd = new Man("black",i, j, boardRef.getGrid());
                    boardRef.getGrid()[i][j] = manToAdd;
                    menList.add(manToAdd);
                }
            }
        }

    }

}
