package Basics;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;


public class MyntraProject {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		

		driver.get("https://www.myntra.com/");

		Actions action = new Actions(driver);

		// MEN
		WebElement men = driver.findElement(By.xpath("//a[@data-group='men']"));
		action.moveToElement(men).perform();

		List<WebElement> allmen = driver.findElements(By.xpath("//div[@data-reactid='24']"));
		for (WebElement mens : allmen) {
			System.out.println("MEN:");
			System.out.println(mens.getText());
		}

		// WOMEN
		WebElement women = driver.findElement(By.xpath("(//a[text()='Women'])[1]"));
		action.moveToElement(women).perform();

		List<WebElement> allwomen = driver.findElements(By.xpath("//div[@data-reactid='183']"));
		for (WebElement womens : allwomen) {
			System.out.println("WOMEN:");
			System.out.println(womens.getText());
		}
		
		//KIDS
		WebElement kid = driver.findElement(By.xpath("(//a[text()='Kids'])[1]"));
		action.moveToElement(kid).perform();

		List<WebElement> allkid = driver.findElements(By.xpath("//div[@data-reactid='338']"));
		for (WebElement kids : allkid) {
			System.out.println("KID:");
			System.out.println(kids.getText());
		}
		
		//HOME
		WebElement home = driver.findElement(By.xpath("(//a[text()='Home'])[1]"));
		action.moveToElement(home).perform();

		List<WebElement> allhome = driver.findElements(By.xpath("//div[@data-reactid='502']"));
		for (WebElement homes : allhome) {
			System.out.println("HOME:");
			System.out.println(homes.getText());
		}
		
		//GENZ
		WebElement genz = driver.findElement(By.xpath("(//a[text()='Genz'])[1]"));
		action.moveToElement(genz).perform();

		List<WebElement> allgenz = driver.findElements(By.xpath("//div[@data-reactid='808']"));
		for (WebElement genzs : allgenz) {
			System.out.println("GENZ:");
			System.out.println(genzs.getText());
		}
		
		//STUDIO
		WebElement studio = driver.findElement(By.xpath("(//a[text()='Studio'])[1]"));
		action.moveToElement(studio).perform();
		Thread.sleep(2000);

	    TakesScreenshot ts=(TakesScreenshot)driver;
	    File temp = ts.getScreenshotAs(OutputType.FILE);
	    File dest = new File("./errorShots/Myntra.jpeg");
	    FileHandler.copy(temp, dest);

		driver.quit();
	}

}
