package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BaseClasses.BaseTestClass;
import BaseClasses.PageBaseClass;
import MoviePageClasses.ComingSoonPage;
import MoviePageClasses.LandingPage;
import MoviePageClasses.LocationPage;
import MoviePageClasses.MovieLanguagePage;


public class MovieTestApp extends BaseTestClass
{
	LandingPage landingPage;
	LocationPage locationPage;
	ComingSoonPage comingSoonPage;
	MovieLanguagePage movieLanguagePage;
	
	@Test(groups={"Regression", "MovieTest_Chrome_Mumbai" })
	public void testMovie1() throws InterruptedException
	{
		invokeBrowser(1);   //runs on Chrome
	
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenWebsite1();
		
		landingPage.cancelPopup();
		landingPage.selectPopularCity("Mumbai");

	}
	
	@Test(groups={"Regression", "MovieTest_Opera_Chennai" })
	public void testMovie2() throws InterruptedException
	{
		invokeBrowser(3);   //runs on Opera
	
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenWebsite1();
		
		landingPage.cancelPopup();
		landingPage.selectPopularCity("Chennai");
		
	}
	
	@Test(groups={"Regression", "MovieTest_Edge_Pune" })
	public void testMovie3() throws InterruptedException
	{
		invokeBrowser(4);    //runs on Edge
	
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenWebsite1();
		
		landingPage.cancelPopup();
		landingPage.selectPopularCity("Pune");
		
	}
	
	@Test(groups={"Regression", "MovieTest_Firefox_SearchAnyCity" })
	public void testMovie4() throws InterruptedException
	{
		invokeBrowser(2);    //runs on Firefox
	
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenWebsite1();
		
		landingPage.cancelPopup();
		landingPage.enterCity("city_");  //using projectConfig.properties to get city
		
	}  
	
	
	@Test(groups={"Smoke", "MovieTest_Chrome_Mumbai" })
	public void testMovie5() throws InterruptedException
	{
		invokeBrowser(1);    //runs on Chrome
	
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenWebsite1();
		
		landingPage.cancelPopup();
		locationPage=landingPage.selectPopularCity("Mumbai");
		
		comingSoonPage = locationPage.clickonMovies();
		movieLanguagePage=comingSoonPage.clickonComingSoon();
		
		Thread.sleep(1000);
		pageBase.captureScreenshot();
		movieLanguagePage.printMovieLanguages();

	}  
	
	@Test(groups={"Smoke", "MovieTest_Edge_SearchAnyCity" })
	public void testMovie6() throws InterruptedException
	{
		invokeBrowser(4);    //runs on Edge
	
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenWebsite1();
		
		landingPage.cancelPopup();
		locationPage=landingPage.enterCity("city_");			//using projectConfig.properties to get city
		
		comingSoonPage = locationPage.clickonMovies();
		movieLanguagePage=comingSoonPage.clickonComingSoon();
		
		movieLanguagePage.printMovieLanguages();

	}  
	
	@Test(groups={"Smoke", "MovieTest_Opera_SearchAnyCity" })
	public void testMovie7() throws InterruptedException
	{
		invokeBrowser(3);    //runs on Opera
	
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenWebsite1();
		
		landingPage.cancelPopup();
		locationPage=landingPage.enterCity("city_");			//using projectConfig.properties to get city
		
		comingSoonPage = locationPage.clickonMovies();
		movieLanguagePage=comingSoonPage.clickonComingSoon();
		
		Thread.sleep(1000);
		pageBase.captureScreenshot();
		movieLanguagePage.printMovieLanguages();

	}   
}
