package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericutilities.Excelfileutility;
import genericutilities.Javautility;
import genericutilities.Webdriverutility;
import genericutilities.propertyfileutility;
import objectrepository.Campaignspage;
import objectrepository.Contactspage;
import objectrepository.Createcampaignpage;
import objectrepository.Createcontactspage;
import objectrepository.Homepage;
import objectrepository.Loginpage;
import objectrepository.Selectcampaignpage;

public class CreatecampaignwithcontactsTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		//create campaign
		propertyfileutility plib = new propertyfileutility();
		String BROWSER=plib.readdatafrompropertyfile("Browser");
		String URL=plib.readdatafrompropertyfile("url");
		String USERNAME=plib.readdatafrompropertyfile("Username");
		String PASSWORD=plib.readdatafrompropertyfile("Password");
		
		//read test script data from excel file
		Excelfileutility elib = new Excelfileutility();
		 String CAMPAIGN_NAME = elib.readdatafromexcelfile("campaigncontact", 1, 2);
		String  TARGET_SIZE=elib.readdatafromexcelfile("campaigncontact", 1, 3);
		String ORGANIZATION=elib.readdatafromexcelfile("campaigncontact", 1, 4);
		String  TITlE=elib.readdatafromexcelfile("campaigncontact", 1, 5);
		String CONTACT_NAME=elib.readdatafromexcelfile("campaigncontact", 1, 6);
		String SELECT_CAMPAIGN_PAGE_TITLE = elib.readdatafromexcelfile("campaigncontact", 1, 8)	;
		String CAMPAIGN_DD_VALUE = elib.readdatafromexcelfile("campaigncontact", 1, 9)	;
		
		String TOAST_MSG_VERIFICATION = elib.readdatafromexcelfile("campaigncontact", 1, 10)	;
	
		
		
		
		Javautility jlib = new Javautility();
		Webdriverutility wlib = new Webdriverutility();
		
		
	//	String MOBILE=elib.readdatafromexcelfile("campaigncontact", 1, 7);
		
		
		// TODO Auto-generated method stub
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
			
			
			//LOGIN
			driver.manage().window().maximize();
		wlib.implicitwait(driver);
			//login
		Loginpage loginpage = new Loginpage(driver);
		loginpage.logintapp(URL, USERNAME, PASSWORD);
		
			
			//create campaign
			//driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		Campaignspage campaignspage = new Campaignspage(driver);
		campaignspage.getAddcreatecampaignbtn().click();
		Createcampaignpage createcampaignpage = new Createcampaignpage(driver);
		createcampaignpage.getCampaignnameTF().sendKeys(CAMPAIGN_NAME);
		createcampaignpage.getTargetsizeTF().clear();
		createcampaignpage.getTargetsizeTF().sendKeys(TARGET_SIZE);
		createcampaignpage.getCreatecampaignbtn().click();
		Homepage homepage = new Homepage(driver);
         homepage.getClosetoastmsg().click();
		
		
		//click on contacts
		homepage.getContactlink().click();
	//	clck+
		Contactspage contactspage = new Contactspage(driver);
		contactspage.getAddcreatecontactbtn().click();
		//createcampaignpage.getCreatecampaignbtn().click();
		//enter mandat fields
		Createcontactspage createcontactspage = new Createcontactspage(driver);
		createcontactspage.getOrganisationTF().sendKeys(ORGANIZATION);
		createcontactspage.getTitleTF().sendKeys(TITlE);
		createcontactspage.getContactnameTF().sendKeys(CONTACT_NAME);
		createcontactspage.getMobileTF().sendKeys("9"+jlib.generateninedigitnumber());
		createcontactspage.getPlusBTN().click();
		//get parent id
		String parentid = driver.getWindowHandle();
		// Switch the driver control to child

		wlib.switchdrivercontrolontitle(driver, SELECT_CAMPAIGN_PAGE_TITLE);
		
		
		
	
		
			//driver.findElement(By.name("campaignName")).sendKeys(CAMPAIGN_NAME);
			//WebElement targetsize = driver.findElement(By.name("targetSize"));
		//	targetsize.clear();
		//	targetsize.sendKeys(TARGET_SIZE);
		//	driver.findElement(By.xpath("//button[@type='submit']")).click();
			//driver.findElement(By.xpath("//button[@aria-label='close']")).click();
			
			//click on contacts
			//driver.findElement(By.linkText("Contacts")).click();
			//clic+
			//driver.findElement(By.xpath("//span[text()='Create Contact']")).click();
		//	//enter mandatory fields
			//driver.findElement(By.name("organizationName")).sendKeys(ORGANIZATION);
		//	driver.findElement(By.name("title")).sendKeys(TITlE);
			//driver.findElement(By.name("contactName")).sendKeys(CONTACT_NAME);
		//	driver.findElement(By.name("mobile")).sendKeys("9"+jlib.generateninedigitnumber());
		//	driver.findElement(By.xpath("//*[name()='svg' and @data-icon='plus']")).click();
			//String parentid = driver.getWindowHandle();
		//	wlib.switchdrivercontrolontitle(driver, "Select campaign");
			//driver.switchTo().window(CONTACT_NAME);
			//Switch driver control to child
			//String parentid = driver.getWindowHandle();
			//Set<String> allids = driver.getWindowHandles();
			//allids.remove(parentid);
			//for (String id : allids) {
				//driver.switchTo().window(id);
				//if( driver.getTitle().contains("Select campaign"))
					//break;
			
				//	}
			// WebElement DD = driver.findElement(By.id("search-criteria"));
			
			//select campaign name from DD
			Selectcampaignpage selectcampaignpage = new Selectcampaignpage(driver);
			WebElement campaignDD = selectcampaignpage.getCampaignDD();
			
			 wlib.select(campaignDD, CAMPAIGN_DD_VALUE);
			 
			// Enter Camapign name in search text field
			 
			 selectcampaignpage.getSearchTF().sendKeys(CAMPAIGN_NAME);
			 
				// click on select button
			WebElement selectbtn = selectcampaignpage.getSelectbtn();
			wlib.waituntilelementtobevisible(driver, selectbtn);
			selectbtn.click();
			
			//switcj driver control to parent
			driver.switchTo().window(parentid);
			
			// click on create contact
			createcontactspage.getCreatecontactBTN().click();
			
			//verification
			WebElement toastmsg = homepage.getToastmsg();
			wlib.waituntilelementtobevisible(driver, toastmsg);
				//wlib.waituntilelementtobevisible(driver, toastmsg);
		//	if(toastmsg.getText().contains("Successfully Added"))
			if(toastmsg.getText().contains(TOAST_MSG_VERIFICATION))
				System.out.println("contacts created");
				else
					System.out.println("contacts not created");
			
			homepage.getClosetoastmsg().click();
               //logout
			
			homepage.logout();
			//close
			driver.quit();
			
			
			
			//Select obj =new Select(DD);	
			//obj.selectByValue("campaignName");
			 
			// wlib.select(campaignDD, "campaignName");
			// Enter Camapign name in search text field
//				driver.findElement(http://By.id("search-input")).sendKeys(CAMPAIGN_NAME);


			 
			//click on select btn
			//WebElement select_btn = driver.findElement(By.className("select-btn"));
			//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			//wait.until(ExpectedConditions.visibilityOf(select_btn));
			//wlib.waituntilelementtobevisible(driver, select_btn);
			//select_btn.click();
			//switcj driver control to parent
			//driver.switchTo().window(parentid);
			//driver.findElement(By.xpath("//button[text()='Create Contact']")).click();
			//verification
		//	Homepage homepage = new Homepage(driver);
			//WebElement toastmsg = homepage.getToastmsg();
		//	wlib.waituntilelementtobevisible(driver, toastmsg);
		//	if(toastmsg.getText().contains("Successfully Added"))
		//	System.out.println("contacts created");
			//else
			//	System.out.println("contacts not created");
			//homepage.getClosetoastmsg().click();
			//logout
			
			//homepage.logout();
			//close
			//driver.quit();
			
			
			
			
			
			
	}


	}


