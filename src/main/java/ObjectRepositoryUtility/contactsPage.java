package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactsPage {

	WebDriver driver;
	public contactsPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContact;
	
	
	public WebElement getCreateContact() {
		return createContact;
	}

	public void createContactClick() {
		createContact.click();
	}
}
