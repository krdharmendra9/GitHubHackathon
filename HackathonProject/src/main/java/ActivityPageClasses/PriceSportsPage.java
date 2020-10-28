package ActivityPageClasses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClasses.PageBaseClass;

public class PriceSportsPage extends PageBaseClass
{
	
	public PriceSportsPage(WebDriver driver, ExtentTest logger) 
	{
		super(driver, logger);
	}

	int k=3;
	List<WebElement> nameList;
	String activityXpath="//body/div[@id='super-wrapper']/div[@id='super-container']/div[2]/div[4]/div[2]/div";
	public void listOfActivities()
	{
		for(int i=3;i<=6;i++)
		{
			nameList=driver.findElements(By.xpath(activityXpath + "["+i+"]/div[1]/div[2]/a"));
		}
	}
	
	String actDateXpath="//*[@id=\"app\"]/div/div/div/div/div[2]/div/header/div/div/div[2]/div/div/div[1]/div/div";
	String actNameXpath = "//*[@id=\"app\"]/div/div/div/div/div[2]/div/header/div/div/div[1]/div[1]/div[1]/h1";   
	
	String actName;
	String actDate;
	ArrayList<String> dateList1 = new ArrayList<String>();
	ArrayList<String>nameList1 = new ArrayList<String>();
	
	WebElement activity;
	
	public void activityDetails() throws InterruptedException
	{
		try 
		{
		while(k<=6)
		{
				for(int j=1;j<=4;j++)
				{
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,500)");
					
					activity= driver.findElement(By.xpath(activityXpath+ "["+k+"]/div[1]/div[2]/a"+"["+j+"]"));
					WebDriverWait wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(activityXpath+ "["+k+"]/div[1]/div[2]/a"+"["+j+"]")));
					
					activity.click();
					
					Thread.sleep(3000);
					
					js.executeScript("window.scrollBy(0,500)");
					
					//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					//driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				
					Thread.sleep(1000);
			     	
					WebDriverWait wait1 = new WebDriverWait(driver, 30);
					wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(actNameXpath)));
					
					actName = driver.findElement(By.xpath(actNameXpath)).getText().toString();
					nameList1.add(actName);
					actDate = driver.findElement(By.xpath(actDateXpath)).getText().toString();
					dateList1.add(actDate);
					
					Thread.sleep(1000);
					
					driver.navigate().back();
					
					js.executeScript("window.scrollBy(0,500)");
				}
			captureScreenshot();
			k++;
		}
			
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			
			Thread.sleep(1000);
			
			Iterator<String> iter1 = nameList1.iterator();
			Iterator<String> iter2 = dateList1.iterator();
			
			while(iter1.hasNext() && iter2.hasNext())
			{
				Thread.sleep(1000);
				System.out.println(iter1.next());
				System.out.println(iter2.next());
				System.out.println();
			}
				
		logger.log(Status.PASS, "Printed all Sports activities details successfully");		
	}
	catch (Exception e) 	
	{
	reportFail(e.getMessage());
	}
	}
}