package contact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericFileUtility.CommonFileUtility;
import GenericFileUtility.ExcelFileUtility;
import ObjectRepositoryUtility.contactInformationPage;
import ObjectRepositoryUtility.contactsPage;
import ObjectRepositoryUtility.creatingNewContactPage;
import ObjectRepositoryUtility.homePage;
import ObjectRepositoryUtility.loginPage;
import WebFileUtility.JavaUtility;

public class CreateContactTest {

	public static void main(String[] args) throws Throwable {
		
		CommonFileUtility flib=new CommonFileUtility();
		ExcelFileUtility elib=new ExcelFileUtility();
		JavaUtility jlib=new JavaUtility();
		
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD =flib.getDataFromPropertiesFile("password");

		String LastName = elib.getDataFromExcel("Contact",1,2).toString() + jlib.getRandomNumber();
		
		WebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}else {
			driver = new ChromeDriver();
		}
		
		loginPage lp=new loginPage(driver);
		lp.loginData(URL, USERNAME, PASSWORD);

		homePage hp=new homePage(driver);
		hp.contactClick();
		contactsPage cp=new contactsPage(driver);
		cp.createContactClick();
		creatingNewContactPage cnp=new creatingNewContactPage(driver);
		cnp.createContactDetails(LastName);
		cnp.saveClick();
	
		contactInformationPage cip=new contactInformationPage(driver);
		String lastNameHeaderInfo = cip.contHeaderInfovalidations();
		if(lastNameHeaderInfo.contains(LastName)) {
			System.out.println(LastName + " Organization Name =====>PASS");
		}else {
			System.out.println(LastName + " Organization Name =====>FAIL");
		}

		
		hp.logout();
		
		Thread.sleep(3000);

		driver.quit();


	}

}
