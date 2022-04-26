package pl.edu.elka.prm2t.checkers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void showPos() {

    }

    @Test
    void moveMan(){
        Board mainBoard = new Board();
        Player playerWhite = new Player("white", mainBoard);
        playerWhite.moveMan(0, 5, 1, 4);
        assertNull(mainBoard.getGrid()[0][5]);
        assertNotNull(mainBoard.getGrid()[1][4]);

    }

    @Test
    void becomeKing(){
        Board mainBoard = new Board();
        Player playerWhite = new Player("white", mainBoard);
        playerWhite.moveMan(0,5,0,0);
        System.out.println(mainBoard.getGrid()[0][0].getClass());

        assertEquals(true, mainBoard.getGrid()[0][0] instanceof King);


    }
}