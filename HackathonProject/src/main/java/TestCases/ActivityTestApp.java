package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.*;

import ActivityPageClasses.LandingPage;
import ActivityPageClasses.LocationPage;
import ActivityPageClasses.PriceSportsPage;
import ActivityPageClasses.SportsPage;
import ActivityPageClasses.WeekendSportsPage;
import BaseClasses.BaseTestClass;
import BaseClasses.PageBaseClass;

public class ActivityTestApp extends BaseTestClass
{
	LandingPage landingPage;
	LocationPage locationPage;
	SportsPage sportsPage;
	WeekendSportsPage weekendSportsPage;
	PriceSportsPage priceSportsPage;
	
	public Properties prop;
	
	
	@Test(groups={"Regression", "ActivityTest_Chrome_Mumbai" })
	public void testActivity1() throws InterruptedException
	{
		invokeBrowser(1);   //runs on Chrome
	
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenWebsite();
		
		landingPage.cancelPopup();
		landingPage.selectPopularCity("Mumbai");
		
	}
	
	@Test(groups={"Regression", "ActivityTest_Firefox_Chennai" })
	public void testActivity2() throws InterruptedException
	{
		invokeBrowser(2);   //runs on FireFox
	
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenWebsite();
		
		landingPage.cancelPopup();
		landingPage.selectPopularCity("Chennai");
		
	}
	
	@Test(groups={"Regression", "ActivityTest_Edge_Pune" })
	public void testActivity3() throws InterruptedException
	{
		invokeBrowser(4);    //runs on Edge
	
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenWebsite();
		
		landingPage.cancelPopup();
		landingPage.selectPopularCity("Pune");
		
	}
	
	@Test(groups={"Regression", "ActivityTest_Opera_SearchAnyCity" })
	public void testActivity4() throws InterruptedException
	{
		invokeBrowser(3);    //runs on Opera
	
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenWebsite();
		
		landingPage.cancelPopup();
		landingPage.enterCity("city_");  //using projectConfig.properties to get city
		
	}   
	
	
	@Test(groups={"Smoke", "ActivityTest_Chrome_Mumbai" })
	public void testActivity5() throws InterruptedException
	{
		invokeBrowser(1);    //runs on Chrome
	
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenWebsite();
		
		landingPage.cancelPopup();
		locationPage=landingPage.selectPopularCity("Mumbai");
		
		sportsPage = locationPage.searchSports();
		weekendSportsPage=sportsPage.addDateFilter();
		priceSportsPage=weekendSportsPage.addPriceFilter();
		
		priceSportsPage.activityDetails();
		
	}  
	
	@Test(groups={"Smoke", "ActivityTest_Edge_Pune" })
	public void testActivity6() throws InterruptedException
	{
		invokeBrowser(4);    //runs on Edge
	
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenWebsite();
		
		landingPage.cancelPopup();
		locationPage = landingPage.selectPopularCity("Pune");
		
		sportsPage = locationPage.searchSports();
		weekendSportsPage=sportsPage.addDateFilter();
		priceSportsPage=weekendSportsPage.addPriceFilter();
		
		priceSportsPage.activityDetails();
		
	}  
	
	@Test(groups={"Smoke", "ActivityTest_Opera_SearchAnyCity" })
	public void testActivity7() throws InterruptedException
	{
		invokeBrowser(3);    //runs on Opera
	
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenWebsite();
		
		landingPage.cancelPopup();
		locationPage=landingPage.enterCity("city_");  //using projectConfig.properties to get city
		
		sportsPage = locationPage.searchSports();
		weekendSportsPage=sportsPage.addDateFilter();
		priceSportsPage=weekendSportsPage.addPriceFilter();
		
		priceSportsPage.activityDetails();
		
	}   
	
	

}
