package JSON;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class JsonParsing
{
	
	private JSONParser parser = new JSONParser();
	private JSONArray list;
	private String teamNumber;
	private static RoboticsHashMap teamList;
	
	public JsonParsing(String json)
	{
		try
		{
			list = (JSONArray)parser.parse(json);
			loadTeamList();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void loadTeamList()
	{
		JSONObject teams = (JSONObject)list.get(0);
		teamList = new RoboticsHashMap(teams);
	}

	public RoboticsHashMap getMasterList()
	{
		if(list == null || list.size() == 0)
		{
			MessageBox.show("Master list is null or empty.", "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
		return teamList;
	}
	
	public static TeamDataCollection getTeam(String number)
	{
		return teamList.get(number);
	}
	
	public static void main(String[] main)
	{
		//JsonParsing x = new JsonParsing(Net.PostRequestOutput("http://monixgameware.com/scout/core/sync/sync.php", "key=panth3r"));
		//x.loadMasterList();

		/*for(Map.Entry<String, TeamDataCollection> entry : teamList.entrySet())
		{
			TeamDataCollection team = entry.getValue();
			
			for(int i = 0; i < team.size(); i++)
			{
				MatchData match = (MatchData) team.get(i);
				System.out.println(match.getPenalties());
				//System.out.println((MatchData)team.get(i));
			}
		}*/
		
		/*TeamDataCollection team = getTeam("3218");
		
		for(int i = 0; i < team.size(); i++)
		{
			MatchData match = team.getMatch(i);
			System.out.println(match.getMatchNumber());
		}*/
		
		//JsonParsing json = new JsonParsing(Net.PostRequestOutput("http://monixgameware.com/scout/core/sync/sync.php", "key=panth3r"));
		//json.loadMasterList();
	}
	
	
}

