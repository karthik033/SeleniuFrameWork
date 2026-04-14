package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class invoicePage {

	WebDriver driver;
	public invoicePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@title='Create Invoice...']")
	private WebElement createNewInvoiceClick;
	
	public void NewInvoiceClick() {
		createNewInvoiceClick.click();
	}
	
	
	public WebElement getCreateNewInvoiceClick() {
		return createNewInvoiceClick;
	}
	
}
