package GenericFileUtility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONFileUtility {

	public String getDataFromJSONFile(String key) throws Throwable {
		
		FileReader fileR=new FileReader("D:\\Selenium Workspace\\SeleniumFrameWork\\configAppData\\commondata.Json");
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(fileR);
		JSONObject map = (JSONObject)obj;
		String data = (String)map.get(key);
		return data;
		
	}
}
