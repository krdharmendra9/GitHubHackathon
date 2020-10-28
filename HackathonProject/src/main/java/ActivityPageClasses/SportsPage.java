package ActivityPageClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClasses.PageBaseClass;

public class SportsPage extends PageBaseClass
{
	public SportsPage(WebDriver driver, ExtentTest logger) 
	{
		super(driver, logger);
	}
		
	String dateFilterXpath ="//div[@class='style__CheckboxLabelWrapper-sc-133bvir-2 cnEUhV'][contains(text(),'This Weekend')]";
	
	@FindBy(xpath="//div[@class='style__CheckboxLabelWrapper-sc-133bvir-2 cnEUhV'][contains(text(),'This Weekend')]")
	public WebElement dateFilter;
	
	
	public WeekendSportsPage addDateFilter() throws InterruptedException
	{
		try {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	
		waitLoad(1, 10, dateFilterXpath);
		//WebElement dateFilter = driver.findElement(By.xpath(dateFilterXpath));
		
		dateFilter.click();
		//retryingFindClick(xp);
		logger.log(Status.PASS, "Selected 'This Weekend' successfully");
		}
		catch (Exception e) 	
		{
		reportFail(e.getMessage());
		}
		
		WeekendSportsPage weekendSportsPage=new WeekendSportsPage(driver,logger);
		PageFactory.initElements(driver, weekendSportsPage);
		return weekendSportsPage;
		
	}

}
