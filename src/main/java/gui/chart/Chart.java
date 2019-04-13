package gui.chart;

import backend.house.model.HouseSale;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Chart extends JFrame {

    private List<HouseSale> saleList;

    private XYDataset dataSet = null;

    private JFreeChart freeChart;

    private Container container = getContentPane();

    public Chart(String title){
        super(title);
    }

    public void createChart(){
        dataSet = addData();
        freeChart = getMeta();
        ChartPanel panel = new ChartPanel(freeChart);
        container.add(panel);
    }

    public void setSaleList(List<HouseSale> saleList) {
        this.saleList = saleList;
    }

    private JFreeChart getMeta(){
        freeChart = ChartFactory.createScatterPlot("House Trends Through The Year", "Years", "Price", dataSet);
        return freeChart;
    }

    private XYDataset addData(){
        XYSeriesCollection dataSet = new XYSeriesCollection();

        XYSeries series = new XYSeries("Houses");
        //XYSeries series = new XYSeries("Houses");
        for(HouseSale sale : saleList){
            //series.add(Integer.parseInt(sale.getSaleDate().substring(0,4)), sale.getPrice());
            series.addOrUpdate(Integer.parseInt(sale.getSaleDate().substring(0,4)), sale.getPrice());
        }
        dataSet.addSeries(series);
        return dataSet;
    }

}
