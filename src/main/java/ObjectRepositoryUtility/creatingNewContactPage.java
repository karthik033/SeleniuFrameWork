package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class creatingNewContactPage {

	WebDriver driver;
	public creatingNewContactPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastName;
	
	@FindBy(name="button")
	private WebElement saveButton;
	
	@FindBy(name="support_start_date")
	private WebElement supportStartDate;
	
	@FindBy(xpath="//input[@name='support_end_date']")
	private WebElement supportEndDate;
	
	@FindBy(xpath="(//img[@title='Select'])[1]")
	private WebElement plusIcon;
	
	
	
	public WebElement getPlusIcon() {
		return plusIcon;
	}
	
	public void plusClick() {
		plusIcon.click();	
	}

	public WebElement getSupportStartDate() {
		return supportStartDate;
	}

	public WebElement getSupportEndDate() {
		return supportEndDate;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getLastName() {
		return lastName;
	}

	
	public void createContactDetails(String LastName) {
		lastName.sendKeys(LastName);
	}
	
	public void startDateAndEndDate(String startDate,String endDate) {
		supportStartDate.clear();
		supportStartDate.sendKeys(startDate);
		supportEndDate.clear();
		supportEndDate.sendKeys(endDate);
	}
	
	public void saveClick() {
		saveButton.click();
	}
}
