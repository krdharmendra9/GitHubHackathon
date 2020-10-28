package BaseClasses;

import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utilities.ExtentReportManager;

public class BaseTestClass {

	public WebDriver driver;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;

	
	/****************** Invoke Browser ***********************/
	public void invokeBrowser(int browserNum)
	{
		
		logger=report.createTest("testApplication");
	
	try {
	//creating drivers for each browser corresponding to user input
		//Integers for selecting desired browser to run test 
				/*		1 for Google Chrome
						2 for Mozilla Firefox
						3 for Opera
						4 for Microsoft Edge       */
	switch(browserNum)
	{
	case 1: System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
			driver=new ChromeDriver(); 
			break;
	case 2: System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver.exe"); 
    		//DesiredCapabilities cap = DesiredCapabilities.firefox();  
    		//cap.setCapability("marionette",true);  
			driver = new FirefoxDriver();
    		break;
	case 3:	System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/operadriver.exe");
			driver = new OperaDriver();
			break;
	case 4: System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/msedgedriver.exe");
			driver = new EdgeDriver();
			break;
	default:
	}  
	}
	catch (Exception e) 
	{
		// reportFail(e.getMessage());
		System.out.println(e.getMessage());
	}
	
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	}


	@AfterMethod
	public void flushReports() 
	{
		report.flush();
		driver.quit();
	}
	
	/***************** If WebElement to be clicked cannot be found *****************/
	public boolean retryingFindClick(By by) {
	    boolean result = false;
	    int attempts = 0;
	    while(attempts < 2) {
	        try {
	            driver.findElement(by).click();
	            result = true;
	            break;
	        } catch(StaleElementReferenceException e) {
	        }
	        attempts++;
	    }
	    return result;
	}    
	
	/***************** Select Date From Calendar *****************/
	public void selectDateIncalendar(String date) {

		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date expectedDate = dateFormat.parse(date);

			String day = new SimpleDateFormat("dd").format(expectedDate);
			String month = new SimpleDateFormat("MMMM").format(expectedDate);
			String year = new SimpleDateFormat("yyyy").format(expectedDate);

			String expectedMonthYear = month + " " + year;

			while (true) {
				String displayDate = driver.findElement(By.className("dpTitleText")).getText();

				if (expectedMonthYear.equals(displayDate)) {

					driver.findElement(By.xpath("//td[text()= '" + day + "']")).click();

					break;
				} else if (expectedDate.compareTo(currentDate) > 0) {
					driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[4]/button")).click();
				} else {
					driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[2]/button")).click();
				}

			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	/***************** Wait Functions in Framework *****************/
	public void waitForPageLoad() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		int i = 0;
		while (i != 180) {
			String pageState = (String) js.executeScript("return document.readyState;");
			if (pageState.equals("complete")) {
				break;
			} else {
				//waitLoad(1);
			}
		}

		//waitLoad(2);

		i = 0;
		while (i != 180) {
			Boolean jsState = (Boolean) js.executeScript("return window.jQuery != undefined && jQuery.active == 0;");
			if (jsState) {
				break;
			} else {
				//waitLoad(1);
			}
		}
	}

	public void waitLoad(int i, int waitsec, String xpath) {
		try {
			Thread.sleep(i * 1000);
			
			WebDriverWait wait = new WebDriverWait(driver, waitsec);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public Properties initializeProperties(Properties prop)
	{
		//check if Properties file is define
		if(prop==null)
		{
			prop = new Properties();    //initializing 'prop' instance
			
			//to return path of the current project directory
			try
			{
				FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
						+"/src/test/resources/ObjectRepository/projectConfig.properties");  //append dynamic path of properties file
						//double slash for Windows dynamic path and single slash for Mac dynamic path
				
				prop.load(fis);  //loads the Properties file specified in the InputStream object above
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}  
			
		}
		return prop;
	}
	
	
}



