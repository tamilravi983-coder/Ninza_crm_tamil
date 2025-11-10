package owntamil;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Gpt1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
       WebDriver driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       driver.get("https://www.amazon.in/");
       driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop");
       driver.findElement(By.id("nav-search-submit-button")).click();
   driver.findElement(By.xpath("(//span[contains(text(),'HP OmniBook 5 OLED (Previously Pavilion), Snapdragon X Processor (16GB LPDDR5x, 1TB SSD) 2K')])[1]")).click();
   Actions act = new Actions(driver);
   act.scrollByAmount(0,1000).perform();
   
   WebElement cart = driver.findElement(By.xpath("(//span[text()='Add to Cart'])[2]"));
   act.scrollToElement(cart).perform();
   cart.click();
   driver.findElement(By.id("nav-cart-count")).click();
  @Nullable
String title = driver.getTitle();
  System.out.println(title);
  

	
	}
}
