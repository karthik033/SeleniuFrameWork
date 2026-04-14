package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import ObjectRepositoryUtility.creatingNewOrganizationPage;
import ObjectRepositoryUtility.homePage;
import ObjectRepositoryUtility.organizationInformationPage;
import ObjectRepositoryUtility.organizationsPage;
import WebFileUtility.utilityClassObject;

/**
 * @author Karthik Naik
 * 
 * 
 */
public class OrganizationTest extends BaseClassUtility.BaseClass {

	@Test(groups = "SmokeTest")
	public void CreateOrganization() throws Throwable {

		utilityClassObject.getTest().log(Status.INFO, "Read Data From Excel");
		System.out.println("==========CreateOrganization==========");
		String orgName = elib.getDataFromExcel("Organization", 1, 2).toString() + jlib.getRandomNumber();

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
		String headerInfo = oip.orgHeaderInfovalidations();
		boolean validation = headerInfo.contains(orgName);
		Assert.assertEquals(validation, true);
	}

	@Test(groups = "RegressionTest")
	public void CreateOrganizationWithIndustryAndType() throws Throwable {

		utilityClassObject.getTest().log(Status.INFO, "Read Data From Excel");
		System.out.println("==========CreateOrganizationWithIndustryAndType==========");
		String orgName = elib.getDataFromExcel("Organization", 4, 2).toString() + jlib.getRandomNumber();
		String industry = elib.getDataFromExcel("Organization", 4, 3).toString();
		String type = elib.getDataFromExcel("Organization", 4, 4).toString();

		utilityClassObject.getTest().log(Status.INFO, "Navigate To Home Page");
		homePage hp = new homePage(driver);
		hp.organizationClick();

		utilityClassObject.getTest().log(Status.INFO, "Navigate To Organization Page");
		organizationsPage op = new organizationsPage(driver);
		op.createOrganizationCLick();

		utilityClassObject.getTest().log(Status.INFO, " Creating New Organization With Industry And Type ");
		creatingNewOrganizationPage cno = new creatingNewOrganizationPage(driver);
		cno.OganizationWithDropDownDetail(orgName, industry, type);
		cno.saveClick();

		utilityClassObject.getTest().log(Status.INFO, orgName + "===>New Organization is Created ");
		organizationInformationPage oip = new organizationInformationPage(driver);
		String headerInfo = oip.orgHeaderInfovalidations();
		boolean validation = headerInfo.contains(orgName);
		Assert.assertEquals(validation, true);

		utilityClassObject.getTest().log(Status.INFO, industry + "===>Industry is Selected");
		String actIndName = oip.industryInfovalidations();
		SoftAssert softA = new SoftAssert();
		softA.assertTrue(true, actIndName);
		softA.assertAll();

		utilityClassObject.getTest().log(Status.INFO, type + "===>Type is Selected ");
		String actTyName = oip.typeInfovalidations();
		SoftAssert softA2 = new SoftAssert();
		softA2.assertTrue(true, actTyName);
		softA2.assertAll();
	}

	@Test(groups = "RegressionTest")
	public void CreateOrganizationWithPhoneNumber() throws Throwable {
		utilityClassObject.getTest().log(Status.INFO, "Read Data From Excel");
		System.out.println("==========CreateOrganizationWithPhoneNumber==========");
		String orgName = elib.getDataFromExcel("Organization", 7, 2).toString() + jlib.getRandomNumber();
		String phone = elib.getDataFromExcel("Organization", 7, 3).toString();

		utilityClassObject.getTest().log(Status.INFO, "Navigate To Home Page");
		homePage hp = new homePage(driver);
		hp.organizationClick();

		utilityClassObject.getTest().log(Status.INFO, "Navigate To Organization Page");
		organizationsPage op = new organizationsPage(driver);
		op.createOrganizationCLick();

		utilityClassObject.getTest().log(Status.INFO, "Creating New Organization With PhoneNumber");
		creatingNewOrganizationPage cno = new creatingNewOrganizationPage(driver);
		cno.OganizationWithPhoneDetail(orgName, phone);
		cno.saveClick();

		utilityClassObject.getTest().log(Status.INFO, orgName + "===>New Organization is Created ");
		organizationInformationPage oip = new organizationInformationPage(driver);
		String headerInfo = oip.orgHeaderInfovalidations();
		boolean validation = headerInfo.contains(orgName);
		Assert.assertEquals(validation, true);

		utilityClassObject.getTest().log(Status.INFO, phone + "===>PhoneNumber is Created ");
		String actualPhone = oip.phoneInfovalidations();
		SoftAssert softA = new SoftAssert();
		softA.assertTrue(true, actualPhone);
		softA.assertAll();
	}
}
