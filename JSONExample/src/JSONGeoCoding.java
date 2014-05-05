import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import org.json.JSONObject;


public class JSONGeoCoding {
	public void geocoding(String addr) throws Exception
	{
	    // build a URL
	    String s = "http://maps.google.com/maps/api/geocode/json?" +
	                    "sensor=false&address=";
	    s += URLEncoder.encode(addr, "UTF-8");
	    URL url = new URL(s);
	 
	    // read from the URL
	    Scanner scan = new Scanner(url.openStream());
	    String string = new String();
	    while (scan.hasNext())
	        string += scan.nextLine();
	    scan.close();
	 
	    // build a JSON object
	    JSONObject jsonObject = new JSONObject(string);
	    if (! jsonObject.getString("status").equals("OK"))
	        return;
	 
	    // get the first result
	    JSONObject result = jsonObject.getJSONArray("results").getJSONObject(0);
	    System.out.println(result.getString("formatted_address"));
	    JSONObject loc =
	        result.getJSONObject("geometry").getJSONObject("location");
	    System.out.println("Latitude: " + loc.getDouble("lat") +
	                        ", Longitude: " + loc.getDouble("lng"));
	}
}
