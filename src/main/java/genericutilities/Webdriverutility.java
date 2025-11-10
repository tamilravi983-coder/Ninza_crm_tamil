package genericutilities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriverutility{
	public void implicitwait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void waituntilelementtobevisible(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
		}
	
	public void select(WebElement element,int index) {
		Select obj=new Select(element);
		obj.selectByIndex(index);
		
	}
	public void select(WebElement element,String value) {
		Select obj=new Select(element);
		obj.selectByValue(value);
		
	}
	//have to change order,argmnent,or num of argument,so chaged string first or else we get red line
	public void select(String text,WebElement element) {
		Select obj=new Select(element);
		obj.selectByVisibleText(text);
		
	}
	
	public void mousehoveronwebelement(WebDriver driver,WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	public void clickronwebelement(WebDriver driver,WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}
	public void switchdrivercontrolontitle(WebDriver driver,String title) {
		String parentid = driver.getWindowHandle();
		Set<String> allids = driver.getWindowHandles();
		allids.remove(parentid);
		for (String id : allids) {
			driver.switchTo().window(id);
			if( driver.getTitle().contains(title))
				break;
			
		}
		
	}
	
	public void switchdrivercontroloncurrenturl(WebDriver driver,String URL) {
		String parentid = driver.getWindowHandle();
		Set<String> allids = driver.getWindowHandles();
		allids.remove(parentid);
		for (String id : allids) {
			driver.switchTo().window(id);
			if( driver.getCurrentUrl().contains(URL))
				break;
			
		}
		
	}
	public void switchtoframe(WebDriver driver,int index) {
		driver.switchTo().frame(index);
		
	}
	public void switchtoframe(WebDriver driver,String nameorid) {
		driver.switchTo().frame(nameorid);
		
	}
	public void switchtoframe(WebDriver driver,WebElement frameElement) {
		driver.switchTo().frame(frameElement);
		
	}
	public void switchtoalertandaccept(WebDriver driver) {
		driver.switchTo().alert().accept();
		
	}
	public void switchtoalertanddismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
		
	}
	public void switchtoalertandgettext(WebDriver driver) {
		driver.switchTo().alert().getText();
		
	}
	public void switchtoalertandsendkeys(WebDriver driver,String text) {
		driver.switchTo().alert().sendKeys(text);
		
	}
	public void doubleclick(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	}
	
	public void rightclick(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
	
	
	
	
	

}
