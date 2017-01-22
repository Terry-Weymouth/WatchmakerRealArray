package jfreechart.demo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

public class XYLineChartExample extends ApplicationFrame {
	private static final long serialVersionUID = 2198795747128306202L;

	public XYLineChartExample() {
        super("XY Line Chart Example with JFreechart");
 
        JPanel chartPanel = setup();
        setContentPane(chartPanel);
 
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
	 	 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new XYLineChartExample().setVisible(true);
            }
        });
    }
	
	public JPanel setup() {
		JFreeChart chart = ChartFactory.createXYLineChart(
	            "Function2DDemo1 ",       // chart title
	            "X",                      // x axis label
	            "Y",                      // y axis label
	            null,	                  // data
	            PlotOrientation.VERTICAL,  
	            true,                     // include legend
	            true,                     // tooltips
	            false                     // urls
	        );

		XYPlot plot = (XYPlot) chart.getPlot();	
		/* SETUP SCATTER */
	
		// Create the scatter data, renderer, and axis
		XYDataset collection1 = getScatterPlotData();
		XYItemRenderer renderer1 = new XYLineAndShapeRenderer(false, true);
		ValueAxis domain1 = new NumberAxis("Domain1");
		ValueAxis range1 = new NumberAxis("Range1");
	
		// Set the scatter data, renderer, and axis into plot
		plot.setDataset(0, collection1);
		plot.setRenderer(0, renderer1);
		plot.setDomainAxis(0, domain1);
		plot.setRangeAxis(0, range1);
	
		// Map the scatter to the first Domain and first Range
		plot.mapDatasetToDomainAxis(0, 0);
		plot.mapDatasetToRangeAxis(0, 0);
	
		/* SETUP LINE */
	
		// Create the line data, renderer, and axis
		XYDataset collection2 = getLinePlotData();
		XYItemRenderer renderer2 = new XYLineAndShapeRenderer(true, false);   // Lines only
		ValueAxis domain2 = new NumberAxis("Domain2");
		ValueAxis range2 = new NumberAxis("Range2");
	
		// Set the line data, renderer, and axis into plot
		plot.setDataset(1, collection2);
		plot.setRenderer(1, renderer2);
		plot.setDomainAxis(1, domain2);
		plot.setRangeAxis(1, range2);
	
		// Map the line to the second Domain and second Range
		plot.mapDatasetToDomainAxis(1, 1);
		plot.mapDatasetToRangeAxis(1, 1);
	
        return new ChartPanel(chart);
		}
	
	private XYDataset getScatterPlotData() {
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series = new XYSeries("Datq Points");
		series.add(1.0, 2.0);
	    series.add(2.0, 3.0);
	    series.add(3.0, 2.5);
	    series.add(3.5, 2.8);
	    series.add(4.2, 6.0);	 
		dataset.addSeries(series);
		return dataset;
	}

	private XYDataset getLinePlotData() {
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series = new XYSeries("Curve");
	    series.add(2.0, 1.0);
	    series.add(2.5, 2.4);
	    series.add(3.2, 1.2);
	    series.add(3.9, 2.8);
	    series.add(4.6, 3.0);
		dataset.addSeries(series);
		return dataset;
	}
}
