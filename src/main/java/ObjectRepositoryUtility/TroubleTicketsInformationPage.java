package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTicketsInformationPage {

	WebDriver driver;
	public TroubleTicketsInformationPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className="dvHeaderText")
	private WebElement titleHeaderInfo;
	
	public String troubleTicketInfovalidations() {
		return titleHeaderInfo.getText();
	}
	public WebElement getTitleHeaderInfo() {
		return titleHeaderInfo;
	}

}
