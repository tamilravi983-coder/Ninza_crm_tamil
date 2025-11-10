package productsTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import genericutilities.Baseclass;
import genericutilities.Excelfileutility;
import genericutilities.Webdriverutility;
import genericutilities.propertyfileutility;
import objectrepository.Addproduct;
import objectrepository.Homepage;
import objectrepository.Loginpage;

public class Productmobile extends Baseclass {
	@Test(groups="smoke")
	public void createproductmobile() throws EncryptedDocumentException, IOException {
		
		
		//READ data from excel file
		
		String PRODUCT_NAME=elib.readdatafromexcelfile("addproducts", 1, 0);
		 String SELECT_CATAGORY_DD = elib.readdatafromexcelfile("addproducts", 1, 1);
		String QUANTITY=elib.readdatafromexcelfile("addproducts", 1, 2);
		String PRICE_PER_UNIT=elib.readdatafromexcelfile("addproducts", 1, 3);
		
		String VENDOR_DD=elib.readdatafromexcelfile("addproducts", 5, 4);
		String TOAST_MSG_VERIFICATION = elib.readdatafromexcelfile("addproducts", 1, 5);
		
		
	driver.findElement(By.linkText("Products")).click();
	 Addproduct addproduct = new Addproduct(driver);
	 addproduct.getAddproductBTN().click();
		addproduct.getProductnameTF().sendKeys(PRODUCT_NAME);
		addproduct.getQunatityTF().clear();
		addproduct.getQunatityTF().sendKeys(QUANTITY);
		addproduct.getPriceTF().clear();
		addproduct.getPriceTF().sendKeys(PRICE_PER_UNIT);
		WebElement catagoryDD = addproduct.getcatagoryDD();
		wlib.select(catagoryDD,SELECT_CATAGORY_DD);
		WebElement vendorDD = addproduct.getvendorDD();
		wlib.select(vendorDD,VENDOR_DD);
		addproduct.getaddBTN().click();
		
		
		Homepage homepage = new Homepage(driver);
		WebElement toastmsg = homepage.getToastmsg();
		wlib.waituntilelementtobevisible(driver, toastmsg);
		
		
		if(toastmsg.getText().contains(TOAST_MSG_VERIFICATION)) {
			System.out.println("created successfully");
			
		}
		else {
			System.out.println("PRODUCT not created");
			homepage.getClosetoastmsg().click();
		}
	}

}
