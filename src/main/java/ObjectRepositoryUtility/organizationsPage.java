package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class organizationsPage {

	WebDriver driver;
	public organizationsPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrganization;
	
	public void createOrganizationCLick() {
		createOrganization.click();
	}

	public WebElement getCreateOrganization() {
		return createOrganization;
	}
	
	
}
