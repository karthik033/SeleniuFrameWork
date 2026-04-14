package OtherTestScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericFileUtility.CommonFileUtility;
import GenericFileUtility.ExcelFileUtility;
import ObjectRepositoryUtility.creatingNewProductPage;
import ObjectRepositoryUtility.homePage;
import ObjectRepositoryUtility.loginPage;
import ObjectRepositoryUtility.productInformationPage;
import ObjectRepositoryUtility.productsPage;
import WebFileUtility.JavaUtility;

public class CreateProductTest {

	public static void main(String[] args) throws Throwable {
		
		CommonFileUtility flib = new CommonFileUtility();
		ExcelFileUtility elib = new ExcelFileUtility();
		JavaUtility jlib = new JavaUtility();

		String BROWSER = System.getProperty("browser", flib.getDataFromPropertiesFile("browser"));
		String URL = System.getProperty("url", flib.getDataFromPropertiesFile("url"));
		String USERNAME = System.getProperty("username", flib.getDataFromPropertiesFile("username"));
		String PASSWORD = System.getProperty("password", flib.getDataFromPropertiesFile("password"));

		String proName = elib.getDataFromExcel("Product", 1, 2).toString() + jlib.getRandomNumber();

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
		hp.productsClick();
		productsPage pp=new productsPage(driver);
		pp.createProductsCLick();
		creatingNewProductPage cnpp=new creatingNewProductPage(driver);
		cnpp.createProductDetails(proName);
		cnpp.saveClick();
		
		productInformationPage pip=new productInformationPage(driver);
		String headerInfo = pip.proHeaderInfovalidations();
		if (headerInfo.contains(proName)) {
			System.out.println(proName + " Product Name =====>PASS");
		} else {
			System.out.println(proName + " Product Name =====>FAIL");
		}
		
		hp.logout();
		
		Thread.sleep(3000);

		driver.quit();
	

	}

}
