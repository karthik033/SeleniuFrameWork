package contact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericFileUtility.CommonFileUtility;
import GenericFileUtility.ExcelFileUtility;
import ObjectRepositoryUtility.childWindow;
import ObjectRepositoryUtility.contactInformationPage;
import ObjectRepositoryUtility.contactsPage;
import ObjectRepositoryUtility.creatingNewContactPage;
import ObjectRepositoryUtility.creatingNewOrganizationPage;
import ObjectRepositoryUtility.homePage;
import ObjectRepositoryUtility.loginPage;
import ObjectRepositoryUtility.organizationInformationPage;
import ObjectRepositoryUtility.organizationsPage;
import WebFileUtility.JavaUtility;
import WebFileUtility.webDriverUtility;

public class CreateContactWithOrganizationTest {

	public static void main(String[] args) throws Throwable {

		CommonFileUtility flib = new CommonFileUtility();
		ExcelFileUtility elib = new ExcelFileUtility();
		JavaUtility jlib = new JavaUtility();
		webDriverUtility wlib = new webDriverUtility();

		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");

		String LastName = elib.getDataFromExcel("Contact", 7, 2).toString() + jlib.getRandomNumber();
		String orgName = elib.getDataFromExcel("Contact", 7, 3).toString() + jlib.getRandomNumber();

		WebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		loginPage lp=new loginPage(driver);
		lp.loginData(URL, USERNAME, PASSWORD);
		
		homePage hp=new homePage(driver);
		hp.organizationClick();
		organizationsPage op=new organizationsPage(driver);
		op.createOrganizationCLick();
		creatingNewOrganizationPage cno=new creatingNewOrganizationPage(driver);
		cno.OganizationDetail(orgName);
		cno.saveClick();
		organizationInformationPage oip=new organizationInformationPage(driver);
		String headerInfo =oip.orgHeaderInfovalidations();
		if (headerInfo.contains(orgName)) {
			System.out.println(orgName + " Organization Name =====>PASS");
		} else {
			System.out.println(orgName + " Organization Name =====>FAIL");
		}
		
		hp.contactClick();
		contactsPage cp=new contactsPage(driver);
		cp.createContactClick();
		creatingNewContactPage cnp=new creatingNewContactPage(driver);
		cnp.createContactDetails(LastName);
		cnp.plusClick();
		
		String parentId = driver.getWindowHandle();
		wlib.toSwitchWindow(driver);
		childWindow cw=new childWindow(driver);
		cw.searchField(orgName);
		cw.searchNameClick();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	    wlib.toSwitchBackToWindow(driver, parentId);
	    cnp.saveClick();

	    contactInformationPage cip=new contactInformationPage(driver);
		String lastNameHeaderInfo = cip.contHeaderInfovalidations();
		if(lastNameHeaderInfo.contains(LastName)) {
			System.out.println(LastName + " LastName =====>PASS");
		}else {
			System.out.println(LastName + " LastName =====>FAIL");
		}

		hp.logout();
		
		Thread.sleep(3000);

		driver.quit();

		
	}

}
