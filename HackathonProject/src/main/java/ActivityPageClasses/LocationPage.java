package ActivityPageClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClasses.PageBaseClass;

public class LocationPage extends PageBaseClass
{

	public LocationPage(WebDriver driver, ExtentTest logger) 
	{
		super(driver, logger);
	}
	
	String sportsXpath = "//header/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[4]";
	
	@FindBy(xpath="//header/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[4]")
	public WebElement sportsTab;
	
	//To select Sports tab from page
	public SportsPage searchSports()
	{
		try {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		waitLoad(1, 30, sportsXpath);
		sportsTab.click();
		logger.log(Status.PASS, "Clicked on Sports tab successfully");
		}
		catch (Exception e) 	
		{
		reportFail(e.getMessage());
		}
		
		SportsPage sportsPage=new SportsPage(driver,logger);
		PageFactory.initElements(driver, sportsPage);
		return sportsPage;
	}

}
