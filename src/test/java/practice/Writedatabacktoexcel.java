package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Writedatabacktoexcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("C:\\Users\\SABARI\\Desktop\\mandatoryfieldsexcelTest.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		          Sheet sh = wb.getSheet("Products");
                 Row r = sh.getRow(1);
                 Cell c = r.createCell(1,CellType.STRING );
                 c.setCellValue("IPHONE");
               FileOutputStream fos = new FileOutputStream("C:\\Users\\SABARI\\Desktop\\mandatoryfieldsexcelTest.xlsx");
               //write is used to save the data which we entered
               wb.write(fos);
               wb.close();
                
	}

}
