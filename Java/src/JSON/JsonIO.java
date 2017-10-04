package JSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.*;
import javax.swing.JOptionPane;

public class JsonIO 
{
	public String getJsonFromFile(String file)
	{
		try
		{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			return buffer.readLine();
			
		}
		catch(Exception ex)
		{
			MessageBox.show("Unable to open JSON file.", "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	
	public void saveJsonFile(String file)
	{
		
	}
}
