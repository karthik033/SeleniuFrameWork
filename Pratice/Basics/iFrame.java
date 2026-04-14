package Basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class iFrame {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		driver.get("https://demoapps.qspiders.com/ui/frames/nestedWithMultiple?sublist=3");
		
		//to handle frame using index
	//	driver.switchTo().frame(0);
		
		//to handle frame using id or name
	//	driver.switchTo().frame("send-sms-iframe");
		
		//to handle frame using webElement
		WebElement iframe = driver.findElement(By.xpath("(//iframe[@class='w-full h-96'])[1]"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.id("email")).sendKeys("karthik@gmail.com");
		Thread.sleep(3000);
		
		driver.quit();
	}

}
