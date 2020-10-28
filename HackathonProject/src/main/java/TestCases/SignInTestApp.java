package TestCases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClasses.BaseTestClass;
import BaseClasses.PageBaseClass;
import SignInPageClasses.LandingPage;
import SignInPageClasses.LocationPage;
import Utilities.TestDataProvider;

public class SignInTestApp extends BaseTestClass
{
	
	LandingPage landingPage;
	LocationPage locationPage;
	
	@Test(dataProvider="getEmailTestData1", groups={"Smoke", "SignInTest_InvalidEmail" })
	public void signInTest1(Hashtable<String, String> testData) throws Exception
	{
		logger = report.createTest("Log in through Google Email : " + testData.get("Comment"));
		
		invokeBrowser(1);
		
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		
		landingPage = pageBase.OpenWebsite2();
		landingPage.cancelPopup();
		locationPage = landingPage.enterCity("city_");
		
		locationPage.signIn1(testData.get("Email Id"));
	}   
	
	@Test(dataProvider="getEmailTestData2", groups={"Smoke", "SignInTest_InvalidPhone" })
	public void signInTest2(Hashtable<String, String> testData) throws Exception
	{
		logger = report.createTest("Log in through Google Email : " + testData.get("Comment"));
		
		invokeBrowser(1);
		
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		
		landingPage = pageBase.OpenWebsite2();
		landingPage.cancelPopup();
		locationPage = landingPage.selectPopularCity("Mumbai");
		
		locationPage.signIn1(testData.get("Email Id"));
	}   
	
	@Test(dataProvider="getEmailTestData3", groups={"Smoke", "SignInTest_BlankEmail" })
	public void signInTest3(Hashtable<String, String> testData) throws Exception
	{
		logger = report.createTest("Log in through Google Email : " + testData.get("Comment"));
		
		invokeBrowser(1);
		
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		
		landingPage = pageBase.OpenWebsite2();
		landingPage.cancelPopup();
		locationPage = landingPage.selectPopularCity("Chennai");
		
		locationPage.signIn1(testData.get("Email Id"));
	}   
	
	@Test(dataProvider="getEmailTestData2", groups={"Smoke", "SignInTest_InvalidPhone" })
	public void signInTest4(Hashtable<String, String> testData) throws Exception
	{
		logger = report.createTest("Log in through Google Email : " + testData.get("Comment"));
		
		invokeBrowser(2);
		
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		
		landingPage = pageBase.OpenWebsite2();
		landingPage.cancelPopup();
		
		locationPage = landingPage.selectPopularCity("Mumbai");
		
		Thread.sleep(2000);
		pageBase.captureScreenshot();
		locationPage.signIn2(testData.get("Email Id"));
	}
	
	@Test(dataProvider="getEmailTestData3", groups={"Smoke", "SignInTest_BlankEmail" })
	public void signInTest5(Hashtable<String, String> testData) throws Exception
	{
		logger = report.createTest("Log in through Google Email : " + testData.get("Comment"));
		
		invokeBrowser(3);
		
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		
		landingPage = pageBase.OpenWebsite2();
		landingPage.cancelPopup();
		locationPage = landingPage.enterCity("city_");
		
		locationPage.signIn3(testData.get("Email Id"));
	} 
	
	@Test(dataProvider="getEmailTestData4", groups={"Smoke", "SignInTest_InvalidPassword" })
	public void signInTest6(Hashtable<String, String> testData) throws Exception
	{
		logger = report.createTest("Log in through Google Email : " + testData.get("Comment"));
		
		invokeBrowser(4);
		
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		
		landingPage = pageBase.OpenWebsite2();
		landingPage.cancelPopup();
		
		locationPage = landingPage.enterCity("city_");
		
		locationPage.signIn4(testData.get("Email Id"),testData.get("Password"));
		
	}     
	
	
	@DataProvider
	public Object[][] getEmailTestData1()
	{
		return TestDataProvider.getTestData("LoginCredentials.xlsx", "LoginTestData", "emailCredentials_InvalidEmail");
	}
	
	@DataProvider
	public Object[][] getEmailTestData2()
	{
		return TestDataProvider.getTestData("LoginCredentials.xlsx", "LoginTestData", "emailCredentials_InvalidPhone");
	}
	
	@DataProvider
	public Object[][] getEmailTestData3()
	{
		return TestDataProvider.getTestData("LoginCredentials.xlsx", "LoginTestData", "emailCredentials_BlankEmail");
	}
	
	@DataProvider
	public Object[][] getEmailTestData4()
	{
		return TestDataProvider.getTestData("LoginCredentials.xlsx", "LoginTestData", "emailCredentials_both");
	}
	
	
}
