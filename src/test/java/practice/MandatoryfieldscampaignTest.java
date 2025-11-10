package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
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

public class MandatoryfieldscampaignTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		//read data from properties file
		propertyfileutility plib = new propertyfileutility();
		String BROWSER=plib.readdatafrompropertyfile("Browser");
		String URL=plib.readdatafrompropertyfile("url");
		String USERNAME=plib.readdatafrompropertyfile("Username");
		String PASSWORD=plib.readdatafrompropertyfile("Password");
		//read test script data from excel file
		Excelfileutility elib = new Excelfileutility();
		String CAMPAIGN_NAME=elib.readdatafromexcelfile("campaign", 1, 2);
		String TARGET_SIZE=elib.readdatafromexcelfile("campaign", 1, 3);
		String TOAST_MSG_VERIFICATION=elib.readdatafromexcelfile("campaign", 1, 4);
		
		
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
	
	//driver.get(URL);
	//driver.findElement(By.id("username")).sendKeys(USERNAME);
	//driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
	//driver.findElement(By.xpath("//button[@type='submit']")).click();
	
//	driver.findElement(By.name("campaignName")).sendKeys(CAMPAIGN_NAME);
//	WebElement targetsize = driver.findElement(By.name("targetSize"));

//	targetsize.clear();
	//targetsize.sendKeys(TARGET_SIZE);
	//driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	//create campaign
	Campaignspage campaignspage = new Campaignspage(driver);
	campaignspage.getAddcreatecampaignbtn().click();
	Createcampaignpage createcampaignpage = new Createcampaignpage(driver);
	createcampaignpage.getCampaignnameTF().sendKeys(CAMPAIGN_NAME);
	createcampaignpage.getTargetsizeTF().clear();
	createcampaignpage.getTargetsizeTF().sendKeys(TARGET_SIZE);
	createcampaignpage.getCreatecampaignbtn().click();
	
        Homepage homepage = new Homepage(driver);
	WebElement toastmsg = homepage.getToastmsg();
	//WebElement toastmsg = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
	
	//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	//wait.until(ExpectedConditions.visibilityOf(toastmsg));
	//String message = toastmsg.getText();
	wlib.waituntilelementtobevisible(driver,toastmsg);
	
//	System.out.println("Toast message :"+message);
//	Thread.sleep(2000);
	if(toastmsg.getText().contains(TOAST_MSG_VERIFICATION)) 
		System.out.println("created successfully");
		
	
	else 
		System.out.println("campaign not created");
		homepage.getClosetoastmsg().click();
		
	
	homepage.logout();
	
	
	//driver.findElement(By.xpath("//button[@aria-label='close']")).click();
	
	
	//WebElement usericon = driver.findElement(By.className("user-icon"));
	//wlib.mousehoveronwebelement(driver, usericon);
//	Actions act = new Actions(driver);
//	act.moveToElement(usericon).perform();
	
//	WebElement logout = driver.findElement(By.xpath("//div[text()='Logout ']"));
//	act.moveToElement(logout).click().perform();
	//wlib.clickronwebelement(driver, logout);
	
	

	driver.quit();
	
	
	}

}
