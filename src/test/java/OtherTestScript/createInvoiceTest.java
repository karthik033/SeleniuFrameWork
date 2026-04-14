package OtherTestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericFileUtility.CommonFileUtility;
import GenericFileUtility.ExcelFileUtility;
import ObjectRepositoryUtility.CreatingNewInvoicePage;
import ObjectRepositoryUtility.InvoiceInformationPage;
import ObjectRepositoryUtility.childWindow;
import ObjectRepositoryUtility.creatingNewProductPage;
import ObjectRepositoryUtility.homePage;
import ObjectRepositoryUtility.invoicePage;
import ObjectRepositoryUtility.loginPage;
import ObjectRepositoryUtility.organizationsPage;
import ObjectRepositoryUtility.productsPage;
import WebFileUtility.JavaUtility;
import WebFileUtility.webDriverUtility;

public class createInvoiceTest {

	public static void main(String[] args) throws Throwable {

		CommonFileUtility flib = new CommonFileUtility();
		ExcelFileUtility elib = new ExcelFileUtility();
		JavaUtility jlib = new JavaUtility();
		webDriverUtility wlib = new webDriverUtility();

		String BROWSER = System.getProperty("browser", flib.getDataFromPropertiesFile("browser"));
		String URL = System.getProperty("url", flib.getDataFromPropertiesFile("url"));
		String USERNAME = System.getProperty("username", flib.getDataFromPropertiesFile("username"));
		String PASSWORD = System.getProperty("password", flib.getDataFromPropertiesFile("password"));
		String orgName = elib.getDataFromExcel("Invoice", 1, 3) + jlib.getRandomNumber();
		String subjectName = elib.getDataFromExcel("Invoice", 1, 2) + jlib.getRandomNumber();
		String billingAddress = elib.getDataFromExcel("Invoice", 1, 4);
		String shippingAddress = elib.getDataFromExcel("Invoice", 1, 5);
		String iteamName = elib.getDataFromExcel("Invoice", 1, 6);
		String quantity = elib.getDataFromExcel("Invoice", 1, 7).toString();
		String price = elib.getDataFromExcel("Invoice", 1, 8).toString();

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
		CreatingNewInvoicePage cnip = new CreatingNewInvoicePage(driver);
		cnip.oganizationName(orgName);;
		cnip.saveClick();
		InvoiceInformationPage iip = new InvoiceInformationPage(driver);
		String headerInfo = iip.orgHeaderInfovalidations();
		if (headerInfo.contains(orgName)) {
			System.out.println(orgName + " Organization Name =====>PASS");
		} else {
			System.out.println(orgName + " Organization Name =====>FAIL");
		}
		Thread.sleep(3000);
		
		hp.productsClick();
		productsPage pp=new productsPage(driver);
		pp.createProductsCLick();
		creatingNewProductPage cnpp=new creatingNewProductPage(driver);
		cnpp.createProductDetails(iteamName);
		cnpp.saveClick();
		
		String headerInfo2 = iip.proHeaderInfovalidations();
		if (headerInfo2.contains(iteamName)) {
			System.out.println(iteamName + " IteamName =====>PASS");
		} else {
			System.out.println(iteamName + " IteamName =====>FAIL");
		}
		
		hp.moreClick();
		hp.invoiceClick();
		invoicePage ip = new invoicePage(driver);
		ip.NewInvoiceClick();
		cnip.enterSubjectName(subjectName);
		cnip.plusIconClick();
		
		String parentId = driver.getWindowHandle();
		wlib.toSwitchWindow(driver);
		childWindow cw=new childWindow(driver);
		cw.searchField(orgName);
		cw.searchNameClick();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		wlib.switchToAlertDismiss(driver);
	    wlib.toSwitchBackToWindow(driver, parentId);
		
		cnip.enterBillingAddress(billingAddress);
		cnip.enterShippingAddress(shippingAddress);
		cnip.iteamButtonClick();
		
		String parentId2 = driver.getWindowHandle();
		wlib.toSwitchWindow(driver);
		childWindow cw2=new childWindow(driver);
		cw2.searchField(iteamName);
		cw2.searchNameClick();
		driver.findElement(By.xpath("//a[text()='"+iteamName+"']")).click();
	    wlib.toSwitchBackToWindow(driver, parentId2);
		
		cnip.enterQuantity(quantity);
		cnip.enterPrice(price);
		cnip.saveClick();

	/*	campaignInformationPage cip = new campaignInformationPage(driver);
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
*/
		hp.logout();

		Thread.sleep(3000);

		driver.quit();

	}

}
