package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class creatingNewOpportunityPage {

	WebDriver driver;

	public creatingNewOpportunityPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title='Create Opportunity...']")
	private WebElement createNewOpportunities;

	

	@FindBy(name = "potentialname")
	private WebElement opportunitiesName;
	
	public void createOpportunitiesDetails(String oppName) {
		opportunitiesName.sendKeys(oppName);
	}

	@FindBy(xpath = "(//img[@title='Select'])[1]")
	private WebElement plusOppIcon;

	public void plusOppIconClick() {
		plusOppIcon.click();
	}

	@FindBy(name = "button")
	private WebElement saveButton;

	public WebElement getSaveButton() {
		return saveButton;
	}

	public void saveClick() {
		saveButton.click();
	}

	public WebElement getCreateNewOpportunities() {
		return createNewOpportunities;
	}

	public WebElement getOpportunitiesName() {
		return opportunitiesName;
	}

	public WebElement getPlusOppIcon() {
		return plusOppIcon;
	}

}
