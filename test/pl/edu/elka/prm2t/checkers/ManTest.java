package pl.edu.elka.prm2t.checkers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManTest {

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
}