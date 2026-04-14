package BaseClassUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import DataFileUtility.DataBaseUtility;
import GenericFileUtility.CommonFileUtility;
import GenericFileUtility.ExcelFileUtility;
import ObjectRepositoryUtility.homePage;
import ObjectRepositoryUtility.loginPage;
import WebFileUtility.JavaUtility;
import WebFileUtility.utilityClassObject;
import WebFileUtility.webDriverUtility;

@Listeners(ListenersUtility.listenersClass.class)
public class BaseClass {

	public CommonFileUtility flib = new CommonFileUtility();
	public ExcelFileUtility elib = new ExcelFileUtility();
	public JavaUtility jlib = new JavaUtility();
	public webDriverUtility wlib = new webDriverUtility();
	public  DataBaseUtility dlib=new DataBaseUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	
	@BeforeSuite(alwaysRun = true)
	public void confisBS() throws Throwable {
		System.out.println("===Connect to DB, Report Config===");
		dlib.getConnection();
	}
	
	@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void confisBC(@Optional("chrome") String browser) throws Throwable {
		System.out.println("===Launch the Browser===");
	//	String BROWSER = browser;
		String BROWSER = System.getProperty("browser", flib.getDataFromPropertiesFile("browser"));			
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}else {
			driver = new ChromeDriver();
		}
		sdriver=driver;
		utilityClassObject.setDriver(driver);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void confisBM() throws Throwable {
		System.out.println("===LogIn===");
		
		String URL = System.getProperty("url", flib.getDataFromPropertiesFile("url"));
		String USERNAME = System.getProperty("username", flib.getDataFromPropertiesFile("username"));
		String PASSWORD = System.getProperty("password", flib.getDataFromPropertiesFile("password"));
		loginPage lp=new loginPage(driver);
		lp.loginData(URL, USERNAME, PASSWORD);
	}
	
	@AfterMethod(alwaysRun = true)
	public void confisAM() {
		System.out.println("===LogOut===");
		homePage hp=new homePage(driver);
		hp.logout();
	}
	
	@AfterClass(alwaysRun = true)
	public void confisAC() {
		System.out.println("===Close the Browser===");
		driver.quit();
	}
	
	@AfterSuite(alwaysRun = true)
	public void confisAS() {
		System.out.println("===Close DB, Report Backup===");
		dlib.closeConnection();
	}
}
