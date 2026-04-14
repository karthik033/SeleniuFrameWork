package GenericFileUtility;

import java.io.FileInputStream;
import java.util.Properties;


public class CommonFileUtility {

	public String getDataFromPropertiesFile(String key) throws Throwable {
		
		FileInputStream fis=new FileInputStream("D:\\Selenium Workspace\\SeleniumFrameWork\\configAppData\\commondata.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String data = pro.getProperty(key);
		return data;
	}
}
