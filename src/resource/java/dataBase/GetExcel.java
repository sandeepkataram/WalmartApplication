package dataBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetExcel 
{

	public List<String> get_user_Pass() throws Exception
	{
		int rowCount=getNoOfRows("Data");
		List<String> userPassword=new ArrayList<String>();
		for(int i=1;i<rowCount;i++)
		{
			
				userPassword.add(getCellValue(i, 0, "Data")+":"+getCellValue(i, 1, "Data"));
		}
		return userPassword;
		
	}
	public List<String> execution_Order() throws Exception
	{
		List<String> eOrder=new ArrayList<String>();
		int rowCount=getNoOfRows("testcases");
		for(int i=1;i<rowCount;i++)
		{
			if(getCellValue(i, 1, "testcases").toUpperCase().equals("Y"))
			{
				eOrder.add(getCellValue(i, 0, "testcases"));
			}
		}
		return eOrder;
		
	}
	
	String getCellValue(int row, int col, String sheet) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//resource//java//config//excel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet data_sheet = wb.getSheet(sheet);
		String cellValue=null;
		try
		{
		cellValue =data_sheet.getRow(row).getCell(col).toString();
		}catch (Exception NullPointerException) 
		{
			throw new Error("CellValue is Null at row="+row+" column="+col);
		}
		fis.close();
		return cellValue;
		
	}
	
	int getNoOfRows(String sheet) throws Exception
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//resource//java//config//excel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet ws = wb.getSheet(sheet);
		fis.close();
		return ws.getLastRowNum();
		
	}
	
/*public static void main(String[] args) throws Exception {
		GetExcel e=new GetExcel();
		System.out.println();
		System.out.println(e.getNoOfRows("testcases"));
	}*/

}
