package uk.ac.mmu.stu.house_trends_application.gui.component;

import uk.ac.mmu.stu.house_trends_application.backend.sql.SQLQuery;

import javax.swing.*;
import java.awt.*;

public class DetailsPanel extends JPanel {

    private GridBagConstraints gridBagConstraints = new GridBagConstraints();

    private JTextArea textArea;

    public DetailsPanel(){

        setLayout(new GridBagLayout());
        setSize(400,300);
        JLabel inputPrompt = new JLabel("<html><span><h1 style='color:blue'>TEST</h1></span></html>");
        //JTextArea userInput = new JTextArea(1,20);
        //JButton searchButton = new JButton("Search");
        //JButton chartButton = new JButton("Show Chart");
        //JButton settingsButton = new JButton("Settings");

        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;

        // First Column

        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;
        add(createUserInput(), gridBagConstraints);

        add(createSearchButton(), gridBagConstraints);

        //gridBagConstraints.gridy = 3;
        //add(settingsButton, gridBagConstraints);

        //Second Column
        //gridBagConstraints.gridx = 1;
        //gridBagConstraints.gridy = 2;
        //add(chartButton, gridBagConstraints);
    }

    public JButton createSearchButton(){
        gridBagConstraints.gridwidth = 0;
        gridBagConstraints.gridy = 2;
        JButton button = new JButton("Search");
        button.addActionListener(e -> {
            String postcode = textArea.getText();
            SQLQuery sqlQuery = new SQLQuery();
            sqlQuery.queryDataBase(postcode);

        });
        return button;
    }

    public JTextArea createUserInput(){
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        textArea = new JTextArea("Enter Postcode Here",1 ,3);
        textArea.setMinimumSize(new Dimension(10, 10));
        return textArea;
    }
}
