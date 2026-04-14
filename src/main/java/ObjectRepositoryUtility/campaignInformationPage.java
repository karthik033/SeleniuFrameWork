package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class campaignInformationPage {

	WebDriver driver;
	public campaignInformationPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className="dvHeaderText")
	private WebElement campaignHeaderInfo;
	
	public String campaignHeaderInfoValidation() {
		return campaignHeaderInfo.getText();
	}
	
	@FindBy(xpath="(//td[@class='dvtCellInfo'])[8]")
	private WebElement campaignDateInfo;
	
	public String campaignDateInfoValidation() {
		return campaignDateInfo.getText();
	}
	
	
	public WebElement getCampaignHeaderInfo() {
		return campaignHeaderInfo;
	}
	

	public WebElement getCampaignDateInfo() {
		return campaignDateInfo;
	}

}
