package MoviePageClasses;

import org.openqa.selenium.JavascriptExecutor;
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
	

	@FindBy(xpath="//a[contains(text(),'Movies')]")
	public WebElement movieTab;
	
	String movieXpath="//a[contains(text(),'Movies')]";
	
	public ComingSoonPage clickonMovies() throws InterruptedException
	{
		try {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500)");
		
		waitLoad(1, 30, movieXpath);
		movieTab.click();
		
		logger.log(Status.PASS, "Selected 'Movies' tab successfully");
		}
		catch (Exception e) 	
		{
		reportFail(e.getMessage());
		}
	
	ComingSoonPage comingSoonPage=new ComingSoonPage(driver,logger);
	PageFactory.initElements(driver, comingSoonPage);
	return comingSoonPage;   

	
	}
}
