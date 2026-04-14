package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productsPage {

		WebDriver driver;
		public productsPage(WebDriver driver){
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(xpath="//img[@title='Create Product...']")
		private WebElement createProducts;
		
		public void createProductsCLick() {
			createProducts.click();	
		}
		
		
		public WebElement getCreateProducts() {
			return createProducts;
		}
}
