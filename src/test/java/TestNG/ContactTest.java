  package TestNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import ObjectRepositoryUtility.childWindow;
import ObjectRepositoryUtility.contactInformationPage;
import ObjectRepositoryUtility.contactsPage;					
import ObjectRepositoryUtility.creatingNewContactPage;
import ObjectRepositoryUtility.creatingNewOrganizationPage;
import ObjectRepositoryUtility.homePage;
import ObjectRepositoryUtility.organizationInformationPage;
import ObjectRepositoryUtility.organizationsPage;
import WebFileUtility.utilityClassObject;

public class ContactTest extends BaseClassUtility.BaseClass {

	@Test(groups = "SmokeTest")
	public void createContact() throws Throwable {
		utilityClassObject.getTest().log(Status.INFO, "Read Data From Excel");
		System.out.println("==========createContact==========");
		String LastName = elib.getDataFromExcel("Contact", 1, 2).toString() + jlib.getRandomNumber();

		utilityClassObject.getTest().log(Status.INFO, "Navigate To Home Page");
		homePage hp = new homePage(driver);
		hp.contactClick();
		
		utilityClassObject.getTest().log(Status.INFO, "Navigate To Contact Page");
		contactsPage cp = new contactsPage(driver);
		cp.createContactClick();
		
		utilityClassObject.getTest().log(Status.INFO, "Creating New Contact ");
		creatingNewContactPage cnp = new creatingNewContactPage(driver);
		cnp.createContactDetails(LastName);
		cnp.saveClick();

		utilityClassObject.getTest().log(Status.INFO, LastName + "===>New Contact is Created ");
		contactInformationPage cip = new contactInformationPage(driver);
		String lastNameHeaderInfo = cip.contHeaderInfovalidations();
		boolean validation = lastNameHeaderInfo.contains(LastName);
		Assert.assertEquals(validation,true);
	}

	@Test(groups = "RegressionTest")
	public void createContactWithOrganization() throws Throwable {
		utilityClassObject.getTest().log(Status.INFO, "Read Data From Excel");
		System.out.println("==========createContactWithDate==========");
		
		String orgName = elib.getDataFromExcel("Contact", 7, 3).toString() + jlib.getRandomNumber();
		String LastName = elib.getDataFromExcel("Contact", 7, 2).toString() + jlib.getRandomNumber();

		utilityClassObject.getTest().log(Status.INFO, "Navigate To Home Page");
		homePage hp = new homePage(driver);
		hp.organizationClick();
		
		utilityClassObject.getTest().log(Status.INFO, "Navigate To Organization Page");
		organizationsPage op = new organizationsPage(driver);
		op.createOrganizationCLick();
		
		utilityClassObject.getTest().log(Status.INFO, "Creating New Organization ");
		creatingNewOrganizationPage cno = new creatingNewOrganizationPage(driver);
		cno.OganizationDetail(orgName);
		cno.saveClick();
		
		utilityClassObject.getTest().log(Status.INFO, orgName + "===>New Organization is Created ");
		organizationInformationPage oip = new organizationInformationPage(driver);
		String orgNameheaderInfo = oip.orgHeaderInfovalidations();
		boolean validation = orgNameheaderInfo.contains(orgName);
		Assert.assertEquals(validation,true);

		utilityClassObject.getTest().log(Status.INFO, "Navigate To Home Page");
		hp.contactClick();
		
		utilityClassObject.getTest().log(Status.INFO, "Navigate To Contact Page");
		contactsPage cp = new contactsPage(driver);
		cp.createContactClick();
		
		utilityClassObject.getTest().log(Status.INFO, "Creating New Contact ");
		creatingNewContactPage cnp = new creatingNewContactPage(driver);
		cnp.createContactDetails(LastName);
		cnp.plusClick();

		utilityClassObject.getTest().log(Status.INFO, "Switch To Child Window");
		String parentId = driver.getWindowHandle();
		wlib.toSwitchWindow(driver);
		
		utilityClassObject.getTest().log(Status.INFO, "Organization is Searched ");
		childWindow cw = new childWindow(driver);
		cw.searchField(orgName);
		cw.searchNameClick();
		
		utilityClassObject.getTest().log(Status.INFO,orgName+ "===>Organization is Selected ");
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();
		
		utilityClassObject.getTest().log(Status.INFO, "SwitchBack To Parent Window");
		wlib.toSwitchBackToWindow(driver, parentId);
		cnp.saveClick();

		utilityClassObject.getTest().log(Status.INFO, LastName + "===>New Contact is Created ");
		contactInformationPage cip = new contactInformationPage(driver);
		String contLastNameHeaderInfo = cip.contHeaderInfovalidations();
		boolean validation2 = contLastNameHeaderInfo.contains(LastName);
		Assert.assertEquals(validation2,true);
	}

	@Test(groups = "RegressionTest")
	public void createContactWithSupportDate() throws Throwable {
		utilityClassObject.getTest().log(Status.INFO, "Read Data From Excel");
		System.out.println("==========createContactWithDate==========");
		String LastName = elib.getDataFromExcel("Contact", 4, 2).toString() + jlib.getRandomNumber();

		utilityClassObject.getTest().log(Status.INFO, "Navigate To Home Page");
		homePage hp = new homePage(driver);
		hp.contactClick();
		
		utilityClassObject.getTest().log(Status.INFO, "Navigate To Contact Page");
		contactsPage cp = new contactsPage(driver);
		cp.createContactClick();
		
		utilityClassObject.getTest().log(Status.INFO, "Creating New Contact ");
		creatingNewContactPage cnp = new creatingNewContactPage(driver);
		cnp.createContactDetails(LastName);
		String startDate = jlib.getSystemdate();
		String endDate = jlib.getRequiredDate(30);
		cnp.startDateAndEndDate(startDate, endDate);
		cnp.saveClick();

		utilityClassObject.getTest().log(Status.INFO, LastName + "===>New Contact is Created ");
		contactInformationPage cip = new contactInformationPage(driver);
		String lastNameHeaderInfo = cip.contHeaderInfovalidations();
		boolean validation1 = lastNameHeaderInfo.contains(LastName);
		Assert.assertEquals(validation1,true);

		utilityClassObject.getTest().log(Status.INFO, startDate + "===>StartDate is Selected ");
		String SDate = cip.startDateInfovalidations();
		SoftAssert softA= new SoftAssert();
		softA.assertTrue(true, SDate);
	    softA.assertAll();

	    utilityClassObject.getTest().log(Status.INFO, endDate + "===>EndDate is Selected ");
		String EDate = cip.endDateInfovalidations();
		SoftAssert softA2= new SoftAssert();
		softA2.assertTrue(true, EDate);
	    softA2.assertAll();
	}
}



