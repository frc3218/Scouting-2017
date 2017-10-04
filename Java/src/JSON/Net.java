package JSON;
import java.nio.charset.StandardCharsets;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;

public class Net 
{
	public static String PostRequestOutput(String request, String args)
	{
		BufferedReader read = null;
		try
		{
			URL url = new URL(request);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			byte[] data = args.getBytes(StandardCharsets.UTF_8);
			int dataLength = data.length;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
			conn.setRequestProperty("charset", "utf-8");
			conn.setRequestProperty("Content-Length", Integer.toString(dataLength));
			conn.setUseCaches(false);

				DataOutputStream writer = new DataOutputStream(conn.getOutputStream());
				writer.write(data);
				
				String output;
				read = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				while((output = read.readLine()) != null)
				{	
					read.close();
					return output;
				}

				return output;
		}
		catch(Exception ex)
		{
			return ex.toString();
		}
	}
	
	public static void PostRequest(String request, String args)
	{
		try
		{
			URL url = new URL(request);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			byte[] data = args.getBytes(StandardCharsets.UTF_8);
			int dataLength = data.length;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
			conn.setRequestProperty("charset", "utf-8");
			conn.setRequestProperty("Content-Length", Integer.toString(dataLength));
			conn.setUseCaches(false);
			
			try
			{
				DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
				wr.write(data);
			}
			catch(Exception ex)
			{
				
			}
		}
		catch(Exception ex)
		{
			
		}
	}
}
