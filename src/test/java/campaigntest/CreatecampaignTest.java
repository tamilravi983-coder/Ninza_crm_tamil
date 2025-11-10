package campaigntest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericutilities.Baseclass;
import genericutilities.Excelfileutility;
import genericutilities.Javautility;
import genericutilities.Webdriverutility;
import genericutilities.propertyfileutility;
import objectrepository.Campaignspage;
import objectrepository.Createcampaignpage;
import objectrepository.Homepage;
import objectrepository.Loginpage;
  @Listeners(genericutilities.Listnerimplementations.class)

public class CreatecampaignTest extends Baseclass {
	@Test(groups="smoke")
	public void MandatoryfieldscampaignTest() throws IOException {
		

		String CAMPAIGN_NAME=elib.readdatafromexcelfile("campaign", 1, 2);
		String TARGET_SIZE=elib.readdatafromexcelfile("campaign", 1, 3);
		String TOAST_MSG_VERIFICATION=elib.readdatafromexcelfile("campaign", 1, 4);
		
	
	
	//create campaign
	Campaignspage campaignspage = new Campaignspage(driver);
	campaignspage.getAddcreatecampaignbtn().click();
	Createcampaignpage createcampaignpage = new Createcampaignpage(driver);
	createcampaignpage.getCampaignnameTF().sendKeys(CAMPAIGN_NAME);
	createcampaignpage.getTargetsizeTF().sendKeys(TARGET_SIZE);
	createcampaignpage.getCreatecampaignbtn().click();
	
        Homepage homepage = new Homepage(driver);
	WebElement toastmsg = homepage.getToastmsg();
	
	wlib.waituntilelementtobevisible(driver, toastmsg);
	//here this code is modified to get screenshots to fail we ussed here 
	String msg = toastmsg.getText();
	Assert.assertTrue(msg.contains(TOAST_MSG_VERIFICATION));
	homepage.getClosetoastmsg().click();
	//Assert.assertTrue(msg.contains("jadjh"));
	//Assert.assertTrue(toastmsg.getText().contains(TOAST_MSG_VERIFICATION));
	
	//if(toastmsg.getText().contains(TOAST_MSG_VERIFICATION)) 
	//	System.out.println("created successfully");
		
	
	//else 
		//System.out.println("campaign not created");
		//homepage.getClosetoastmsg().click();
	
	
	}
	@Test(groups="regression")
	public void CreatecamapaignwithstatusTest() throws IOException {
		
		String CAMPAIGN_NAME=elib.readdatafromexcelfile("campaign", 4, 2);
		String STATUS=elib.readdatafromexcelfile("campaign", 4, 3);
		String TARGET_SIZE=elib.readdatafromexcelfile("campaign", 4, 4);
		String TOAST_MSG_VERIFICATION = elib.readdatafromexcelfile("campaign", 4, 5);
	
				
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
		wlib.waituntilelementtobevisible(driver, toastmsg);
		Assert.assertTrue(toastmsg.getText().contains(TOAST_MSG_VERIFICATION));
		
		
		//	if(toastmsg.getText().contains(TOAST_MSG_VERIFICATION)) 
			//	System.out.println("created successfully");
				
			
			//else 
				//System.out.println("campaign not created");
			homepage.getClosetoastmsg().click();
			
			
			
	}
	@Test(groups="smoke")
	public void CreatecampaignwithexpectedclosedateTest() throws EncryptedDocumentException, IOException {
		
		//Javautility jlib = new Javautility();
		String requireddate = jlib.getrequireddate(30);
		
		
		
//READ script data from excel
		
		String CAMPAIGN_NAME=elib.readdatafromexcelfile("campaign", 7, 2);
		String TARGET_SIZE=elib.readdatafromexcelfile("campaign", 7, 3);
		String TOAST_MSG_VERIFICATION =elib.readdatafromexcelfile("campaign", 7, 4);
	
		
		
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

	
		
		wlib.waituntilelementtobevisible(driver, toastmsg);
		Assert.assertTrue(toastmsg.getText().contains(TOAST_MSG_VERIFICATION));
		
		
		
	//	if(toastmsg.getText().contains(TOAST_MSG_VERIFICATION)) {
		//	System.out.println("created successfully");
			
		//	}
			//else {
			//	System.out.println("campaign not created");
		//	}
			homepage.getClosetoastmsg().click();
			
			
		
	}



}
