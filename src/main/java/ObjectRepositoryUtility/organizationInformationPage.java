package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class organizationInformationPage {

	WebDriver driver;
	public organizationInformationPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className="dvHeaderText")
	private WebElement headerInfo; 
	
	@FindBy(id="dtlview_Industry")
	private WebElement actIndustryName; 
	
	@FindBy(id="dtlview_Type")
	private WebElement actTypeName; 
	
	@FindBy(id="dtlview_Phone")
	private WebElement actPhone; 
	
	
	public WebElement getActPhone() {
		return actPhone;
	}

	public WebElement getActIndustryName() {
		return actIndustryName;
	}

	public WebElement getActTypeName() {
		return actTypeName;
	}

	public WebElement getHeaderInfo() {
		return headerInfo;
	}
	
	
	
	public String phoneInfovalidations() {
		return actPhone.getText();
	}
	
	public String orgHeaderInfovalidations() {
		return headerInfo.getText();
	}
	
	public String industryInfovalidations() {
		return actIndustryName.getText();
	}
	
	public String typeInfovalidations() {
		return actTypeName.getText();
	}
	
	
}
