package genericutilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelfileutility {
	
	
	public String readdatafromexcelfile(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis1 = new FileInputStream("C:\\Users\\SABARI\\eclipse-workspace\\E32_NINZA_CRM\\src\\test\\resources\\mandatoryfieldsexcelTest.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
	 String data = wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
	 wb.close();
	 return data;
		
	}
	public int getrowcount(String sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fis1 = new FileInputStream("C:\\Users\\SABARI\\eclipse-workspace\\E32_NINZA_CRM\\src\\test\\resources\\mandatoryfieldsexcelTest.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		int rowcount = wb.getSheet(sheetname).getLastRowNum();
		wb.close();
		return rowcount;
	}

}
