package pl.edu.elka.prm2t.checkers;

public class BlackPlayer extends Player{
    BlackPlayer(Board boardRef){
        super(boardRef);
        createNewMen();
    }

    @Override
    public void createNewMen(){
        for (int i = 1; i < 8; i+=2) {
            for (int j = 0; j <= 2 ; j+=2) {
                Man manToAdd = new BlackMan(i, j, boardRef);
                boardRef.addToGrid(manToAdd);
            }
        }
        for(int k = 0; k<8; k+=2){
            Man manToAdd = new BlackMan(k, 1, boardRef);
            boardRef.addToGrid(manToAdd);
        }
    }

    @Override
    public void promoteMan(Man manToPromote){
        BlackKing promotedMan = new BlackKing(manToPromote.getX(), manToPromote.getY(), boardRef);
        super.promoteMan(manToPromote);
        boardRef.addToGrid(promotedMan);
    }
}
