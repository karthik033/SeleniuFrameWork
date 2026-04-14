package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class creatingNewOrganizationPage {

	WebDriver driver;
	public creatingNewOrganizationPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="accountname")
	private WebElement orgName;
	
	@FindBy(name="button")
	private WebElement saveButton;
	
	@FindBy(name="industry")
	private WebElement industryDropDrown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy(id="phone")
	private WebElement phone;
	
	
	

	public WebElement getPhone() {
		return phone;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getIndustryDropDrown() {
		return industryDropDrown;
	}

	public WebElement getAccounttypeDropDown() {
		return typeDropDown;
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void saveClick() {
		saveButton.click();
	}
	
	public void OganizationDetail(String OrgName) {
		orgName.sendKeys(OrgName);
	}
	
	public void OganizationWithPhoneDetail(String OrgName,String Phone) {
		orgName.sendKeys(OrgName);
		phone.sendKeys(Phone);
	}
	
	public void dropDown(String industry,String type) {
		Select s1=new Select(industryDropDrown);
		s1.selectByVisibleText(industry);
		Select s2=new Select(typeDropDown);
		s2.selectByVisibleText(type);
	}
	
	public void OganizationWithDropDownDetail(String OrgName,String industry,String type) {
		orgName.sendKeys(OrgName);
		dropDown(industry, type);
	}
	

}
