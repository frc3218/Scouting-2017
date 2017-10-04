package scouting.ui;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.*;

public class MatchData 
{
    //Properties Declaration Here:
    public static final String AVG_SCORE = "Average Score";
    public static final String GEARS_DELIV = "Gears Delivered";
    public static final String BOILER_SCORE = "Boiler Score";
    public static final String PENALTIES = "Penalties";
    
    private String teamNumber;//0
    private String shotAccuracy;//1
    private String atonomous;
    private String result;
    private boolean climbed;//2
    private int boilerScore;//4
    private int gearsDelivered;//5
    private int penalties;//6
    private Object[] specialty;//7
    private int matchNumber;//8
    private String strategy;//9
    private int overallScore;//10
    private String hash;
    private String teamName;//12
    public static String[] comboBoxOption = new String[]{AVG_SCORE,GEARS_DELIV,BOILER_SCORE,PENALTIES};
    public static int numProperties = 12;
    public MatchData()
    {
        
    }
    
    public MatchData(JSONObject json, String _teamNumber)
    {
    	setTeamNumber(_teamNumber);
    	
    	parseJSON(json);
    }
    
    private void parseJSON(JSONObject json)
    {
		Object[] keys = json.keySet().toArray();
                setTeamName(json.get("teamName").toString());
		setShotAccuracy(json.get("shotAccuracy").toString());
                setAtonomous(json.get("atonomous").toString());
                setResult(json.get("result").toString());
		setClimbed(Boolean.parseBoolean(json.get("climbed").toString()));
		setOverallScore(Integer.parseInt(json.get("overallScore").toString()));
                setBoilerScore(Integer.parseInt(json.get("boilerScore").toString()));
		setGearsDelivered(Integer.parseInt(json.get("gearsDelivered").toString()));
		setPenalties(Integer.parseInt(json.get("penalties").toString()));
		setMatchNumber(Integer.parseInt(json.get("matchNumber").toString()));
		JSONArray x = (JSONArray)(json.get("specialty"));
		setSpecialty(x.toArray());

		setStrategy(json.get("strategy").toString());
                hash = json.get("hash").toString();
    }

    /*@Override
 	public String toString()
    {
 		return "Team Number: " + teamNumber + ", Shot Accuracy: " + shotAccuracy +  ", Climbed: " + climbed + ", Top Score: " + topBoilerScore +  ", Bottom Score: " + bottomBoilerScore;
 	}*/
    public void setAtonomous(String value)
    {
        atonomous = value;
    }
    
    public String getAutonomous()
    {
        return atonomous;
    }
    
    public void setResult(String value)
    {
        result = value;
    }
    
    public String getResult()
    {
        return result;
    }
    
    public void setTeamName(String value)
    {
        teamName = value;
    }
    
    public String getTeamName()
    {
        return teamName;
    }
    
    public void setHash()
    {
        //hash = Generator.generateMatchHash(this);
    }
    
    public String getHash()
    {
        return hash;
    }
    
    public void setTeamNumber(String value)
    {
        teamNumber = value;
    }
    
    public String getTeamNumber()
    {
        return teamNumber;
    }
    
    public void setShotAccuracy(String value)
    {
        shotAccuracy = value;
    }
    
    public String getShotAccuracy()
    {
        return shotAccuracy;
    }
    
    public void setClimbed(boolean value)
    {
        climbed = value;
    }
    
    public boolean getClimbed()
    {
        return climbed;
    }
    
    public void setGearsDelivered(int value)
    {
        gearsDelivered = value;
    }
    
    public int getGearsDelivered()
    {
        return gearsDelivered;
    }
    public void setPenalties(int value)
    {
        penalties = value;
    }
    
    public int getPenalties()
    {
        return penalties;
    }
    
    public void setSpecialty(Object[] value)
    {
        specialty = value;
    }
    
    public Object[] getSpecialty()
    {
        return specialty;
    }
    
    public void setStrategy(String value)
    {
        strategy = value;
    }
    
    public String getStrategy()
    {
        return strategy;
    }
    
    public void setMatchNumber(int value)
    {
        matchNumber = value;
    }
    
    public int getMatchNumber()
    {
        return matchNumber;
    }
    
    public void setOverallScore(int score)
    {
        overallScore = score;
    }
    public int getOverallScore()
    {
        return overallScore;
    }
    public boolean containsSpecialty(String key)
    {     
        List<Object> list = Arrays.asList(specialty);
        
        return(list.contains(key));
    }
    public void setBoilerScore(int score)
    {
        boilerScore = score;
    }
    public int getBoilerScore()
    {
        return boilerScore;
    }
    
    public String[] getRowOutput()
    {
        return new String[]{teamNumber,Integer.toString(matchNumber),teamName,Integer.toString(overallScore), shotAccuracy, Boolean.toString(climbed), Integer.toString(gearsDelivered), Integer.toString(penalties), Arrays.toString(specialty), strategy};
    }
    
    
}
