package testCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test.TestBaseClass;
import testsuite.LoginTestClass;
import testsuite.RegistrationTest;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class NewTest extends TestBaseClass {
	ExtentReports extent;
	ExtentTest test;

	@BeforeTest
	public void beforeTest()
	{
		extent = new ExtentReports(System.getProperty("user.dir")
				+ "//testresults//testreport.html");
		extent.addSystemInfo("Evironment", "SDP.Test3");
		extent.addSystemInfo("username", "SK144P");

		extent.loadConfig(new File(System.getProperty("user.dir")
				+ "//src//resource//java//config/extentReportConfig.xml"));
	}
	@BeforeMethod
	public void beforeMethod() throws IOException {
		
		
		initiallize();
	}

	@Test
	public void registrationTest() throws Exception 
	{	test=extent.startTest("RegistrationTest");
		RegistrationTest rt = new RegistrationTest();
		rt.RegTestMethod();
		Assert.assertTrue(false);
		test.log(LogStatus.PASS, "Registration Test executed successfully");
		
	}

	@Test
	public void loginTest() throws Exception {
		test=extent.startTest("loginTest");
		LoginTestClass lt = new LoginTestClass();
		lt.loginTest();
		test.log(LogStatus.PASS, "Login Test executed successfully");		
	}

	@Test
	public void xyzTest() throws Exception {
		test=extent.startTest("xyz test");
		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "xyz Test executed successfully");		
	}
	@Test
	public void abcTest() throws Exception {
		test=extent.startTest("abc test");
		Assert.assertTrue(false);
		test.log(LogStatus.PASS, "xyz Test executed successfully");		
	}
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(LogStatus.FAIL, result.getThrowable());
		}
		
		extent.endTest(test);
		closeBrowser();
		
	}
	@AfterTest
	public void endReport()
	{
		extent.flush();
		extent.close();
	}

}
