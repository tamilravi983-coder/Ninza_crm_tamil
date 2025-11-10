package genericutilities;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectrepository.Homepage;
import objectrepository.Loginpage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Baseclass {
	//here it is declred globally then only can use anywhere,
public	propertyfileutility plib = new propertyfileutility();
public	WebDriver driver=null;
    public     Excelfileutility   elib=new Excelfileutility();
   public  Javautility  jlib= new Javautility();
   public  Webdriverutility  wlib=  new Webdriverutility();
   
   public static WebDriver sdriver=null;         
	//here another driver used which is sdriver for assertions,we can make the webdriver as static nd use,but static hv
   //only one copy,for parelle execution is not able to use ,so we declare another driver nd use ,initially its null,after 
   //launching browser only knows which browser hv to use
	 
	 @BeforeSuite(groups={"smoke","regression"})
	  public void beforeSuite() {
		 System.out.println("Establish the database connection");
	  }
	 @BeforeTest(groups={"smoke","regression"})
	  public void beforeTest() {
		 System.out.println("Pre-conditions for parellel execution");
	  }
//@Parameters("BROWSER")--->for cross browser test
	  @BeforeClass(groups={"smoke","regression"})
	  public void beforeClass() throws IOException {
	//String BROWSER=browser;(have to give String browserin brackets for cross browser in beforeclass())
		  System.out.println("Launch the browser");
			
		  String BROWSER=plib.readdatafrompropertyfile("Browser");//-->to execute from cmd promt 
		 // String BROWSER=System.getProperty("chrome");
		  
		  
			ChromeOptions settings = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			settings.setExperimentalOption("prefs", prefs);
			
			//launch browser

			
			if(BROWSER.equalsIgnoreCase("chrome")) 
				driver=new ChromeDriver(settings);
			
			else if(BROWSER.equalsIgnoreCase("edge"))
				driver=new EdgeDriver();
			else if(BROWSER.equalsIgnoreCase("firefox"))
				driver=new FirefoxDriver();
			else if(BROWSER.equalsIgnoreCase("safari"))
				driver=new SafariDriver();
			sdriver=driver;
			
			
			driver.manage().window().maximize();
			wlib.implicitwait(driver);
			
	  }
  @BeforeMethod(groups={"smoke","regression"})
  public void beforeMethod() throws IOException {
	  System.out.println("Login");
	  String URL=plib.readdatafrompropertyfile("url");
		String USERNAME=plib.readdatafrompropertyfile("Username");
		String PASSWORD=plib.readdatafrompropertyfile("Password");
		
			
	  Loginpage loginpage = new Loginpage(driver);
		loginpage.logintapp(URL, USERNAME, PASSWORD);
		
  }

  @AfterMethod(groups={"smoke","regression"})
  public void afterMethod() {
	  System.out.println("Logout");
	  Homepage homepage = new Homepage(driver);
	 homepage.logout();
	 
	  
  }
  

  @AfterClass(groups={"smoke","regression"})
  public void afterClass() {
	  System.out.println("Close the browser");
	  driver.quit();
  }

  @AfterTest(groups={"smoke","regression"})
  public void afterTest() {
	  System.out.println("Post conditions for parellel executions");
  }

  @AfterSuite(groups={"smoke","regression"})
  public void afterSuite() {
	  System.out.println("Close the database connection");
  }

}
