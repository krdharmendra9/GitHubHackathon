package Utilities;

import java.util.Hashtable;

public class TestDataProvider 
{
	/*
	@Test(dataProvider="getTestData")        //getTestData() will provide test data for this particular test case
	public void sampleTestOne(Hashtable<String, String> table)  {
		System.err.println(table.get("Col2 "));
	}
	*/
	
	//Object[] dataSet = new Object[rows][columns]    - 2 dimensional array that gives the dataset for a defined no of rows and columns

	/************** Retrieves Data for TestCase ******************/
	
	public static Object[][] getTestData(String DataFileName, String SheetName, String TestName) 
	{

		ReadExcel readdata = new ReadExcel(
				System.getProperty("user.dir") + "/TestData/" + DataFileName);
		String sheetName = SheetName;
		String testName = TestName;

		// Find Start Row of TestCase
		int startRowNum = 0;
		while (!readdata.getCellData(sheetName, 0, startRowNum).equalsIgnoreCase(testName)) {
			startRowNum++;
		}
		
		int startTestColumn = startRowNum + 1;
		int startTestRow = startRowNum + 2;

		// Find Number of Rows of TestCase
		int rows = 0;
		while (!readdata.getCellData(sheetName, 0, startTestRow + rows).equals("")) {
			rows++;
		}
		
		// Find Number of Columns in Test
		int colmns = 0;
		while (!readdata.getCellData(sheetName, colmns, startTestColumn).equals("")) {
			colmns++;
		}
		
		//Define Two Object Array
		Object[][] dataSet = new Object[rows][1];
		Hashtable<String, String> dataTable = null;
		int dataRowNumber=0;
		for (int rowNumber = startTestRow; rowNumber <= startTestColumn + rows; rowNumber++) {
			dataTable = new Hashtable<String, String>();
			for (int colNumber = 0; colNumber < colmns; colNumber++) {
				String key = readdata.getCellData(sheetName, colNumber, startTestColumn);
				String value = readdata.getCellData(sheetName, colNumber, rowNumber);
				dataTable.put(key, value);
				//dataSet[dataRowNumber][colNumber]=readdata.getCellData(sheetName, colNumber, rowNumber);  ->cell data is retrieved from the particular column and filled in 'dataset' array
				//00,01,02,03    ->1st iteration for : 0th row-0th col, 0th row-1st col, 0th row-2nd col and so on
				//10,11,12		 ->2nd iteration for : 1st row-0th col, 1st row-1st col, 1st row-2nd col and so on
			}
			dataSet[dataRowNumber][0]=dataTable;
			dataRowNumber++;    //after iteration, increment row number, so the loop will start retrieving data from cols of the next row
		}
	 return dataSet;
	}
}


