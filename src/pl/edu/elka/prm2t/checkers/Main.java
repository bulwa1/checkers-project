package pl.edu.elka.prm2t.checkers;


import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    private static Man chosenFigure;
    private static ArrayList<Man> obligatedMen = new ArrayList<>();

    public static void main(String[] args) {
        Screen s = new Screen();
        Game game = new Game(s);
        s.setBoardRef(game.getMainBoard());

        // kod potrzebny do wyświetlenia okienka
        JFrame f = new JFrame("Warcaby");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.add(s);
        s.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                final int fieldX = (e.getX() - s.getOffSetX()) / 64;
                final int fieldY = (e.getY() - s.getOffSetY()) / 64;


//                obligatedMen.forEach(man -> {
//
//                });

                if(chosenFigure == null){
                    chosenFigure = game.getFigure(fieldX, fieldY);
                    if(game.getTurn() % 2 == 0 && (chosenFigure instanceof WhiteMan ||chosenFigure instanceof WhiteKing)){
                        System.out.println("Not your turn!");
                        chosenFigure = null;
                        return;
                    }

                    if(game.getTurn() % 2 != 0 && (chosenFigure instanceof BlackMan|| chosenFigure instanceof BlackKing)){
                        System.out.println("Not your turn!");
                        chosenFigure = null;
                        return;
                    }



                    if(obligatedMen.size() > 0){

                       AtomicBoolean isLegal = new AtomicBoolean(false);

                        obligatedMen.forEach(man -> {
                            if(chosenFigure.equals(man)) isLegal.set(true);
                        });

                        if(!isLegal.get()){
                            chosenFigure = null;
                        }


                    }


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
                    boolean stateOfMove = chosenFigure.move(fieldX, fieldY);
                    if(stateOfMove){
                        game.nextTurn();
                        obligatedMen = game.obligatedMen();
                    }
                    chosenFigure = null;
                    s.setChosenField(-1, -1);
                    s.repaint();
                    game.checkForPlayerPromotion();
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

