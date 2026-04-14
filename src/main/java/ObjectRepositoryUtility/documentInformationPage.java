package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class documentInformationPage {

	WebDriver driver;
	public documentInformationPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className="dvHeaderText")
	private WebElement documentHeaderInfo;
	
	
	public WebElement getDocumentHeaderInfo() {
		return documentHeaderInfo;
	}
}
