package pl.edu.elka.prm2t.test;

import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel {

    private int fieldSize = 64; // wielkość jednego pola
    private Board boardRef; // referencja do obiektu Board

    Screen(Board boardRef){
        this.boardRef = boardRef;
    }

    public void paint(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        drawBoard(g);
        drawMen(g);

    }

    private void drawBoard(Graphics g){
        // szalony algorytm rysowania planszy
        g.setColor(Color.BLACK);
        for (int  i= 1;  i<= 64; i+=2) {
            g.fillRect((i - (i/8)*8 - (i/8)%2)*fieldSize, (i/8) * fieldSize, fieldSize, fieldSize);
        }
    }

    private void drawMen(Graphics g){ // metoda do rysowania pionków na planszy
        Man[][] grid = boardRef.getGrid();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                try{
                    if(grid[i][j].getColor().equals("white")) g.setColor(Color.WHITE);
                    if(grid[i][j].getColor().equals("black")) g.setColor(Color.GRAY);
                    g.fillOval(i*fieldSize + 8, j*fieldSize + 8, 48, 48);
                }catch (NullPointerException e){
                    //
                }
            }
        }
    }
}
