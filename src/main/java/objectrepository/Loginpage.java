package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver driver;
	public Loginpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="username")
	private WebElement usernameTF;
	
	@FindBy(id="inputPassword")
	private WebElement passwordTF;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement signinbtn;

	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getSigninbtn() {
		return signinbtn;
	}
	public void logintapp(String url,String username,String password) {
		driver.get(url);
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		signinbtn.click();
	}
	
}
