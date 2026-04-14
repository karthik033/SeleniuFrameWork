package ListenersUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseClassUtility.BaseClass;
import WebFileUtility.utilityClassObject;

public class listenersClass implements ITestListener, ISuiteListener {

	public ExtentReports report;
	public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report Configuration");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("BROWSER", "chrome");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report BackUp");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("==========>" + result.getMethod().getMethodName() + ">=====Start=====");
		test = report.createTest(result.getMethod().getMethodName());
		utilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"=====>STARTED<=====");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("==========>" + result.getMethod().getMethodName() + ">=====End=====");
		test.log(Status.PASS, result.getMethod().getMethodName()+"=====>COMPLETED<=====");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname = result.getMethod().getMethodName();

		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		String DateAndTime = new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filePath, testname+"_"+DateAndTime);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"=====>FAILED<=====");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+"=====>SKIPPED<=====");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}
	

}
