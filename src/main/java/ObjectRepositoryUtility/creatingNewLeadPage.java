package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class creatingNewLeadPage {


	WebDriver driver;
	public creatingNewLeadPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="lastname")
	private WebElement leadsLastName;
	
	@FindBy(name="company")
	private WebElement leadscompName;
	
	@FindBy(name="button")
	private WebElement saveButton;
	
	public void saveClick() {
		saveButton.click();
	}
	
	
	public WebElement getLeadsLastName() {
		return leadsLastName;
	}

	public WebElement getLeadscompName() {
		return leadscompName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void createLeadsDetails(String lastName,String compName) {
		leadsLastName.sendKeys(lastName);
		leadscompName.sendKeys(compName);
	}
	
	
}
