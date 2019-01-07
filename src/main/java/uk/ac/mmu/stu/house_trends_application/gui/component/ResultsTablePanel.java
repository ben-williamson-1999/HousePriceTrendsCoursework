package uk.ac.mmu.stu.house_trends_application.gui.component;

import uk.ac.mmu.stu.house_trends_application.gui.SwingGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ResultsTablePanel extends JPanel {

    String[] columns = {"Street", "Locality", "Town", "District", "County", "Sale Date", "Price"};

    Object[][] rows;

    private JTable table = new JTable(new DefaultTableModel(rows, columns));

    private JScrollPane scrollPane = new JScrollPane(table);

    private SwingGUI gui;

    public ResultsTablePanel(SwingGUI gui) {
        this.gui = gui;

        add(getTable());

    }

    private JScrollPane getTable(){
        setLayout(new FlowLayout());
        setSize(400,300);
        scrollPane.setSize(400,275);
        return scrollPane;
    }

    public JScrollPane updateTable(String[][] data){

        gui.repaint();

        return null;
    }
}
