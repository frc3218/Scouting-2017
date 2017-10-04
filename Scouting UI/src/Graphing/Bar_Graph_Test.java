package Graphing;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import scouting.ui.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Bar_Graph_Test 
{
	public static void main(String[] args) 
	{
		
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		JsonParsing json = new JsonParsing(Net.PostRequestOutput("http://monixgameware.com/scout/core/sync/sync.php", "key=panth3r"));
		
                RoboticsHashMap teamList = new RoboticsHashMap();
                
                try
                {
                    teamList = json.getMasterList();
                }
                catch(Exception ex)
                {
                    MessageBox msg = new MessageBox();
                    msg.show(ex.getMessage(), "Error", null);
                }
		
		GraphComparator[] graphingArray = new GraphComparator[teamList.keySet().size()];
		
		int index = 0;
		
		for(String teamNumber : teamList.keySet()){
			graphingArray[index] = new GraphComparator(teamNumber, teamList.get(teamNumber).getAverageMatchScore());
			
			index++;
		}
		Arrays.sort(graphingArray);
		
		for(int i = 0; i < graphingArray.length; i++){
			dataset.setValue(graphingArray[i].getAverageVal(), "Score", graphingArray[i].getTeamNum());
		}
                
		JFreeChart chart = ChartFactory.createBarChart("Comparison between Overal Scores", "Teams", "Score", dataset, PlotOrientation.VERTICAL, false, true, false);

		try {
			ChartUtilities.saveChartAsJPEG(new File("H:\\Github\\chart2.jpg"), chart, 800, 450);
		} catch (IOException e) {
			System.err.println("Problem occurred creating chart.");
		}
		System.out.println("All Done");
	}
}