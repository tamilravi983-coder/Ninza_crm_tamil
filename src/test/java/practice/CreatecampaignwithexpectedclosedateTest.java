package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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
import genericutilities.Javautility;
import genericutilities.Webdriverutility;
import genericutilities.propertyfileutility;
import objectrepository.Campaignspage;
import objectrepository.Createcampaignpage;
import objectrepository.Homepage;
import objectrepository.Loginpage;

public class CreatecampaignwithexpectedclosedateTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		propertyfileutility plib = new propertyfileutility();
		String BROWSER=plib.readdatafrompropertyfile("Browser");
		String URL=plib.readdatafrompropertyfile("url");
		String USERNAME=plib.readdatafrompropertyfile("Username");
		String PASSWORD=plib.readdatafrompropertyfile("Password");
		
		//Date date = new Date();
		//have to give MM in caps only,then only works
		//SimpleDateFormat sim = new SimpleDateFormat("MM-dd-yyyy");
		//sim.format(date);
		//Calendar cal = sim.getCalendar();
		//cal.add(Calendar.DAY_OF_MONTH, 30);
		//String requiredDate = sim.format(cal.getTime());
		//System.out.println("date is:"+requiredDate);
		
		Javautility jlib = new Javautility();
		String requireddate = jlib.getrequireddate(30);
		
		Webdriverutility wlib = new Webdriverutility();
		
//READ script data from excel
		Excelfileutility elib = new Excelfileutility();
		String CAMPAIGN_NAME=elib.readdatafromexcelfile("campaign", 7, 2);
		String TARGET_SIZE=elib.readdatafromexcelfile("campaign", 7, 3);
		String TOAST_MSG_VERIFICATION=elib.readdatafromexcelfile("campaign", 7, 4);
	
		
		
		//to avoid one popup,it is not alert popup
		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		settings.setExperimentalOption("prefs", prefs);
		

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
		
		createcampaignpage.getCreatecampaignbtn().click();
		
		
		//driver.findElement(By.name("campaignName")).sendKeys(CAMPAIGN_NAME);
		//WebElement targetsize = driver.findElement(By.name("targetSize"));
		//targetsize.clear();
		//targetsize.sendKeys(TARGET_SIZE);
		//driver.findElement(By.name("campaignStatus")).sendKeys("activeTs");
		//driver.findElement(By.name("expectedCloseDate")).sendKeys(requireddate);
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		Homepage homepage = new Homepage(driver);
		WebElement toastmsg = homepage.getToastmsg();

	//	WebElement toastmsg = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		
		wlib.waituntilelementtobevisible(driver, toastmsg);
		//String message = toastmsg.getText();
		//System.out.println("Toast message :"+message);
		
		if(toastmsg.getText().contains(TOAST_MSG_VERIFICATION)) {
			System.out.println("created successfully");
			
		}
		else {
			System.out.println("campaign not created");
		}
		homepage.getClosetoastmsg().click();
		homepage.logout();
		//driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
		
	//	WebElement usericon = driver.findElement(By.className("user-icon"));
	//	wlib.mousehoveronwebelement(driver, usericon);
		//WebElement logout = driver.findElement(By.xpath("//div[text()='Logout ']"));
		//wlib.clickronwebelement(driver, logout);
		
		

		driver.quit();
		
		
		
		

	}

}
