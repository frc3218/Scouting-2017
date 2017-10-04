package JSON;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class RoboticsHashMap extends HashMap<String, TeamDataCollection>
{
	public RoboticsHashMap(JSONObject json)
	{
		Object[] keys = json.keySet().toArray();
		
		for(int i = 0; i < json.size(); i++) // foreach team
		{
			TeamDataCollection team = new TeamDataCollection();
			
			JSONArray matches = (JSONArray)json.get(keys[i]);
			
			if(keys[i] instanceof String)
			{
				for(int j = 0; j < matches.size(); j++)
				{
					team.add(new MatchData((JSONObject)matches.get(j), keys[i].toString()));
				}
			}
			
			this.put(keys[i].toString(), team);
		}
	}
	
	public MatchData getMatch(String teamNumber, int matchNumber)
	{
		return (MatchData)this.get(teamNumber).get(matchNumber);
	}
	
	public TeamDataCollection getTeam(String teamNumber)
	{
		return this.get(teamNumber);
	}
}
