package pl.edu.elka.prm2t.checkers;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Locale;


public class MenuOptionsBar extends JMenuBar implements ActionListener {


    private JMenu fileTab;
    private JMenuItem open;
    private JMenuItem save;
    private JButton printButton;
    private JButton restart;
    private JButton undo;
    private Screen screen;
    private Game game;

    public MenuOptionsBar(Screen screen, Game game) {
        this.screen = screen;
        this.game = game;

        fileTab = new JMenu("Game");
        this.add(fileTab);

        open = new JMenuItem("Open");
        fileTab.add(open);
        open.addActionListener(this);

        save = new JMenuItem("Save");
        fileTab.add(save);
        save.addActionListener(this);

        this.add(Box.createHorizontalGlue());

        printButton = new JButton("Print");
        this.add(printButton);
        printButton.addActionListener(this);

        restart = new JButton("Restart");
        this.add(restart);
        restart.addActionListener(this);

        undo = new JButton("Undo");
        this.add(undo);
        undo.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == open) {
            System.out.println("Open!");
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());


                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String savedGame = reader.readLine();
                    reader.close();
                    game.load(savedGame);
//                    game.setTurn(Character.getNumericValue(savedGame.charAt(savedGame.length() - 1)));
//                    game.newGrid(savedGame);

                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }


                System.out.println(file);

                //TODO potrzebujemy zczytywacza danych wybranych z komputera
            }
        }

        if (e.getSource() == save) {
            System.out.println("Save!");

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Select the file with saved game");

            String savedGame = game.save();


            int response = fileChooser.showSaveDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    writer.write(savedGame);
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                //TODO potrzebujemy zczytywacza danych wybranych z komputera
            }
        }

        if (e.getSource() == restart) {
            System.out.println("Restart!");
            game.reset();
        }

        if (e.getSource() == undo) {
            System.out.println("Undo!");

            game.undo();
            screen.repaint();

            //TODO funkcja do cofania ruchów
        }

        if (e.getSource() == printButton) {

            try {
                JFileChooser fileChooser = new JFileChooser();
                String pngSave = whereToSave(fileChooser);

                if (!pngSave.toLowerCase().endsWith(".png")){
                    JOptionPane.showMessageDialog(null,"Error file must be in png format!",null,1);
                } else {
                    BufferedImage screenShot = new BufferedImage(screen.getWidth(),screen.getHeight(), BufferedImage.TYPE_INT_RGB);
                    screen.paint(screenShot.createGraphics());
                    ImageIO.write(screenShot, "png",new File(pngSave));
                    JOptionPane.showMessageDialog(null,"Screen captured successfully!",null,1);
                }

            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }

    private String whereToSave(JFileChooser fC){
        int retVal = fC.showSaveDialog(null);
        if (retVal == JFileChooser.APPROVE_OPTION){
            File file = fC.getSelectedFile();
            return file.getAbsolutePath();
        }
        return null;
    }





}
