package pl.edu.elka.prm2t.checkers;

public class BlackPlayer extends Player{
    BlackPlayer(Board boardRef){
        super(boardRef);
        createNewMen();
    }

    @Override
    protected void createNewMen(){
        for (int i = 1; i < 8; i+=2) {
            for (int j = 0; j <= 2 ; j+=2) {
                Man manToAdd = new BlackMan(i, j, boardRef.getGrid());
                boardRef.getGrid()[i][j] = manToAdd;
                figureList.add(manToAdd);
            }
        }
        for(int k = 0; k<8; k+=2){
            Man manToAdd = new BlackMan(k, 1, boardRef.getGrid());
            boardRef.getGrid()[k][1] = manToAdd;
            figureList.add(manToAdd);
        }
    }

    @Override
    public void promoteMan(int x, int y){
        super.promoteMan(x, y);
        BlackKing promotedMan = new BlackKing(x, y, boardRef.getGrid());
        boardRef.addToGrid(promotedMan);
        getFigureList().add(promotedMan);
    }
}
