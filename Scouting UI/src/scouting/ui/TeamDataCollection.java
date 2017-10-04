package scouting.ui;
import java.util.ArrayList;
import java.util.List;

public class TeamDataCollection extends ArrayList <MatchData>
{
	public TeamDataCollection()
	{
		
	}
	
	public MatchData getMatch(int index)
	{
		return (MatchData)this.get(index);
	}
        public double getAverageMatchScore(){
		int counter = 0;
		double matchDataSum = 0;
		for(MatchData data : this){
			
			if(data != null){
				matchDataSum += data.getOverallScore();
				counter++;
			}
		}
		return matchDataSum / (counter > 0 ? counter : 1);
	}
        
        public double getAverageBoilerScore(){
		int counter = 0;
		double matchDataSum = 0;
		for(MatchData data : this){
			
			if(data != null){
				matchDataSum += data.getBoilerScore();
				counter++;
			}
		}
		return matchDataSum / (counter > 0 ? counter : 1);
	}
        
        public double getAverageGearsDelivered(){
		int counter = 0;
		double matchDataSum = 0;
		for(MatchData data : this){
			
			if(data != null){
				matchDataSum += data.getGearsDelivered();
				counter++;
			}
		}
		return matchDataSum / (counter > 0 ? counter : 1);
	}
        
        public double getAveragePenalties(){
		int counter = 0;
		double matchDataSum = 0;
		for(MatchData data : this){
			
			if(data != null){
				matchDataSum += data.getPenalties();
				counter++;
			}
		}
		return matchDataSum / (counter > 0 ? counter : 1);
	}
}

