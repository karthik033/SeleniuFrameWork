package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class leadPage {
	
	WebDriver driver;
	public leadPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@title='Create Lead...']")
	private WebElement createLeads;
	
	public void createLeadsClick() {
		createLeads.click();
	}
	
	public WebElement getCreateLeads() {
		return createLeads;
	}


}
