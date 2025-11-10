package contacttest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

public class CreatecontactTest extends Baseclass {
	@Test(groups= {"smoke,Regression"})
	public void createcontactwithmandatoryfieldsTest() throws IOException {
		
		//read test script data from excel file
		//Excelfileutility elib = new Excelfileutility();
		 String CAMPAIGN_NAME = elib.readdatafromexcelfile("campaigncontact", 1, 2);
		String  TARGET_SIZE=elib.readdatafromexcelfile("campaigncontact", 1, 3);
		String ORGANIZATION=elib.readdatafromexcelfile("campaigncontact", 1, 4);
		String  TITlE=elib.readdatafromexcelfile("campaigncontact", 1, 5);
		String CONTACT_NAME=elib.readdatafromexcelfile("campaigncontact", 1, 6);
		String SELECT_CAMPAIGN_PAGE_TITLE = elib.readdatafromexcelfile("campaigncontact", 1, 8)	;
		String CAMPAIGN_DD_VALUE = elib.readdatafromexcelfile("campaigncontact", 1, 9)	;
		
		String TOAST_MSG_VERIFICATION = elib.readdatafromexcelfile("campaigncontact", 1, 10)	;
	
		
		
		
	
		
	//	String MOBILE=elib.readdatafromexcelfile("campaigncontact", 1, 7);
		
		
		
			
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
		if(toastmsg.getText().contains(TOAST_MSG_VERIFICATION))
			System.out.println("contacts created");
			else
				System.out.println("contacts not created");
		
		homepage.getClosetoastmsg().click();
           
		
	}

}
