package owntamil;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Prac1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("CAM17411");
		driver.findElement(By.xpath("//i[@title='Edit']")).click();
		//driver.findElement(By.xpath("(//td[text()='Tamilnadupeople'])[1]")).click();
		driver.findElement(By.name("targetAudience")).sendKeys("hello");
	
		driver.findElement(By.name("targetSize")).sendKeys("500");
		driver.findElement(By.xpath("//button[text()='Update Campaign']")).click();
		Thread.sleep(4000);
		WebElement TOAST = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String msg = TOAST.getText();
		System.out.println(msg);
		if(msg.contains("Modified Successfully")) {
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}
		

	}

}
