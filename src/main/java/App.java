import gui.file_selector.FileSelector;

import javax.swing.*;
import java.awt.*;

public class App {

    public static void main(String[] args){

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                JFrame frame = new FileSelector("Select A Database File");

                frame.setSize(new Dimension(400, 400));
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }

        });

    }
}
