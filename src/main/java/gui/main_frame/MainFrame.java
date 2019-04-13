package gui.main_frame;

import backend.converter.Converter;
import backend.house.model.HouseSale;
import backend.sql.SQLQuery;
import gui.chart.Chart;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame {

    private GridBagConstraints gridBagConstraints = new GridBagConstraints();

    private Container container = getContentPane();

    private JTextField textArea = new JTextField("Input Postcode Here",20);

    private String[] columns = {"Street", "Locality", "Town", "District", "County", "Sale Date", "Price"};

    private Object[][] rows;

    private DefaultTableModel tableModel = new DefaultTableModel(rows, columns);

    private JTable table = new JTable(tableModel);

    private JScrollPane scrollPane = new JScrollPane(table);

    private JButton chartButton = new JButton("Chart");

    private String pathToDatabase;

    private List<HouseSale> listOfHouses = null;

    private Chart chart = new Chart("Test");

    public MainFrame(String title, String pathToDataBase) {
        super(title);
        this.pathToDatabase = pathToDataBase;
        setLayout(new GridBagLayout());

        container.setBackground(new Color(255,255,253));

        container.add(createChartButton(), gridBagConstraints);
        container.add(createTitle(), gridBagConstraints);
        container.add(createSearchButton(), gridBagConstraints);
        container.add(createUserInput(), gridBagConstraints);
        container.add(getTable(), gridBagConstraints);
    }

    private JLabel createTitle(){
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 1;
        JLabel title = new JLabel("<html><span><h1 style='color:#000033;font-size:20px;text-shadow:2px 2px #a6a6a6'>Please Enter A Postcode</h1></span></html>");
        return title;
    }

    private JButton createSearchButton(){
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.ipady = 3;
        JButton button = new JButton("Search");
        button.addActionListener(e -> {
            actionPerformed();
        });
        return button;
    }

    private JButton createChartButton(){
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        super.repaint();
        chartButton.addActionListener( e -> {
            showChart();
        });
        return chartButton;
    }

    private JTextField createUserInput(){
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        textArea.setMinimumSize(new Dimension(80, 30));
        textArea.setFont(new Font(Font.SERIF, 0, 20));
        textArea.addActionListener(e -> {
            actionPerformed();
        });
        return textArea;
    }

    private JScrollPane getTable(){
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 1;
        scrollPane.setPreferredSize(new Dimension(900,800));
        table.setPreferredSize(new Dimension(900,800));
        table.setAutoCreateRowSorter(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        return scrollPane;
    }

    private void actionPerformed(){
        tableModel.getDataVector().removeAllElements();
        String postcode = textArea.getText().toLowerCase();
        SQLQuery sqlQuery = new SQLQuery(pathToDatabase);
        listOfHouses = sqlQuery.queryDataBase(postcode);
        createChart();
        chart.setSaleList(listOfHouses);
        chart.createChart();
        addDataToTable(new Converter().convertToObjectArray(sqlQuery.queryDataBase(postcode)));
    }

    private void addDataToTable(Object[][] data){
        for(Object[] i : data){
            tableModel.addRow(i);
        }
        this.repaint();
    }

    private void showChart(){
        chart.setVisible(true);
    }

    public void createChart(){
        chart.setSize(new Dimension(800,800));
        chart.setResizable(false);
        chart.setLocationRelativeTo(null);
    }

}
