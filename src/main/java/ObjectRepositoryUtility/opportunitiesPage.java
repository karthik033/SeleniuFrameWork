package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class opportunitiesPage {

	WebDriver driver;
	public opportunitiesPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="(//a[text()='Opportunities'])[1]")
	private WebElement createOpportunities;
	
	public void createOpportunitiesClick() {
		createOpportunities.click();
	}
	
	public WebElement getCreateOpportunities() {
		return createOpportunities;
	}
	
	
}
