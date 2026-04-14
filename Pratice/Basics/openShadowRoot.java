package Basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class openShadowRoot {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		
		driver.findElement(By.xpath("//section[text()='Shadow Root Elements']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//section[text()='Shadow Root']")).click();
		Thread.sleep(2000);
		
		//shadow host ->identify shadow host
		SearchContext username = driver.findElement(By.xpath("//form/div[1]")).getShadowRoot();
		username.findElement(By.cssSelector("input[type='text']")).sendKeys("karthik");
		
		//shadow host for password
		SearchContext password = driver.findElement(By.xpath("//form/div[2]")).getShadowRoot();
		password.findElement(By.cssSelector("input[type='text']")).sendKeys("karthik123");
		Thread.sleep(2000);
		
		driver.quit();
		
	}

}
