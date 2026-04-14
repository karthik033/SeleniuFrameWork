package OtherTestScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericFileUtility.CommonFileUtility;
import GenericFileUtility.ExcelFileUtility;
import ObjectRepositoryUtility.CreatingNewTicketPage;
import ObjectRepositoryUtility.TroubleTicketsInformationPage;
import ObjectRepositoryUtility.homePage;
import ObjectRepositoryUtility.loginPage;
import ObjectRepositoryUtility.troubleTicketsPage;
import WebFileUtility.JavaUtility;

public class CreateTroubleTicketTest {

	public static void main(String[] args) throws Throwable {
		
		CommonFileUtility flib = new CommonFileUtility();
		ExcelFileUtility elib = new ExcelFileUtility();
		JavaUtility jlib = new JavaUtility();

		String BROWSER = System.getProperty("browser", flib.getDataFromPropertiesFile("browser"));
		String URL = System.getProperty("url", flib.getDataFromPropertiesFile("url"));
		String USERNAME = System.getProperty("username", flib.getDataFromPropertiesFile("username"));
		String PASSWORD = System.getProperty("password", flib.getDataFromPropertiesFile("password"));

		String titName = elib.getDataFromExcel("TroubleTicket", 1, 2).toString() + jlib.getRandomNumber();

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
		hp.troubleTicketsClick();
		troubleTicketsPage ttp=new troubleTicketsPage(driver);
		ttp.createTroubleTicketClick();
		CreatingNewTicketPage cntp=new CreatingNewTicketPage(driver);
		cntp.getTitleName().sendKeys(titName);
		cntp.saveClick();
		
		TroubleTicketsInformationPage ttip=new TroubleTicketsInformationPage(driver);
		String headerInfo = ttip.troubleTicketInfovalidations();
		if (headerInfo.contains(titName)) {
			System.out.println(titName + " TroubleTicket Name =====>PASS");
		} else {
			System.out.println(titName + " TroubleTicket Name =====>FAIL");
		}
		
		hp.logout();
		
		Thread.sleep(3000);

		driver.quit();
	

	}

}
