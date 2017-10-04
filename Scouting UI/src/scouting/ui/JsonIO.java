package scouting.ui;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.*;
import javax.swing.JOptionPane;

public class JsonIO 
{
	public static String getJsonFromFile(String file) throws Exception
	{
		try
		{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			return buffer.readLine();
		}
		catch(Exception ex)
		{
//                        MessageBox box = new MessageBox();
//			box.show("Unable to open JSON file.", "Error", null);
			throw ex;
		}
	}
	public void saveJsonFile(String file)
	{
		
	}
        
        public static void createEmptyJsonFile(String file)
        {
            try
            {
                PrintWriter pw = new PrintWriter(file, "UTF-8");
                pw.write("{ }");
                pw.close();
            }
            catch(Exception ex)
            {
                
            }
        }
        
        public static boolean listFileExists(String file)
        {
            File localFile = new File(file);
            return localFile.exists();
        }
        
        public static void writeJsonFile(String file, String json)
        {
            try
            {
                PrintWriter pw = new PrintWriter(file, "UTF-8");
                pw.write(json);
                pw.close();
            }
            catch(Exception ex)
            {
                
            }
        }
}
