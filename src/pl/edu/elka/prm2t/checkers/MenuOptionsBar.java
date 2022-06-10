package pl.edu.elka.prm2t.checkers;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;


public class MenuOptionsBar extends JMenuBar implements ActionListener {


    private JMenu fileTab;
    private JMenuItem open;
    private JMenuItem save;
    private JButton restart;
    private JButton undo;
    private JButton printButton;
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

        restart = new JButton("Restart");
        this.add(restart);
        restart.addActionListener(this);

        undo = new JButton("Undo");
        this.add(undo);
        undo.addActionListener(this);

        printButton = new JButton("Print");
        this.add(printButton);
        printButton.addActionListener(this);
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
            }
        }

        if (e.getSource() == save) {
            System.out.println("Save");
            // potrzebna metoda na ten save

//            Board boardToSave = new Board();
//            try {
//                boardToSave.saveGrid();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }


        }

        if (e.getSource() == restart) {
            System.out.println("witam");
        }

        if (e.getSource() == undo) {
            System.out.println("undo");
        }

        if (e.getSource() == printButton) {

            try {

                System.out.println("Shot!");
                Dimension sizeOfShot = screen.getSize();
                System.out.println(sizeOfShot);

                Rectangle boundsOfShot = screen.getBounds();
                System.out.println(boundsOfShot);

                Rectangle screenShot = new Rectangle();
                Robot robot = new Robot();
                BufferedImage shot = robot.createScreenCapture(screenShot);
                File savedShot = new File("screenshot.png");
                ImageIO.write(shot, "png", savedShot);

            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }
    }


}
