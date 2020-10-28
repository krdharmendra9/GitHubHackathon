package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;


public class ExtentReportManager {
		
		public static ExtentReports report;                //creates html report
	    public static ExtentHtmlReporter htmlReporter;  	//design html report
		
		public static ExtentReports getReportInstance()
		{
			//check if the report & its designer is null
			if(report == null)
			{
				String reportName = DateUtil.getTimeStamp() + ".html";
				ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" + reportName);
				
				//if both are null then initialize the objects
				report =  new ExtentReports();
				report.attachReporter(htmlReporter);
				
				//sets the following properties in the html report 
				report.setSystemInfo("OS", "Windows 10");
				report.setSystemInfo("Environment", "UAT");
				report.setSystemInfo("Build Number", "10.8.1");
				report.setSystemInfo("Browser", "Chrome");
				
				//designas the report by adding title,name,timestamp etc.
				htmlReporter.config().setDocumentTitle("UAT UI Automation Results");
				htmlReporter.config().setReportName("All Headlines UI Test Report");
				htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
				htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
			}
			
			return report;
		}

}

