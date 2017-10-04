package scouting.ui;
import java.io.*;
public class JsonWriting 
{
    public static void writeJsonToFile(RoboticsHashMap map, String file)
    {
        String json = "[{";
        
        int team = 1;
        for(String keyNumber : map.keySet())
        {
            json += "\"" + keyNumber + "\"" + ":[";
            
            int inc = 1;
            for(MatchData match : map.get(keyNumber))
            {
                Object[] specialArray = match.getSpecialty();
                String specialty = "[";
                
                try
                {
                    Object x = specialArray[0].getClass();
                }
                catch(Exception ex)
                {
                    specialty += "null]";
                }
                
                for(int i = 0; i <= specialArray.length - 1; i++)
                {
                    if(specialArray[i] != null)
                    {
                        if(i == specialArray.length - 1)
                        {
                            specialty += "\"" + specialArray[i] + "\"]";
                        }
                        else
                        {
                            specialty += "\"" + specialArray[i] + "\",";
                        }
                    }
                }
                
                json += "{" + "\"teamName\":\"" + match.getTeamName() + "\",\"shotAccuracy\": " + "\"" + match.getShotAccuracy() + "\", \"atonomous\":\"" + match.getAutonomous() + "\", \"result\":\"" + match.getResult() + "\",\"climbed\":\"" + match.getClimbed() + "\"" + "," + "\"overallScore\":" + "\"" + match.getOverallScore() +  "\"" + ", \"boilerScore\":" + "\"" + match.getBoilerScore()+ "\"" + ", \"gearsDelivered\":" + "\"" + match.getGearsDelivered() + "\", \"penalties\": \"" + match.getPenalties() + "\", \"strategy\":\"" + match.getStrategy() + "\", \"specialty\":" + specialty + ", \"matchNumber\":" + match.getMatchNumber() + ", \"hash\":" + match.getHash() + "}";
                
                if(!(inc++ == map.get(keyNumber).size()))
                {
                    json += ",";
                }
                else
                {
                    json += "]";
                }
            }
            
            if(team++ == map.keySet().size())
            {
                json += "}]";
            }
            else
            {
                json += ",";
            }
        }
        
        JsonIO.writeJsonFile(file, json);
        
    }
    
    /*public static void main(String[] args)
    {
        JsonParsing x = new JsonParsing(Net.PostRequestOutput("http://monixgameware.com/scout/core/sync/sync.php", "key=panth3r"));
        
        RoboticsHashMap hash = new RoboticsHashMap();
        
        try
        {
            hash = x.getMasterList();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        writeJsonToFile(hash, "H:\\H:Scouting\\masterlist.json");
        
        //System.out.println("{" + "\"shotAccuracy\": " + "\"" + "low" + "\"" + ",\"climbed\":\"" + "false" + "\"" + "," + "\"overallScore\":" + "\"" + "30" +  "\"" + ", \"topScore\":" + "\"" + "23" + "\", " + "\"bottomScore\":" + "\"" + "12" + "\"" + ", \"gearsDelivered\":" + "\"" + "2" + "\", \"penalties\": \"" + "2" + "\", \"strategy\":\"" + "hello" + "\", \"specialty\":" + "[null]" + ", \"matchNumber\":\"" + "1" + "\", \"hash\":\"" + "3432" + "\"}");
    }*/
}