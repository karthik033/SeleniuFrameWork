package WebFileUtility;

import java.io.File;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webDriverUtility {

	
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	
	public void explicitWait(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void fluentWait(WebDriver driver, WebElement element) {
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofSeconds(1));
		wait.withTimeout(Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public void toMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	
	public void toMinimize(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	
	public void switchToWindowUrl(WebDriver driver, String partialUrl) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains(partialUrl)) {
				break;
			}
		}
	}

	
	public void switchToWindowTitle(WebDriver driver, String partialTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String actTitle = driver.getCurrentUrl();
			if (actTitle.contains(partialTitle)) {
				break;
			}
		}
	}

	
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	
	public void switchToFrame(WebDriver driver, String nameId) {
		driver.switchTo().frame(nameId);
	}

	
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	
	public void switchToAlertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	
	public void switchToAlertDismiss(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	
	public void selectByVisibleText(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	
	public void selectByIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	
	public void selectByValue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	
	public void moveToElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}


	public void contextClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement traget) {
		Actions action = new Actions(driver);
		action.dragAndDrop(src, traget).perform();
	}
	
	
	public void clickAndHold(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.clickAndHold(element).perform();
	}
	
	
	public void scrollByAmount(WebDriver driver, int x,int y) {
		Actions action = new Actions(driver);
		action.scrollByAmount(x, y).perform();
	}
	
	
	public void scrollToElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.scrollToElement(element).perform();
	}
	
	
	public void takeScreeShot(WebDriver driver,String filePath) throws Throwable {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(filePath);
		FileHandler.copy(temp, dest);
	}
	
	
	public void toSwitchBackToFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	
	public void toSwitchWindow(WebDriver driver) {
	String parentId = driver.getWindowHandle();
	Set<String> allId = driver.getWindowHandles();
	allId.remove(parentId);
	for (String id : allId) {
		driver.switchTo().window(id);
	}
	}
	
	public void toSwitchBackToWindow(WebDriver driver, String parentId) {
		driver.switchTo().window(parentId);
	}

	
	public void javaScriptExecutor(WebDriver driver, WebElement element,String value) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(value,element);
	}
	
	
	public void getOptions(WebDriver driver, WebElement element) {
		WebElement display1= element;
		Select dropdown=new Select(display1);
		List<WebElement> value = dropdown.getOptions();
		for(WebElement display2:value) {
			System.out.println(display2.getText());
		}
	}
	  
	
	public void isMultiple(WebDriver driver, WebElement element) {
		WebElement sort= element;
		Select ref=new Select(sort);
		System.out.println(ref.isMultiple());
	}

}
