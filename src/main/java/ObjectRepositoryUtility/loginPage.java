package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WebFileUtility.webDriverUtility;

public class loginPage extends webDriverUtility {
	
	WebDriver driver;
	public loginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	
	@FindBy(name="user_name")
	private WebElement userName;
	
	@FindBy(name="user_password")
	private WebElement password;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;

	
	
	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	
	public void loginData(String url,String username,String passwordId) {
		implicitWait(driver);
		toMaximize(driver);
		driver.get(url);
		userName.sendKeys(username);
		password.sendKeys(passwordId);
		loginButton.click();
		
	}
	
	
}
