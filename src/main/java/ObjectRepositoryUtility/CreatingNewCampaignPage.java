package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewCampaignPage {

	WebDriver driver;
	public CreatingNewCampaignPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="campaignname")
	private WebElement campaigNname;
	
	public void createCampaigNnameDetails(String campaignsName) {
		campaigNname.sendKeys(campaignsName);
	}
	
	@FindBy(name="button")
	private WebElement saveButton;
	
	public void saveClick() {
		saveButton.click();
	}
	
	@FindBy(id="jscal_field_closingdate")
	private WebElement expectedDate;
	
	public void expectedDate(String days) {
		expectedDate.clear();
		expectedDate.sendKeys(days);
	}
	

	public WebElement getExpectedDate() {
		return expectedDate;
	}


	public WebElement getSaveButton() {
		return saveButton;
	}


	public WebElement getCampaigNname() {
		return campaigNname;
	}
	
	

}
