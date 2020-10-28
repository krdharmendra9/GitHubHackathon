package MoviePageClasses;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClasses.PageBaseClass;

public class MovieLanguagePage extends PageBaseClass
{
	public MovieLanguagePage(WebDriver driver, ExtentTest logger) 
	{
		super(driver, logger);
	}
	
	String langXpath ="//div[@class='style__StyledText-tgsgks-0 cAIFpf']";
	
	public void printMovieLanguages() throws InterruptedException
	{
		try {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		Thread.sleep(1000);
		
		List<WebElement> lang = driver.findElements(By.xpath(langXpath));
		Iterator<WebElement> iter = lang.iterator();
		
		System.out.println("Printing out all languages for available movies:");
		for(int i=0;i<lang.size();i++)  
		{
			System.out.println(iter.next().getText());
			System.out.println();
		}
		
		logger.log(Status.PASS, "Printed all languages successfully"); 
		}
		catch (Exception e) 	
		{
		reportFail(e.getMessage());
		}
	}

}
