package Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.math3.analysis.function.Ceil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExel {
		public void readExcelFile(List<RegistrationData> lst,String fileName)
		{
			FileInputStream f = null;
			XSSFWorkbook workbook = null;
			try {
				f = new FileInputStream(fileName);
				workbook = new XSSFWorkbook(f);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			
			XSSFSheet sheet =  workbook.getSheetAt(0);
			Iterator<Row> rowIterator =  sheet.rowIterator();
			
			// Skip the headers row
			rowIterator.next();

			while(rowIterator.hasNext())
			{
				RegistrationData newRegistrationData = new RegistrationData();
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator =  row.cellIterator();
				
				Cell cell=null;
				
				// first name			
				cell = cellIterator.next();
				String vallueCell=cell.getStringCellValue();
				newRegistrationData.setFirstName(checkString(vallueCell));
			

				// last name
				cell = cellIterator.next();
				vallueCell=cell.getStringCellValue();
				newRegistrationData.setLastName(checkString(vallueCell));

					
				// birth
				//cell = cellIterator.next();
				//newRegistrationData.setBirthDate(cell.getStringCellValue());
				
				// phone
				cell = cellIterator.next();
				vallueCell=cell.getStringCellValue();
				newRegistrationData.setPhone(checkString(vallueCell));


				// email
				cell = cellIterator.next();
				vallueCell=cell.getStringCellValue();
				newRegistrationData.setEmail(checkString(vallueCell));


				// password
				cell = cellIterator.next();
				vallueCell=cell.getStringCellValue();
				newRegistrationData.setPassword(checkString(vallueCell));
			

				// confirm password
				cell = cellIterator.next();
				vallueCell=cell.getStringCellValue();
				newRegistrationData.setConfirmPassword(checkString(vallueCell));			
				
				cell = cellIterator.next();
				vallueCell=cell.getStringCellValue();
				newRegistrationData.setStringErr(checkString(vallueCell));

				System.out.println(newRegistrationData); 
				System.out.println("\n--------------------\n");
				lst.add(newRegistrationData);
			}		
			try {
				f.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	public void readExcelFile1(List<LoginData> lst,String fileName)
	{
		FileInputStream f = null;
		XSSFWorkbook workbook = null;
		try {
			f = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet =  workbook.getSheetAt(1);
		Iterator<Row> rowIterator =  sheet.rowIterator();
		
		// Skip the headers row
		rowIterator.next();

		while(rowIterator.hasNext())
		{
			LoginData newLoginData = new LoginData();
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator =  row.cellIterator();
			String vallueCell;
			Cell cell=null;

			// email
			cell = cellIterator.next();
			vallueCell=cell.getStringCellValue();
			newLoginData.setEmail(checkString(vallueCell));


			// password
			cell = cellIterator.next();
			vallueCell=cell.getStringCellValue();
			newLoginData.setPassword(checkString(vallueCell));
				
			//ErrString
			cell = cellIterator.next();
			vallueCell=cell.getStringCellValue();
			newLoginData.setStringErr(checkString(vallueCell));

			System.out.println(newLoginData); 
			System.out.println("\n--------------------\n");
			lst.add(newLoginData);
		}		
		try {
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void readExcelFile2(List<String> lst,String fileName)
	{
		FileInputStream f = null;
		XSSFWorkbook workbook = null;
		try {
			f = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet =  workbook.getSheetAt(2);
		Iterator<Row> rowIterator =  sheet.rowIterator();
	
		// Skip the headers row
		rowIterator.next();

		while(rowIterator.hasNext())
		{
			
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator =  row.cellIterator();
			String vallueCell;
			Cell cell=null;
			cell = cellIterator.next();
			vallueCell=cell.getStringCellValue();
			lst.add(vallueCell);
		}		
		try {
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	String checkString(String str)
	{
		String str1=str;;
		if (str.equals("null"))
		{
			 str1="";
		}
		if(str.contains("'"))
		{
			str1=str.substring(1, str.length()-1);
		}
		return str1;
	}
}
	


