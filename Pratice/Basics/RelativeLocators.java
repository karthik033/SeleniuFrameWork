package Basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demowebshop.tricentis.com/");

		// Search Field Text Box
		driver.findElement(RelativeLocator.with(By.tagName("input")).toLeftOf(By.xpath("//input[@type='submit']")))
				.sendKeys("mobile");
		
		//Click on laptop
		driver.findElement(RelativeLocator.with(By.tagName("h2")).
				toRightOf(By.xpath("//a[text()='$25 Virtual Gift Card']"))).click();
		
		//click on desktop
		driver.findElement(RelativeLocator.with(By.tagName("a"))
				.above(By.xpath("//li[@class='active']"))).click();

		//below
		driver.findElement(RelativeLocator.with(By.tagName("a"))
				.below(By.xpath("(//span[text()='1000.00'])[1]"))).click();
		
		//near
		driver.findElement(RelativeLocator.with(By.xpath("//a[text()='Home']"))
				.near(By.xpath("//a[text()='Computers']"))).click();
		
		Thread.sleep(10000);

		driver.quit();
	}

}
