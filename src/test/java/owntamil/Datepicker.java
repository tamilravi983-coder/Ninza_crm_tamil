package owntamil;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Datepicker {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("C:\\Desktop\\propetiesfileE32.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		String BROWSER = prop.getProperty("Browser");
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("Username");
		String PASSWORD = prop.getProperty("Password");
		
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
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//login
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//create campaign
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys("HDFGO1");
		WebElement targetsize = driver.findElement(By.name("targetSize"));
		targetsize.clear();
		targetsize.sendKeys("300");
		driver.findElement(By.name("campaignStatus")).sendKeys("activeTs");
		driver.findElement(By.name("expectedCloseDate")).sendKeys("11/25/2025");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		

	}

}
