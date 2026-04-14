package Basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class closeShadowRoot {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		
		driver.findElement(By.xpath("//section[text()='Shadow Root Elements']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//section[text()='Shadow Root']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Close Shadow Root']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//h1[text()='Login']")).click();
		Thread.sleep(1000);
		
		Actions action=new Actions(driver);
		action.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);
		action.sendKeys("karthik").perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);
		action.sendKeys("karthik123").perform();
		
		
		Thread.sleep(2000);
		
		driver.quit();
		
	}

}
