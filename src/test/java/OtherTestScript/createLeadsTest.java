package OtherTestScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericFileUtility.CommonFileUtility;
import GenericFileUtility.ExcelFileUtility;
import ObjectRepositoryUtility.LeadInformationPage;
import ObjectRepositoryUtility.creatingNewLeadPage;
import ObjectRepositoryUtility.homePage;
import ObjectRepositoryUtility.leadPage;
import ObjectRepositoryUtility.loginPage;
import WebFileUtility.JavaUtility;

public class createLeadsTest {

	public static void main(String[] args) throws Throwable {

		CommonFileUtility flib = new CommonFileUtility();
		ExcelFileUtility elib = new ExcelFileUtility();
		JavaUtility jlib = new JavaUtility();

		String BROWSER = System.getProperty("browser", flib.getDataFromPropertiesFile("browser"));
		String URL = System.getProperty("url", flib.getDataFromPropertiesFile("url"));
		String USERNAME = System.getProperty("username", flib.getDataFromPropertiesFile("username"));
		String PASSWORD = System.getProperty("password", flib.getDataFromPropertiesFile("password"));

		String lastName = elib.getDataFromExcel("Leads", 1, 2).toString() + jlib.getRandomNumber();
		String compName = elib.getDataFromExcel("Leads", 1, 3).toString() + jlib.getRandomNumber();

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
		hp.leadClick();
		leadPage lep=new leadPage(driver);
		lep.createLeadsClick();
		creatingNewLeadPage cnlp=new creatingNewLeadPage(driver);
		cnlp.createLeadsDetails(lastName, compName);
		cnlp.saveClick();

		LeadInformationPage lip=new LeadInformationPage(driver);
		String lastNameHeaderInfo = lip.nameInfovalidations();
		if (lastNameHeaderInfo.contains(lastName)) {
			System.out.println(lastName + " LastName =====>PASS");
		} else {
			System.out.println(lastName + " LastName =====>FAIL");
		}

		String compInfo = lip.compInfovalidations();
		if (compInfo.contains(compName)) {
			System.out.println(compName + " Company Name =====>PASS");
		} else {
			System.out.println(compName + " Company Name =====>FAIL");
		}

		hp.logout();
		
		Thread.sleep(3000);

		driver.quit();

	}

}
