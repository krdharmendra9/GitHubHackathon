package SignInPageClasses;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClasses.PageBaseClass;

public class LocationPage extends PageBaseClass
{

	public LocationPage(WebDriver driver, ExtentTest logger) 
	{
		super(driver, logger);
	}
	
	String parentWindow = driver.getWindowHandle();
	
	 @FindBy(xpath="//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]")
	 public WebElement nextButton;
	 
	String emailErrorText;
	
	public void signIn1(String email) throws InterruptedException
	{
	try {
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//div[contains(text(),'Sign in')]")).click();
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//body/div[@id='modal-root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]")).click();
	
	Thread.sleep(5000);
	
    WebDriverWait wait = new WebDriverWait(driver,5);
    wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    Set<String> s1 = driver.getWindowHandles();
    Iterator<String> i1 = s1.iterator();
    
    while(i1.hasNext())
    {
        String next_tab = i1.next();
        if (!parentWindow.equalsIgnoreCase(next_tab))
        {
        driver.switchTo().window(next_tab);
        //System.out.println("Switching to child window...");
        WebDriverWait wait2 = new WebDriverWait(driver, 20);
        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='identifierId']"))).sendKeys(email);
        
        nextButton.click();
        
        emailErrorText=driver.findElement(By.xpath
        		("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/span[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]")).getText().toString();
        
        }
    }
    
    System.out.println("The returned error message is: " +emailErrorText);
    logger.log(Status.PASS, "Printed error message successfully");
	}
    catch (Exception e) 	
	{
	reportFail(e.getMessage());
	}

	}
	
	public void signIn2(String phone) throws InterruptedException
	{
		try {
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[contains(text(),'Sign in')]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//body/div[@id='modal-root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]")).click();
		
		Thread.sleep(5000);
		
	    WebDriverWait wait = new WebDriverWait(driver,5);
	    wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	    Set<String> s1 = driver.getWindowHandles();
	    Iterator<String> i1 = s1.iterator();
	    
	    while(i1.hasNext())
	    {
	        String next_tab = i1.next();
	        if (!parentWindow.equalsIgnoreCase(next_tab))
	        {
	        driver.switchTo().window(next_tab);
	        //System.out.println("Switching to child window...");
	        WebDriverWait wait2 = new WebDriverWait(driver, 20);
	        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='identifierId']"))).sendKeys(phone);
	        
	        nextButton.click();
	        
	        Thread.sleep(3000);
	        
	        emailErrorText=driver.findElement(By.xpath
	        		("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/span[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]")).getText().toString();
	        
	        }
	    }
	    
	    System.out.println("The returned error message is: " +emailErrorText);
	    logger.log(Status.PASS, "Printed error message successfully");
		}
	    catch (Exception e) 	
		{
		reportFail(e.getMessage());
		}

		}   

	
	
	public void signIn3(String email) throws InterruptedException
	{
		try {
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[contains(text(),'Sign in')]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//body/div[@id='modal-root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]")).click();
		
		Thread.sleep(5000);
		
	    WebDriverWait wait = new WebDriverWait(driver,5);
	    wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	    Set<String> s1 = driver.getWindowHandles();
	    Iterator<String> i1 = s1.iterator();
	    
	    while(i1.hasNext())
	    {
	        String next_tab = i1.next();
	        if (!parentWindow.equalsIgnoreCase(next_tab))
	        {
	        driver.switchTo().window(next_tab);
	        //System.out.println("Switching to child window...");
	        Thread.sleep(1000);
	        
	        nextButton.click();
	        
	        Thread.sleep(3000);
	        
	        emailErrorText=driver.findElement(By.xpath
	        		("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/span[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]")).getText().toString();
	        
	        }
	    }
	    
	    System.out.println("The returned error message is: " +emailErrorText);
	    logger.log(Status.PASS, "Printed error message successfully");
		}
	    catch (Exception e) 	
		{
		reportFail(e.getMessage());
		}

		}    
	       
	
	public void signIn4(String email, String password) throws InterruptedException
	{
		try {
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[contains(text(),'Sign in')]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//body/div[@id='modal-root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]")).click();
		
		Thread.sleep(5000);
		
	    WebDriverWait wait = new WebDriverWait(driver,5);
	    wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	    Set<String> s1 = driver.getWindowHandles();
	    Iterator<String> i1 = s1.iterator();
	    
	    while(i1.hasNext())
	    {
	        String next_tab = i1.next();
	        if (!parentWindow.equalsIgnoreCase(next_tab))
	        {
	        driver.switchTo().window(next_tab);
	        //System.out.println("Switching to child window...");
	        WebDriverWait wait2 = new WebDriverWait(driver, 20);
	        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='identifierId']"))).sendKeys(email);
	        
	        nextButton.click();
	        
	        Thread.sleep(3000);
	        
	        WebDriverWait wait3 = new WebDriverWait(driver, 20);
	        wait3.until(ExpectedConditions.elementToBeClickable
	        		(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/span[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))).sendKeys(password);
	        
	        nextButton.click();
	        
	        Thread.sleep(3000);
	        
	        emailErrorText=driver.findElement(By.xpath
	        ("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/span[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[2]")).getText().toString();
	        
	        }
	    }
	    
	    System.out.println("The returned error message is: " +emailErrorText);
	    logger.log(Status.PASS, "Printed error message successfully");
		}
	    catch (Exception e) 	
		{
		reportFail(e.getMessage());
		}
	
}
	
	
}
