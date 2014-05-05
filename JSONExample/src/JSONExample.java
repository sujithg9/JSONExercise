import java.io.IOException;
import java.io.StringWriter;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
class JSONExample 
{
	public void JSONDecode() throws JSONException{
		 JSONParser parser=new JSONParser();
	      String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
	      try{
	         Object obj = parser.parse(s);
	         JSONArray array = (JSONArray)obj;
	         System.out.println("The 2nd element of array");
	         System.out.println(array.get(1));
	         System.out.println();

	         org.json.simple.JSONObject obj2 = (org.json.simple.JSONObject)array.get(1);
	         System.out.println("Field \"1\"");
	         System.out.println(obj2.get("1"));    

	         s = "{}";
	         obj = parser.parse(s);
	         System.out.println(obj);

	         s= "[5,]";
	         obj = parser.parse(s);
	         System.out.println(obj);

	         s= "[5,,2]";
	         obj = parser.parse(s);
	         System.out.println(obj);
	      }catch(ParseException pe){
	         System.out.println("position: " + pe.getPosition());
	         System.out.println(pe);
	      }
	   
		
	}
	
	@SuppressWarnings("unchecked")
	public void JSONObjectStream() throws IOException, JSONException{
		org.json.simple.JSONObject obj = new org.json.simple.JSONObject();
	      obj.put("name", "foo");
	      obj.put("num", new Integer(100));
	      obj.put("balance", new Double(1000.21));
	      obj.put("is_vip", new Boolean(true));

	      System.out.println(obj);
	      
	      StringWriter stringWriter=new StringWriter();
	      obj.writeJSONString(stringWriter);
	      
	      String jsontext=String.valueOf(obj);
	      System.out.println(jsontext);
	}
	
   public static void main(String[] args) throws Exception
   {
	 JSONGeoCoding jsonGeoCoding = new JSONGeoCoding();  
	 JSONFormatting formatting = new JSONFormatting();
	 JSONExample example=new  JSONExample();
	 String s="{\"balance\":1000.21,\"num\":100,\"is_vip\":true,\"name\":\"foo\"}";
	 String str = "{ \"number\": [3, 4, 5, 6] }";
	 JSONObject jsonObject=new JSONObject(s);
	 JSONObject jsonObject2=new JSONObject(str);
	 org.json.JSONArray array=jsonObject2.getJSONArray("number");
	 for(int i=0;i<array.length();i++){
		 System.out.println(array.get(i));
	 }
	 int balance=jsonObject.getInt("balance");
	 int num=jsonObject.getInt("num");
	 Boolean is_vip=jsonObject.getBoolean("is_vip");
	 String name=jsonObject.getString("name");
	 System.out.println(name+" "+num+" "+balance+" "+is_vip);
	 example.JSONDecode();
	 example.JSONObjectStream();
	 jsonGeoCoding.geocoding("France");
	 formatting.JSONFormat();
   }
}