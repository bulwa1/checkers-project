package pl.edu.elka.prm2t.checkers;

public class WhitePlayer extends Player{
    WhitePlayer(Board boardRef){
        super(boardRef);
        createNewMen();
    }

    @Override
    protected void createNewMen(){
        for (int i = 0; i < 8; i+=2) {
            for (int j = 5; j <= 7 ; j+=2) {
                Man manToAdd = new WhiteMan(i, j, boardRef.getGrid());
                boardRef.getGrid()[i][j] = manToAdd;
                figureList.add(manToAdd);
            }
        }
        for(int k = 1; k<8; k+=2){
            Man manToAdd = new WhiteMan(k, 6, boardRef.getGrid());
            boardRef.getGrid()[k][6] = manToAdd;
            figureList.add(manToAdd);
        }
    }

}
