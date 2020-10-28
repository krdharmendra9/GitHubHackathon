package ActivityPageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import java.util.*;

import BaseClasses.PageBaseClass;

public class LandingPage extends PageBaseClass
{
	
	public LandingPage(WebDriver driver, ExtentTest logger)
	{
		super(driver, logger);   //will call constructor of parent class - PageBaseClass
	}

	public Properties prop;
	
	@FindBy(xpath = "//button[@id='wzrk-cancel']")   // //*[@id=\"wzrk-cancel\"]
	public WebElement popupX;
	
	public void cancelPopup()
	{
		logger.log(Status.INFO, "Clicking the 'Not Now' button in Popup");
		popupX.click();
		logger.log(Status.PASS, "Cancelled Personalized Updates Popup");
	}
	
	@FindBy(xpath = "//body/div[@id='modal-root']/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/img[1]")    	// //*[@id=\"modal-root\"]/div/div/div/div[2]/ul/li[1]/div/div/img
	public WebElement mum;
	@FindBy(xpath = "//body/div[@id='modal-root']/div[1]/div[1]/div[1]/div[2]/ul[1]/li[2]/div[1]/div[1]/img[1]")		// //*[@id=\"modal-root\"]/div/div/div/div[2]/ul/li[2]/div[1]/div/img
	public WebElement ncr;
	@FindBy(xpath = "//body/div[@id='modal-root']/div[1]/div[1]/div[1]/div[2]/ul[1]/li[3]/div[1]/div[1]/img[1]")		// //*[@id="modal-root"]/div/div/div/div[2]/ul/li[3]/div/div/img
	public WebElement beng;
	@FindBy(xpath = "//body/div[@id='modal-root']/div[1]/div[1]/div[1]/div[2]/ul[1]/li[4]/div[1]/div[1]/img[1]")		// //*[@id="modal-root"]/div/div/div/div[2]/ul/li[4]/div/div/img
	public WebElement hyd;
	@FindBy(xpath = "//body/div[@id='modal-root']/div[1]/div[1]/div[1]/div[2]/ul[1]/li[5]/div[1]/div[1]/img[1]")		// //*[@id="modal-root"]/div/div/div/div[2]/ul/li[5]/div/div/img
	public WebElement ahm;
	@FindBy(xpath = "//body/div[@id='modal-root']/div[1]/div[1]/div[1]/div[2]/ul[1]/li[6]/div[1]/div[1]/img[1]")		// //*[@id="modal-root"]/div/div/div/div[2]/ul/li[6]/div[1]/div/img
	public WebElement chnd;
	@FindBy(xpath = "//body/div[@id='modal-root']/div[1]/div[1]/div[1]/div[2]/ul[1]/li[7]/div[1]/div[1]/img[1]")		// //*[@id="modal-root"]/div/div/div/div[2]/ul/li[7]/div/div/img
	public WebElement chen;
	@FindBy(xpath = "//body/div[@id='modal-root']/div[1]/div[1]/div[1]/div[2]/ul[1]/li[8]/div[1]/div[1]/img[1]")		// //*[@id="modal-root"]/div/div/div/div[2]/ul/li[8]/div/div/img
	public WebElement pune;
	@FindBy(xpath = "//body/div[@id='modal-root']/div[1]/div[1]/div[1]/div[2]/ul[1]/li[9]/div[1]/div[1]/img[1]")		// //*[@id="modal-root"]/div/div/div/div[2]/ul/li[9]/div/div/img
	public WebElement kolk;
	@FindBy(xpath = "//body/div[@id='modal-root']/div[1]/div[1]/div[1]/div[2]/ul[1]/li[10]/div[1]/div[1]/img[1]")		// //*[@id="modal-root"]/div/div/div/div[2]/ul/li[10]/div/div/img
	public WebElement kochi;
	
	public LocationPage selectPopularCity(String city)
	{
		try {
			if (city.equalsIgnoreCase("Mumbai"))
				mum.click();
			else if (city.equalsIgnoreCase("NCR"))
				ncr.click();
			else if (city.equalsIgnoreCase("Bengaluru"))
				beng.click();
			else if (city.equalsIgnoreCase("Hyderabad"))
				hyd.click();
			else if (city.equalsIgnoreCase("Ahmedabad"))
				ahm.click();
			else if (city.equalsIgnoreCase("Chandigarh"))
				chnd.click();
			else if (city.equalsIgnoreCase("Chennai"))
				chen.click();
			else if (city.equalsIgnoreCase("Pune"))
				pune.click();
			else if (city.equalsIgnoreCase("Kolkata"))
				kolk.click();
			else if (city.equalsIgnoreCase("Kochi"))
				kochi.click();
		
			logger.log(Status.PASS, "Selected Popular City successfully");
		}
		catch (Exception e) 	
		{
		reportFail(e.getMessage());
		}

		
		LocationPage locationPage = new LocationPage(driver, logger);
		PageFactory.initElements(driver, locationPage);
		return locationPage;   //returns next page object
	}
	
	@FindBy(xpath="//body/div[@id='modal-root']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")   // //*[@id=\"modal-root\"]/div/div/div/div[1]/div/div/input
	public WebElement searchBox;
	
	public LocationPage enterCity(String cityKey)
	{
		try {
		prop=initializeProperties(prop);
		logger.log(Status.INFO, "Entering city in searchbox");
		searchBox.sendKeys(prop.getProperty(cityKey)+ "\n"); 
		
		logger.log(Status.PASS, "Entered City successfully");
		}
		catch (Exception e) 	
		{
		reportFail(e.getMessage());
		}
		LocationPage locationPage = new LocationPage(driver, logger);
		PageFactory.initElements(driver, locationPage);           
		return locationPage;    //returns next page object
	}
	
	
	
}
