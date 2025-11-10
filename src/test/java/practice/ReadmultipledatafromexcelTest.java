package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import genericutilities.Excelfileutility;

public class ReadmultipledatafromexcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		//FileInputStream fis = new FileInputStream("C:\\Users\\SABARI\\eclipse-workspace\\E32_NINZA_CRM\\src\\test\\resources\\mandatoryfieldsexcelTest.xlsx");
		
   //Workbook wb = WorkbookFactory.create(fis);
     //     Sheet sh = wb.getSheet("Products");
       //  int rowcount = sh.getLastRowNum();
         //System.out.println(rowcount);
        Excelfileutility elib = new Excelfileutility();
      int rowcount = elib.getrowcount("Products");
         
         for(int row=1;row<=rowcount;row++) {
        	// String data = sh.getRow(row).getCell(0).getStringCellValue();
        	String data = elib.readdatafromexcelfile("products", row, 0);
        	 System.out.println(data);
         }
        
	}

}
