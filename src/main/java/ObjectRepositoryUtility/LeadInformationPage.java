package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInformationPage {

	WebDriver driver;
	public LeadInformationPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className="dvHeaderText")
	private WebElement leadsLastNameInformation;
	
	@FindBy(id="dtlview_Company")
	private WebElement leadsCompNameInformation;
	
	
	public WebElement getLeadsLastNameInformation() {
		return leadsLastNameInformation;
	}

	public WebElement getLeadsCompNameInformation() {
		return leadsCompNameInformation;
	}

	public String nameInfovalidations() {
		return leadsLastNameInformation.getText();
	}
	
	public String compInfovalidations() {
		return leadsCompNameInformation.getText();
	}
	
}
