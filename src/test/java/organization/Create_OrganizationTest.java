package organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericFileUtility.CommonFileUtility;
import GenericFileUtility.ExcelFileUtility;
import ObjectRepositoryUtility.creatingNewOrganizationPage;
import ObjectRepositoryUtility.homePage;
import ObjectRepositoryUtility.loginPage;
import ObjectRepositoryUtility.organizationInformationPage;
import ObjectRepositoryUtility.organizationsPage;
import WebFileUtility.JavaUtility;

public class Create_OrganizationTest {

	public static void main(String[] args) throws Throwable {
		
		CommonFileUtility flib = new CommonFileUtility();
		ExcelFileUtility elib = new ExcelFileUtility();
		JavaUtility jlib = new JavaUtility();

		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");

		String orgName = elib.getDataFromExcel("Organization", 1, 2).toString() + jlib.getRandomNumber();

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

		hp.logout();

		Thread.sleep(3000);

		driver.quit();

	}

}
