package OtherTestScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericFileUtility.CommonFileUtility;
import GenericFileUtility.ExcelFileUtility;
import ObjectRepositoryUtility.CreatingNewCampaignPage;
import ObjectRepositoryUtility.campaignInformationPage;
import ObjectRepositoryUtility.campaignsPage;
import ObjectRepositoryUtility.homePage;
import ObjectRepositoryUtility.loginPage;
import WebFileUtility.JavaUtility;

public class createCampaignsTest {

	public static void main(String[] args) throws Throwable {

		CommonFileUtility flib = new CommonFileUtility();
		ExcelFileUtility elib = new ExcelFileUtility();
		JavaUtility jlib = new JavaUtility();

		String BROWSER = System.getProperty("browser", flib.getDataFromPropertiesFile("browser"));
		String URL = System.getProperty("url", flib.getDataFromPropertiesFile("url"));
		String USERNAME = System.getProperty("username", flib.getDataFromPropertiesFile("username"));
		String PASSWORD = System.getProperty("password", flib.getDataFromPropertiesFile("password"));
		String campaignsName = elib.getDataFromExcel("Campaigns", 1, 2).toString() + jlib.getRandomNumber();

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

		loginPage lp = new loginPage(driver);
		lp.loginData(URL, USERNAME, PASSWORD);

		homePage hp = new homePage(driver);
		hp.moreClick();
		hp.campaignsClick();
		campaignsPage cp = new campaignsPage(driver);
		cp.createNewCampaignClick();
		CreatingNewCampaignPage cncp = new CreatingNewCampaignPage(driver);
		cncp.createCampaigNnameDetails(campaignsName);
		String expectedDate = jlib.getRequiredDate(30);
		cncp.expectedDate(expectedDate);
		cncp.saveClick();

		campaignInformationPage cip = new campaignInformationPage(driver);
		String headerInfo = cip.campaignHeaderInfoValidation();
		if (headerInfo.contains(campaignsName)) {
			System.out.println(campaignsName + " Campaigns Name =====>PASS");
		} else {
			System.out.println(campaignsName + " Campaigns Name =====>FAIL");
		}

		String compInfo = cip.campaignDateInfoValidation();
		if (compInfo.contains(expectedDate)) {
			System.out.println(expectedDate + " Expected Date =====>PASS");
		} else {
			System.out.println(expectedDate + " Expected Date =====>FAIL");
		}

		hp.logout();

		Thread.sleep(3000);

		driver.quit();

	}

}
