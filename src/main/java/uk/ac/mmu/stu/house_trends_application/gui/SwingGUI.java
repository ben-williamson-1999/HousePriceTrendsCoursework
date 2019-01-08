package uk.ac.mmu.stu.house_trends_application.gui;

import uk.ac.mmu.stu.house_trends_application.gui.component.DetailsPanel;
import uk.ac.mmu.stu.house_trends_application.gui.component.ResultsTablePanel;

import javax.swing.*;
import java.awt.*;

public class SwingGUI extends JFrame {

    public SwingGUI(String title) {
        super(title);

        Container container = getContentPane();

        setLayout(new FlowLayout());

        DetailsPanel detailsPanel = new DetailsPanel();

        ResultsTablePanel resultsTablePanel = new ResultsTablePanel(this);

        container.add(detailsPanel);

        container.add(resultsTablePanel);
    }
}
