package BaseClasses;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ActivityPageClasses.LandingPage;
import Utilities.DateUtil;

public class PageBaseClass extends BaseTestClass
{
	public ExtentTest logger;
	

	public PageBaseClass(WebDriver driver, ExtentTest logger) 
	{
		this.driver = driver;
		this.logger = logger;
	}

	/****************** OpenApplication For ActivityPageClasses ***********************/
	
	public ActivityPageClasses.LandingPage OpenWebsite() 
	{
		logger.log(Status.INFO, "Opening the Website");
		driver.get("https://in.bookmyshow.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		logger.log(Status.PASS, "Successfully Opened BookMyShow website");
		LandingPage landingPage = new LandingPage(driver, logger);
		PageFactory.initElements(driver, landingPage);
		return landingPage;
	}
	
	/****************** OpenApplication For MoviePageClasses ***********************/
	
	public MoviePageClasses.LandingPage OpenWebsite1() 
	{
		logger.log(Status.INFO, "Opening the Website");
		driver.get("https://in.bookmyshow.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		logger.log(Status.PASS, "Successfully Opened BookMyShow website");
		MoviePageClasses.LandingPage landingPage = new MoviePageClasses.LandingPage(driver, logger);
		PageFactory.initElements(driver, landingPage);
		return landingPage;
	}
	
	/****************** OpenApplication For SignInPageClasses ***********************/	
	
	public SignInPageClasses.LandingPage OpenWebsite2() 
	{
		logger.log(Status.INFO, "Opening the Website");
		driver.get("https://in.bookmyshow.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		logger.log(Status.PASS, "Successfully Opened BookMyShow website");
		SignInPageClasses.LandingPage landingPage = new SignInPageClasses.LandingPage(driver, logger);
		PageFactory.initElements(driver, landingPage);
		return landingPage;
	}

	
	
	/****************** Get Page Title ***********************/
	public void getTitle(String expectedTitle) {
		try {
			Assert.assertEquals(driver.getTitle(), expectedTitle);
			reportPass("Actual Title : " + driver.getTitle() + " - equals to Expected Title : " + expectedTitle);
		} 
		catch (Exception e) 
		{
			reportFail(e.getMessage());
		}

	}
	

	/****************** Reporting Functions ***********************/
	public void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		captureScreenshot();
		Assert.fail(reportString);
	}

	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
	}

	
	/****************** Capture Screen Shot ***********************/
	public void captureScreenshot() {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);

		File destFile = new File(System.getProperty("user.dir") + "/Screenshots/" + DateUtil.getTimeStamp() + ".png");
		try {
			FileUtils.copyFile(sourceFile, destFile);
			logger.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "/Screenshots/" + DateUtil.getTimeStamp() + ".png");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/****************** Accept Java Script Alert ***********************/
	public void acceptAlert(){
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			logger.log(Status.PASS, "Page Alert Accepted");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		
	}
	
	/****************** Cancel Java Script Alert ***********************/
	public void cancelAlert(){
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			logger.log(Status.PASS, "Page Alert Rejected");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		
	}

	/****************** Verify Element is Present ***********************/
	public void verifyElementIsDisplayed(WebElement webElement){
		try {
			if(webElement.isDisplayed()){
				reportPass("WebElement is displayed");
			}else {
				reportFail("WebElement is not displayed");
			}
			
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		
	}

	
	


}
