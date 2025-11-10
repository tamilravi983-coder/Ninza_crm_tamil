package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericutilities.Excelfileutility;
import genericutilities.Webdriverutility;
import genericutilities.propertyfileutility;
import objectrepository.Campaignspage;
import objectrepository.Createcampaignpage;
import objectrepository.Homepage;
import objectrepository.Loginpage;

public class CreatecampaignwithstatusTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		propertyfileutility plib = new propertyfileutility();
		String BROWSER=plib.readdatafrompropertyfile("Browser");
		String URL=plib.readdatafrompropertyfile("url");
		String USERNAME=plib.readdatafrompropertyfile("Username");
		String PASSWORD=plib.readdatafrompropertyfile("Password");
		
			
		Excelfileutility elib = new Excelfileutility();
		String CAMPAIGN_NAME=elib.readdatafromexcelfile("campaign", 4, 2);
		String STATUS=elib.readdatafromexcelfile("campaign", 4, 3);
		String TARGET_SIZE=elib.readdatafromexcelfile("campaign", 4, 4);
		String TOAST_MSG_VERIFICATION = elib.readdatafromexcelfile("campaign", 4, 5);		
		Webdriverutility wlib = new Webdriverutility();
		

		
			//String CAMPAIGN_NAME = wb.getSheet("campaign").getRow(4).getCell(2).getStringCellValue();
			//String STATUS = wb.getSheet("campaign").getRow(4).getCell(3).getStringCellValue();
			//String TARGET_SIZE = wb.getSheet("campaign").getRow(4).getCell(4).getStringCellValue();
			// wb.close();
			
			
			//to avoid one popup,it is not alert popup
			ChromeOptions settings = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			settings.setExperimentalOption("prefs", prefs);
			
			//launch browser

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
			
			//create campaign
			Campaignspage campaignspage = new Campaignspage(driver);
			campaignspage.getAddcreatecampaignbtn().click();

			Createcampaignpage createcampaignpage = new Createcampaignpage(driver);
			createcampaignpage.getCampaignnameTF().sendKeys(CAMPAIGN_NAME);
			createcampaignpage.getTargetsizeTF().clear();
			createcampaignpage.getTargetsizeTF().sendKeys(TARGET_SIZE);
			createcampaignpage.getCampaignstatusTF().sendKeys(STATUS);
			createcampaignpage.getCreatecampaignbtn().click();
			Homepage homepage = new Homepage(driver);
		WebElement toastmsg = homepage.getToastmsg();
		//	WebElement toastmsg = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
			
			//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			//wait.until(ExpectedConditions.visibilityOf(toastmsg));
			
		//	String message = toastmsg.getText();
		//	System.out.println("Toast message :"+message);
		wlib.waituntilelementtobevisible(driver, toastmsg);
			if(toastmsg.getText().contains(TOAST_MSG_VERIFICATION)) 
				System.out.println("created successfully");
				
			
			else 
				System.out.println("campaign not created");
			homepage.getClosetoastmsg().click();
			homepage.logout();
			//driver.findElement(By.xpath("//button[@aria-label='close']")).click();
			
			
			//WebElement usericon = driver.findElement(By.className("user-icon"));
			//wlib.mousehoveronwebelement(driver, usericon);
			//WebElement logout = driver.findElement(By.xpath("//div[text()='Logout ']"));
			//wlib.clickronwebelement(driver, logout);
			
			

			driver.quit();
			
			


	}

}
