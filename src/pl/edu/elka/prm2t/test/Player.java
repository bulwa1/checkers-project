package pl.edu.elka.prm2t.test;

import java.util.ArrayList;

public class Player {
    private static ArrayList<Man> menList = new ArrayList<>();
    private String color = "";
    private Board boardRef;

    Player(String color, Board boardRef){
        this.color = color;
        this.boardRef = boardRef;
        createNewMen(); // tymczasowo w konstruktorze ---> docelowa dać do Main
    }

    public void moveMan(int fromX, int fromY, int toX, int toY){
        boardRef.getGrid()[fromX][fromY].move(toX, toY);
    }

    public static ArrayList<Man> getMenList() {
        return menList;
    }

    //pionki powstają w 3 rzędach, asymetrycznie, na co drugim polu

    private void createNewMen(){
        if(color.equals("white")){
            for (int i = 0; i < 8; i+=2) {
                for (int j = 5; j <= 7 ; j+=2) {
                    Man manToAdd = new Man("white",i, j, boardRef.getGrid());
                    boardRef.getGrid()[i][j] = manToAdd;
                    menList.add(manToAdd);
                }
            }
            for(int k = 1; k<8; k+=2){
                Man manToAdd = new Man("white",k, 6, boardRef.getGrid());
                boardRef.getGrid()[k][6] = manToAdd;
                menList.add(manToAdd);
            }
        }


        if(color.equals("black")){
            for (int i = 1; i < 8; i+=2) {
                for (int j = 0; j <= 2 ; j+=2) {
                    Man manToAdd = new Man("black",i, j, boardRef.getGrid());
                    boardRef.getGrid()[i][j] = manToAdd;
                    menList.add(manToAdd);
                }
            }
            for(int k = 0; k<8; k+=2){
                Man manToAdd = new Man("black",k, 1, boardRef.getGrid());
                boardRef.getGrid()[k][1] = manToAdd;
                menList.add(manToAdd);
            }
        }
    }
}
