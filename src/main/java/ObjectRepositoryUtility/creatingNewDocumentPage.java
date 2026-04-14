package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class creatingNewDocumentPage {

	WebDriver driver;
	public creatingNewDocumentPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="notes_title")
	private WebElement DocumentTitleName;
	
	public void createDocumentDetails(String docName) {
		DocumentTitleName.sendKeys(docName);
	}
	
	@FindBy(name="button")
	private WebElement saveButton;
	
	public void saveClick() {
		saveButton.click();
	}
	
	
	public WebElement getSaveButton() {
		return saveButton;
	}


	public WebElement getDocumentTitleName() {
		return DocumentTitleName;
	}
}
