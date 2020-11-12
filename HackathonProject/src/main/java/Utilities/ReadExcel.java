package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class ReadExcel 
{

		public String path;
		public FileInputStream fis = null;
		public FileOutputStream fileOut = null;
		private XSSFWorkbook workbook = null;
		private XSSFSheet sheet = null;
		private XSSFRow row = null;
		private XSSFCell cell = null;
		String valueAsSeenInExcel;

		/****************** Constructor ***********************/
		public ReadExcel(String path)    //path argument will be the path to the excel file we want this to read
		{

			this.path = path;
			try {
				fis = new FileInputStream(path);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheetAt(0);
				fis.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}

		}

		
		/****************** Returns the row count in a sheet ***********************/
		public int getRowCount(String sheetName) 
		{
			int index = workbook.getSheetIndex(sheetName);
			if (index == -1)
				return 0;
			else {
				sheet = workbook.getSheetAt(index);
				int number = sheet.getLastRowNum() + 1;
				return number;
			}

		}

		/****************** Returns the data from a cell ***********************/
		public String getCellData(String sheetName, String colName, int rowNum)     //gives cell data with column name as argument
		{
			try {
				if (rowNum <= 0)
					return "";

				int index = workbook.getSheetIndex(sheetName);
				int col_Num = -1;
				if (index == -1)
					return "";

				sheet = workbook.getSheetAt(index);
				row = sheet.getRow(0);
				for (int i = 0; i < row.getLastCellNum(); i++) {
					// System.out.println(row.getCell(i).getStringCellValue().trim());
					if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
						col_Num = i;
				}
				if (col_Num == -1)
					return "";

				sheet = workbook.getSheetAt(index);
				row = sheet.getRow(rowNum - 1);
				if (row == null)
					return "";
				cell = row.getCell(col_Num);

				if (cell == null)
					return "";
				// System.out.println(cell.getCellType());
				if (cell.getCellType() == Cell.CELL_TYPE_STRING)
					return cell.getStringCellValue();
				else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

					String cellText = String.valueOf(cell.getNumericCellValue());
					if (HSSFDateUtil.isCellDateFormatted(cell)) {
						// format in form of M/D/YY
						double d = cell.getNumericCellValue();

						Calendar cal = Calendar.getInstance();
						cal.setTime(HSSFDateUtil.getJavaDate(d));
						cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
						cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;

						// System.out.println(cellText);
						DataFormatter fmt = new DataFormatter();
						valueAsSeenInExcel = fmt.formatCellValue(cell);

					}

					return valueAsSeenInExcel;
				} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
					return "";
				else
					return String.valueOf(cell.getBooleanCellValue());

			} catch (Exception e) {

				e.printStackTrace();
				return "row " + rowNum + " or column " + colName + " does not exist in xls";
			}
		}


		/****************** Returns the data from a cell ***********************/
		public String getCellData(String sheetName, int colNum, int rowNum)      //overloaded function to get cell data with a different argument
		{
			try {
				if (rowNum <= 0)
					return "";

				int index = workbook.getSheetIndex(sheetName);

				if (index == -1)
					return "";

				sheet = workbook.getSheetAt(index);
				row = sheet.getRow(rowNum - 1);
				if (row == null)
					return "";
				cell = row.getCell(colNum);
				if (cell == null)
					return "";

				if (cell.getCellType() == Cell.CELL_TYPE_STRING)
					return cell.getStringCellValue();
				else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

					String cellText = String.valueOf(cell.getNumericCellValue());
					
					DataFormatter fmt = new DataFormatter();
					valueAsSeenInExcel = fmt.formatCellValue(cell);

					return valueAsSeenInExcel;
				} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
					return "";
				else
					return String.valueOf(cell.getBooleanCellValue());
			} catch (Exception e) {

				e.printStackTrace();
				return "row " + rowNum + " or column " + colNum + " does not exist  in xls";
			}
		}

		

		
		
		
		
		

		

	}



