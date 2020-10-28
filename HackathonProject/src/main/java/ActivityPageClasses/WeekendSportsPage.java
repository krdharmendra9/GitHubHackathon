package ActivityPageClasses;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClasses.PageBaseClass;

public class WeekendSportsPage extends PageBaseClass
{
	public WeekendSportsPage(WebDriver driver, ExtentTest logger) 
	{
		super(driver, logger);
	}

	
	@FindBy(xpath="//body/div[@id='super-wrapper']/div[@id='super-container']/div[2]/div[4]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]")
	public WebElement priceDropdown;
	@FindBy(xpath = "//body/div[@id='super-wrapper']/div[@id='super-container']/div[2]/div[4]/div[1]/div[1]/div[2]/div[4]/div[2]/div[1]/div[2]/div[1]/div[1]")
	public WebElement selectFree;  
	
	String priceXpath = "//body/div[@id='super-wrapper']/div[@id='super-container']/div[2]/div[4]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]";
	String freeXpath = "//body/div[@id='super-wrapper']/div[@id='super-container']/div[2]/div[4]/div[1]/div[1]/div[2]/div[4]/div[2]/div[1]/div[2]/div[1]/div[1]";
	
	
	public PriceSportsPage addPriceFilter() throws InterruptedException
	{
		try {
		String currentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
		    if (!window.equals(currentWindow)) {
		        driver.switchTo().window(window);
		    }
		}
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		waitLoad(1, 30, priceXpath);
		
		priceDropdown.click();
		
		waitLoad(1, 30, freeXpath);
		
		selectFree.click();
		
		logger.log(Status.PASS, "Selected 'Free' price successfully");
		}
		catch (Exception e) 	
		{
		reportFail(e.getMessage());
		}
		
		PriceSportsPage priceSportsPage = new PriceSportsPage(driver,logger);
		PageFactory.initElements(driver, priceSportsPage);
		return priceSportsPage;   
	}


}
