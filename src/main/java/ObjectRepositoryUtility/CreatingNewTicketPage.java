package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewTicketPage {

	WebDriver driver;
	public CreatingNewTicketPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="ticket_title")
	private WebElement titleName;
	
	public void createTroubleTicketDetils(String titName) {
		titleName.sendKeys(titName);
	}
	
	@FindBy(name="button")
	private WebElement saveButton;
	
	public void saveClick() {
		saveButton.click();
	}
	
	
	public WebElement getSaveButton() {
		return saveButton;
	}


	public WebElement getTitleName() {
		return titleName;
	}

}
