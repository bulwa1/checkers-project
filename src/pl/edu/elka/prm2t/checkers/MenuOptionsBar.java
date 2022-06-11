package pl.edu.elka.prm2t.checkers;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Locale;


public class MenuOptionsBar extends JMenuBar implements ActionListener {


    private JMenu fileTab;
    private JMenuItem open;
    private JMenuItem save;
    private JButton printButton;
    private JButton restart;
    private JButton undo;
    private Screen screen;

    public MenuOptionsBar(Screen screen) {
        this.screen = screen;

        fileTab = new JMenu("File");
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
                System.out.println(file);

                //TODO potrzebujemy zczytywacza danych wybranych z komputera
            }
        }

        if (e.getSource() == save) {
            System.out.println("Save!");

            //TODO potrzebujemy tutaj metody na save w boardzie lub gamie

//            Board boardToSave = new Board();
//            try {
//                boardToSave.saveGrid();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }

        }

        if (e.getSource() == restart) {
            System.out.println("Restart!");
            //TODO funkcja do restartu
        }

        if (e.getSource() == undo) {
            System.out.println("Undo!");
            //TODO funkcja do cofania ruchów
        }

        if (e.getSource() == printButton) {
//            try {
//
//                System.out.println("Shot!");
//
//                //TYLKO DLA ZABLOKOWANEJ TABLICY
//                Rectangle screenShot = new Rectangle(495,165,555,555);
//                Robot robot = new Robot();
//                BufferedImage shot = robot.createScreenCapture(screenShot);
//                File savedShot = new File("screenshot.png");
//                ImageIO.write(shot, "png", savedShot);
//
//            } catch (Exception exception) {
//                exception.printStackTrace();
//

            //FIXME to jest zdecydowanie lepsza metoda na screenshota lecz pokazuje się czarny screen

            try {
                String pngSave = JOptionPane.showInputDialog(null, "Save file", null, 1);

                if (!pngSave.toLowerCase().endsWith(".png")){
                    JOptionPane.showMessageDialog(null,"Error file must be in png format!",null,1);
                } else {
                    BufferedImage screenShot = new BufferedImage(screen.getWidth(),screen.getHeight(), BufferedImage.TYPE_INT_RGB);
                    this.paint(screenShot.createGraphics());
                    ImageIO.write(screenShot, "png",new File(pngSave));
                    JOptionPane.showMessageDialog(null,"Screen captured successfully!",null,1);
                }

            }catch (Exception exception){
                exception.printStackTrace();
            }

        }
    }


}
