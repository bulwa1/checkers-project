package pl.edu.elka.prm2t.checkers;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {

    private static Man chosenFigure;

    public static void main(String[] args) {
        Game game = new Game();

        // kod potrzebny do wyświetlenia okienka
        JFrame f = new JFrame("Warcaby");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Screen s = new Screen(game.getMainBoard());
        f.add(s);
        s.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                final int fieldX = (e.getX() - s.getOffSetX()) / 64;
                final int fieldY = (e.getY() - s.getOffSetY()) / 64;

                if(chosenFigure == null){
                    chosenFigure = game.getMainBoard().getGrid()[fieldX][fieldY]; // tutaj trzeba ulatwic dostep
                    if(chosenFigure == null){
                        System.out.println("Empty here");
                        s.setChosenField(-1, -1);
                        s.repaint();
                        return;
                    }
                    s.setChosenField(fieldX, fieldY);
                    s.repaint();
                    return;
                }
                if(chosenFigure != null){
                    chosenFigure.moveForward(fieldX, fieldY);
                    chosenFigure = null;
                    s.setChosenField(-1, -1);
                    s.repaint();
                    return;
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
                //
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //
            }
        });
        f.setSize(600, 600);
        f.setVisible(true);
    }
}

