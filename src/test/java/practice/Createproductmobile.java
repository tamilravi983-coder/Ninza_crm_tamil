package practice;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import genericutilities.Excelfileutility;
import genericutilities.Webdriverutility;
import genericutilities.propertyfileutility;
import objectrepository.Addproduct;
import objectrepository.Homepage;
import objectrepository.Loginpage;

public class Createproductmobile  {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//read data from properties file
				propertyfileutility plib = new propertyfileutility();
				String BROWSER=plib.readdatafrompropertyfile("Browser");
				String URL=plib.readdatafrompropertyfile("url");
				String USERNAME=plib.readdatafrompropertyfile("Username");
				String PASSWORD=plib.readdatafrompropertyfile("Password");
				
				//READ data from excel file
				Excelfileutility elib = new Excelfileutility();
				String PRODUCT_NAME=elib.readdatafromexcelfile("addproducts", 1, 0);
				 String SELECT_CATAGORY_DD = elib.readdatafromexcelfile("addproducts", 1, 1);
				String QUANTITY=elib.readdatafromexcelfile("addproducts", 1, 2);
				String PRICE_PER_UNIT=elib.readdatafromexcelfile("addproducts", 1, 3);
				
				String VENDOR_DD=elib.readdatafromexcelfile("addproducts", 5, 4);
				String TOAST_MSG_VERIFICATION = elib.readdatafromexcelfile("addproducts", 1, 5);
				
				
				Webdriverutility wlib = new Webdriverutility();
				
				
				//to avoid one popup,it is not alert popup
				ChromeOptions settings = new ChromeOptions();
				Map<String, Object> prefs = new HashMap<>();
				prefs.put("profile.password_manager_leak_detection", false);
				settings.setExperimentalOption("prefs", prefs);

		//lauch broswer
			WebDriver driver = null;
			if(BROWSER.equalsIgnoreCase("chrome")) 
				driver=new ChromeDriver(settings);
			
			else if(BROWSER.equalsIgnoreCase("edge"))
				driver=new EdgeDriver();
			else if(BROWSER.equalsIgnoreCase("firefox"))
				driver=new FirefoxDriver();
			else if(BROWSER.equalsIgnoreCase("safari"))
				driver=new SafariDriver();

			driver.manage().window().maximize();
			wlib.implicitwait(driver);
			//login
			Loginpage loginpage = new Loginpage(driver);
			loginpage.logintapp(URL, USERNAME, PASSWORD);
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
				driver.quit();
				
				
				
		
				
				
				
				
	}

}
