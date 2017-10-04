package TestingJFreeChart;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class HI {
	public static void main(String[] args) {
		int a = 123;
		XYSeriesCollection dataset = new XYSeriesCollection();
		
		while(12 > a){
			XYSeries series = new XYSeries("I am trapped");
			series.add(0, 5);
			series.add(1, 13);
			series.add(2, 28);
			series.add(3, 75);
			series.add(4, 100);
			dataset.addSeries(series);
		}
		
		
		JFreeChart chart = ChartFactory.createXYLineChart("Hi Everyone, I am trapped in a computer", "x-axis", "y-axis", dataset, PlotOrientation.VERTICAL, true, true, false );
		
		try {
			ChartUtilities.saveChartAsJPEG(new File("H:\\Github\\chart.jpg"), chart, 1000, 1000);
		} catch (IOException e) {
			System.err.println("Problem occurred creating chart.");
			System.err.println(e);
		}
	}
}