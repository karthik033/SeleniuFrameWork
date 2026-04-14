package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactInformationPage {

	WebDriver driver;
	public contactInformationPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className="dvHeaderText")
	private WebElement headerInfo;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement startDateInfo;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement endDateInfo;
	
	@FindBy(id="dtlview_Last Name")
	private WebElement lastNameInfo;
	
	
	
	public WebElement getLastNameInfo() {
		return lastNameInfo;
	}

	public WebElement getStartDateInfo() {
		return startDateInfo;
	}

	public WebElement getEndDateInfo() {
		return endDateInfo;
	}

	public WebElement getHeaderInfo() {
		return headerInfo;
	}
	
	public String contHeaderInfovalidations() {
		return headerInfo.getText();
	}
	
	public String startDateInfovalidations() {
	return	startDateInfo.getText();
		
	}
	
	public String endDateInfovalidations() {
		return	endDateInfo.getText();
	}
	

}
