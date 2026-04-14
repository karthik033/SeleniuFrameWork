package Basics;

import org.openqa.selenium.chrome.ChromeDriver;

public class ToLaunchChromeBrowser {

	public static void main(String[] args) {
		//Launch Chrome Browser
		
		ChromeDriver driver=new  ChromeDriver();//Launch empty browser //start server

		driver.quit();
	}

}
