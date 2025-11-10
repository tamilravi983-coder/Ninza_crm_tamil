package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tammilwriteprac {
	public  void implicitwait(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	public void  webdriverwait(WebDriver driver,WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
		
	}

	public void selectbyvalue(WebElement element,String  value){
		Select S = new Select(element);
		S.selectByValue(value);
		
		
	}
	public void mousehoveronelement(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	public String getrequireddate(int days) {
		Date d = new Date();
		SimpleDateFormat sim = new SimpleDateFormat();
		sim.format(d);
		 Calendar cal = sim.getCalendar();
		 cal.add(Calendar.DAY_OF_MONTH,days);
		String reqdate = sim.format(cal.getTime());
		return reqdate;
		
	}
	public int generateten() {
	Random random = new Random();
	int randomnum = random.nextInt(100000000,99999999);
	return randomnum;
	}
	
	
	

}
