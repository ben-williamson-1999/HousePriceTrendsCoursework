package uk.ac.mmu.stu.house_trends_application;

import uk.ac.mmu.stu.house_trends_application.gui.SwingGUI;

import javax.swing.*;
import java.awt.*;

public class App {

    public static void main(String[] args){

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                JFrame frame = new SwingGUI("House Price Search Application");

                frame.setSize(new Dimension(800, 600));
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }

        });

    }
}
