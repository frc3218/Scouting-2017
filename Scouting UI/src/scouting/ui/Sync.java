package scouting.ui;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Sync 
{
    public static RoboticsHashMap sync(RoboticsHashMap source, RoboticsHashMap merge)
    {
        RoboticsHashMap synced = new RoboticsHashMap();

        for(String teamNumber : source.keySet()) // foreach team
        {
            if(!synced.containsKey(teamNumber))
            {
                // add key and values
                TeamDataCollection team = source.getTeam(teamNumber);
                synced.put(teamNumber, team);
            }
            else
            {
                TeamDataCollection team = source.get(teamNumber);
                // loop through and add non-duplicate values
                for(int i = 0; i < team.size(); i++)
                {
                    if(!(synced.get(teamNumber).contains(team.getMatch(i)))) /*== team.getMatch(i).getMatchNumber()*/
                    {
                        // insert value
                        synced.get(teamNumber).add(team.getMatch(i));
                    }
                }
            }
        }
        
        for(String teamNumber : merge.keySet()) // foreach team
        {
            if(!synced.containsKey(teamNumber))
            {
                // add key and values
                TeamDataCollection team = merge.getTeam(teamNumber);
                synced.put(teamNumber, team);
            }
            else
            {
                TeamDataCollection team = merge.get(teamNumber);
                // loop through and add non-duplicate values
                for(int i = 0; i < team.size(); i++)
                {
                    if(!(synced.get(teamNumber).contains(team.getMatch(i)))) /*== team.getMatch(i).getMatchNumber()*/
                    {
                        // insert value
                        synced.get(teamNumber).add(team.getMatch(i));
                    }
                }
            }
        }
        
        return synced;
    }
}
