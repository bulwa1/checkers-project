package pl.edu.elka.prm2t.test;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();


        // kod potrzebny do wyswietlenia okienka
        JFrame f = new JFrame("Warcaby");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Screen s = new Screen(game.getMainBoard());
        f.add(s);
        f.setSize(512, 600);
        f.setVisible(true);
    }
}
