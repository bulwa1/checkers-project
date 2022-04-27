package pl.edu.elka.prm2t.checkers;

import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel {

    private final int fieldSize = 64; // wielkość jednego pola
    private Board boardRef; // referencja do obiektu Board
    private int selectedFieldX = -1;
    private int selectedFieldY = -1;
    private int offSetX = 44;
    private int offSetY = 24;

    Screen(Board boardRef){
        this.boardRef = boardRef;
    }

    public int getOffSetX() {
        return offSetX;
    }

    public int getOffSetY(){
        return offSetY;
    }

    public void setChosenField(int fieldX, int fieldY){
        selectedFieldX = fieldX;
        selectedFieldY = fieldY;
    }

    public void paint(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        drawBoard(g);
        drawAvailableFields(g);
        drawMen(g);



    }

    private void drawBoard(Graphics g){
        // szalony algorytm rysowania planszy
        g.setColor(Color.BLACK);
        g.fillRect(offSetX - 6, offSetY -6, 8*fieldSize+12, 8*fieldSize+12);
        g.setColor(Color.WHITE);
        g.fillRect(offSetX, offSetY, 8*fieldSize, 8*fieldSize);
        g.setColor(Color.BLACK);
        for (int  i= 1;  i<= 64; i+=2) {
            g.fillRect(offSetX + (i - (i/8)*8 - (i/8)%2)*fieldSize, offSetY + (i/8) * fieldSize, fieldSize, fieldSize);
        }
    }


    private void drawAvailableFields(Graphics g){
        if(selectedFieldY != -1 && selectedFieldX != -1){
            g.setColor(Color.ORANGE);
            g.fillRect(offSetX + selectedFieldX*fieldSize, offSetY + selectedFieldY*fieldSize, fieldSize, fieldSize);
        }
    }

    private void drawMen(Graphics g){ // metoda do rysowania pionków na planszy
        Man[][] grid = boardRef.getGrid();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j] != null ){
                        if(grid[i][j] instanceof WhiteMan) g.setColor(Color.WHITE);
                        if(grid[i][j] instanceof BlackMan) g.setColor(Color.GRAY);
                        g.fillOval(offSetX + i*fieldSize + 8, offSetY + j*fieldSize + 8, 48, 48);
                    }
            }
        }
    }
}
