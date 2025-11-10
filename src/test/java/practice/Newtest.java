package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Newtest {
	@Test(priority=-200)
	public void productcreation() {
		Reporter.log(" MandatoryfieldscampaignTest",true);
	}
	@Test(priority=-200,invocationCount = 5,threadPoolSize = 3)
	public void  deleteproduct() {
		Reporter.log("productdelete",true);
//	WebDriver	driver=new ChromeDriver();
		
	}
	
	
		
	}
	


