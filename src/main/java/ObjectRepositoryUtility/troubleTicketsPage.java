package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class troubleTicketsPage {

	WebDriver driver;
	public troubleTicketsPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@title='Create Ticket...']")
	private WebElement createTroubleTickets;
	
	public void createTroubleTicketClick() {
		createTroubleTickets.click();
	}
	
	
	public WebElement getCreateTroubleTickets() {
		return createTroubleTickets;
	}
	

}
//