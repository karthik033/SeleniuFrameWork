package OtherTestScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericFileUtility.CommonFileUtility;
import GenericFileUtility.ExcelFileUtility;
import ObjectRepositoryUtility.creatingNewDocumentPage;
import ObjectRepositoryUtility.documentInformationPage;
import ObjectRepositoryUtility.documentsPage;
import ObjectRepositoryUtility.homePage;
import ObjectRepositoryUtility.loginPage;
import WebFileUtility.JavaUtility;

public class CreateDocumentTest {

	public static void main(String[] args) throws Throwable {
		
		CommonFileUtility flib = new CommonFileUtility();
		ExcelFileUtility elib = new ExcelFileUtility();
		JavaUtility jlib = new JavaUtility();

		String BROWSER = System.getProperty("browser", flib.getDataFromPropertiesFile("browser"));
		String URL = System.getProperty("url", flib.getDataFromPropertiesFile("url"));
		String USERNAME = System.getProperty("username", flib.getDataFromPropertiesFile("username"));
		String PASSWORD = System.getProperty("password", flib.getDataFromPropertiesFile("password"));
		String docName = elib.getDataFromExcel("Document", 1, 2).toString() + jlib.getRandomNumber();

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
		hp.documentsClick();
		documentsPage dp=new documentsPage(driver);
		dp.createDocumentClick();
		creatingNewDocumentPage cndp=new creatingNewDocumentPage(driver);
		cndp.createDocumentDetails(docName);
		cndp.saveClick();
		
		documentInformationPage dip=new documentInformationPage(driver);
		String headerInfo = dip.getDocumentHeaderInfo().getText();
		if (headerInfo.contains(docName)) {
			System.out.println(docName + " Document Name =====>PASS");
		} else {
			System.out.println(docName + " Document Name =====>FAIL");
		}
		
		hp.logout();
		
		Thread.sleep(3000);

		driver.quit();

	}

}
