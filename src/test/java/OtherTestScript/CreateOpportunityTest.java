package OtherTestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericFileUtility.CommonFileUtility;
import GenericFileUtility.ExcelFileUtility;
import ObjectRepositoryUtility.childWindow;
import ObjectRepositoryUtility.creatingNewOpportunityPage;
import ObjectRepositoryUtility.creatingNewOrganizationPage;
import ObjectRepositoryUtility.homePage;
import ObjectRepositoryUtility.loginPage;
import ObjectRepositoryUtility.opportunitiesPage;
import ObjectRepositoryUtility.opportunityInformationPage;
import ObjectRepositoryUtility.organizationInformationPage;
import ObjectRepositoryUtility.organizationsPage;
import WebFileUtility.JavaUtility;
import WebFileUtility.webDriverUtility;

public class CreateOpportunityTest {
 
	public static void main(String[] args) throws Throwable {

		CommonFileUtility flib = new CommonFileUtility();
		ExcelFileUtility elib = new ExcelFileUtility();
		JavaUtility jlib = new JavaUtility();
		webDriverUtility wlib = new webDriverUtility();

		String BROWSER = System.getProperty("browser", flib.getDataFromPropertiesFile("browser"));
		String URL = System.getProperty("url", flib.getDataFromPropertiesFile("url"));
		String USERNAME = System.getProperty("username", flib.getDataFromPropertiesFile("username"));
		String PASSWORD = System.getProperty("password", flib.getDataFromPropertiesFile("password"));

		String orgName = elib.getDataFromExcel("Opportunity", 1, 2).toString() + jlib.getRandomNumber();
		String oppName = elib.getDataFromExcel("Opportunity", 1, 3).toString() + jlib.getRandomNumber();

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

		homePage hp = new homePage(driver);
		hp.organizationClick();
		organizationsPage op = new organizationsPage(driver);
		op.createOrganizationCLick();
		creatingNewOrganizationPage cno = new creatingNewOrganizationPage(driver);
		cno.OganizationDetail(orgName);
		cno.saveClick();
		Thread.sleep(3000);
		organizationInformationPage oip=new organizationInformationPage(driver);
		String headerInfo =oip.orgHeaderInfovalidations();
		if (headerInfo.contains(orgName)) {
			System.out.println(orgName + " Organization Name =====>PASS");
		} else {
			System.out.println(orgName + " Organization Name =====>FAIL");
		}

		opportunitiesPage opp = new opportunitiesPage(driver);
		opp.createOpportunitiesClick();
		creatingNewOpportunityPage cnop = new creatingNewOpportunityPage(driver);
		cnop.getCreateNewOpportunities().click();
		cnop.createOpportunitiesDetails(oppName);
		cnop.plusOppIconClick();
		
		String parentId = driver.getWindowHandle();
		wlib.toSwitchWindow(driver);
		childWindow cw = new childWindow(driver);
		cw.searchField(orgName);
		cw.searchNameClick();
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();
		wlib.toSwitchBackToWindow(driver, parentId);
		
		cnop.saveClick();
		opportunityInformationPage opip = new opportunityInformationPage(driver);
		String headeroppname = opip.OppHeaderInfoValidation();
		if (headeroppname.contains(oppName)) {
			System.out.println(oppName + " Opportunity Name =====>PASS");
		} else {
			System.out.println(oppName + " Opportunity Name =====>FAIL");
		}

		hp.logout();

		Thread.sleep(3000);

		driver.quit();

	}

}
