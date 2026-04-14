package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class childWindow {

	WebDriver driver;

	public childWindow(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "search_txt")
	private WebElement searchField;

	@FindBy(name = "search")
	private WebElement searchName;

	public WebElement getSearchField() {
		return searchField;
	}

	public void searchField(String orgName) {
		searchField.sendKeys(orgName);
	}

	public WebElement getSearchName() {
		return searchName;
	}
	
	public void searchNameClick() {
		searchName.click();
	}
	

	/*
	 * public void window() throws Throwable { ExcelFileUtility elib=new
	 * ExcelFileUtility(); String orgName = elib.getDataFromExcel("Contact", 7, 3);
	 * driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click(); }
	 */
}
