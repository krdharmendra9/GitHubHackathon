package MoviePageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClasses.PageBaseClass;

public class ComingSoonPage extends PageBaseClass
{
	public ComingSoonPage(WebDriver driver, ExtentTest logger) 
	{
		super(driver, logger);
	}
	
	String comingSoonXpath="//body/div[@id='super-wrapper']/div[@id='super-container']/div[2]/div[4]/div[2]/div[2]/div[1]/div[2]/a[1]/div[1]/div[2]/div[1]";
							
	@FindBy(xpath = "//body/div[@id='super-wrapper']/div[@id='super-container']/div[2]/div[4]/div[2]/div[2]/div[1]/div[2]/a[1]/div[1]/div[2]/div[1]")
	public WebElement comingTab;
	
	public MovieLanguagePage clickonComingSoon() throws InterruptedException
	{
		try {
		waitLoad(1, 30, comingSoonXpath);
		comingTab.click();
		
		logger.log(Status.PASS, "Selected 'Movies' tab successfully");
		}
		catch (Exception e) 	
		{
		reportFail(e.getMessage());
		}
		MovieLanguagePage movieLanguagePage=new MovieLanguagePage(driver,logger);
		PageFactory.initElements(driver, movieLanguagePage);
		return movieLanguagePage;   
	}
}
