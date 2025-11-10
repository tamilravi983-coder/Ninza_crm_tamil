package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReaddatafromexcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("C:\\Users\\SABARI\\eclipse-workspace\\E32_NINZA_CRM\\src\\test\\resources\\mandatoryfieldsexcelTest.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("campaign");
		Row r = sh.getRow(1);
		Cell c = r.getCell(2);
		String campaignname = c.getStringCellValue();
		System.out.println(campaignname);
		
		String targetsize = wb.getSheet("campaign").getRow(1).getCell(3).getStringCellValue();
		System.out.println(targetsize);
		
		wb.close();

	}

}
