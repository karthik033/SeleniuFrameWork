package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class creatingNewProductPage {

		WebDriver driver;
		public creatingNewProductPage(WebDriver driver){
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(name="productname")
		private WebElement productName;
		
		public void createProductDetails(String proName) {
			productName.sendKeys(proName);
		}
		
		@FindBy(name="button")
		private WebElement saveButton;
		
		public void saveClick() {
			saveButton.click();
		}
		
		
		public WebElement getSaveButton() {
			return saveButton;
		}

		public WebElement getProductName() {
			return productName;
		}
}
