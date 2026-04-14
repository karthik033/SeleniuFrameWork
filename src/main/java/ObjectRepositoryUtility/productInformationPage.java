package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productInformationPage {

		WebDriver driver;
		public productInformationPage(WebDriver driver){
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(className="lvtHeaderText")
		private WebElement productHeaderInfo;
		
		public String proHeaderInfovalidations() {
			return productHeaderInfo.getText();
		}
		
		
		public WebElement getProductHeaderInfo() {
			return productHeaderInfo;
		}
}
