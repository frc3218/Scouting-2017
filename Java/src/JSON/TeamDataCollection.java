package JSON;
import java.util.ArrayList;
import java.util.List;

public class TeamDataCollection extends ArrayList <MatchData>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
}