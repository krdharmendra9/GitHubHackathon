package Utilities;

import java.util.Date;

public class DateUtil 
{
	//To get Time Stamp for each report generated
	public static String getTimeStamp()
	{
		Date date = new Date();
		return date.toString().replaceAll(":", "_").replaceAll(" ", "_");
	}	

}
