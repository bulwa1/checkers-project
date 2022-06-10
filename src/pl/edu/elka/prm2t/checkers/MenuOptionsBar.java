package pl.edu.elka.prm2t.checkers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Field;

class MenuOptionsBar extends JMenuBar implements ActionListener{

    private JMenu fileTab;
    private JMenuItem open;
    private JMenuItem save;

    public MenuOptionsBar(){

        fileTab = new JMenu("File");
        this.add(fileTab);

        open = new JMenuItem("Open");
        fileTab.add(open);
        open.addActionListener(this);

        save = new JMenuItem("Save");
        fileTab.add(save);
        save.addActionListener(this);



    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == open){
            System.out.println("Open!");
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(null);

            if (response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
            }
        }

        if (e.getSource() == save){
            System.out.println("Save");


        }
    }
}
