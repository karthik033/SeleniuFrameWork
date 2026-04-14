package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewInvoicePage {

	WebDriver driver;

	public CreatingNewInvoicePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="accountname")
	private WebElement orgName;
	
	@FindBy(name = "subject")
	private WebElement enterSubjectName;
	
	@FindBy(xpath = "(//img[@title='Select'])[3]")
	private WebElement plusIcon;

	@FindBy(name = "bill_street")
	private WebElement enterBillingAddress;

	@FindBy(name = "ship_street")
	private WebElement enterShippingAddress;

	@FindBy(id = "searchIcon1")
	private WebElement iteamButtonClick;

	@FindBy(className = "detailedViewTextBoxOn")
	private WebElement enterQuantity;

	@FindBy(id = "listPrice1")
	private WebElement enterPrice;
	
	@FindBy(name = "button")
	private WebElement saveButton;


	public WebElement getOrgName() {
		return orgName;
	}
	
	public WebElement getEnterSubjectName() {
		return enterSubjectName;
	}
	
	public WebElement getPlusIcon() {
		return plusIcon;
	}

	public WebElement getEnterBillingAddress() {
		return enterBillingAddress;
	}

	public WebElement getEnterShippingAddress() {
		return enterShippingAddress;
	}

	public WebElement getIteamButtonClick() {
		return iteamButtonClick;
	}

	public WebElement getEnterQuantity() {
		return enterQuantity;
	}

	public WebElement getEnterPrice() {
		return enterPrice;
	}
	
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	
	public void oganizationName(String OrgName) {
		orgName.sendKeys(OrgName);
	}

	public void enterSubjectName(String subjectName) {
		enterSubjectName.sendKeys(subjectName);
	}
	
	public void plusIconClick() {
		plusIcon.click();
	}
	
	public void enterBillingAddress(String billingAddress) {
		enterBillingAddress.sendKeys(billingAddress);
	}
	
	public void enterShippingAddress(String shippingAddress) {
		enterShippingAddress.sendKeys(shippingAddress); 
	}
	
	 public void iteamButtonClick() {
		 iteamButtonClick.click();
	 }
	
	public void enterQuantity(String quantity) {
		enterQuantity.sendKeys(quantity);
	}
	
	public void enterPrice(String price) {
		enterPrice.sendKeys(price);
	}
	
	public void saveClick() {
		saveButton.click();
	}
}
