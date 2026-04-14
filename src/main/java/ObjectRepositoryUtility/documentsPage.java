package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class documentsPage {

	WebDriver driver;
	public documentsPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@title='Create Document...']")
	private WebElement createDocument;
	
	public void createDocumentClick() {
		createDocument.click();
	}
	
	
	public WebElement getCreateDocument() {
		return createDocument;
	}
}
