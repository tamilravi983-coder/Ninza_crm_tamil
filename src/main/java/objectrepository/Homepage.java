package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutilities.Webdriverutility;

public class Homepage {
	
	WebDriver driver;
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText = "Campaigns")private WebElement campaignslink;
	@FindBy(linkText = "Contacts")private WebElement contactlink;
	@FindBy(className  = "user-icon")private WebElement usericon; 
	//@FindBy(xpath = "//div[text()='Logout ']")private WebElement logoutbtn;
	@FindBy(xpath = "//div[text()='Logout ']")private WebElement logoutbtn;
	@FindBy(xpath = "//button[@aria-label='close']")private WebElement closetoastmsg;
	@FindBy(xpath = "//div[@role='alert']")private WebElement toastmsg;
	public WebElement getCampaignslink() {
		return campaignslink;
	}
	public WebElement getContactlink() {
		return contactlink;
	}
	public WebElement getUsericon() {
		return usericon;
	}
	public WebElement getLogoutbtn() {
		return logoutbtn;
	}
	public WebElement getClosetoastmsg() {
		return closetoastmsg;
	}
	public WebElement getToastmsg() {
		return toastmsg;
	}
	public void logout() {
		Webdriverutility wlib = new Webdriverutility();
		wlib.mousehoveronwebelement(driver, usericon);
		wlib.clickronwebelement(driver, logoutbtn);
	}
	
	
	
	
	//@FindBy(linkText = "Leads")private WebElement leadslink;
	//@FindBy(linkText = "Opportunities")private WebElement opportunitieslink;
	//@FindBy(linkText = "Products")private WebElement productslink;
//	@FindBy(linkText = "Quotes")private WebElement quoteslink;
//	@FindBy(linkText = "Purchase Order")private WebElement purchaselink;
//	@FindBy(linkText = "Sales Order")private WebElement salesorderlink;
	//@FindBy(linkText = "Invoice")private WebElement invoicelink;
	//@FindBy(xpath = "//li[text()='Admin Console']")private WebElement adminconsolelink;
	//@FindBy(xpath = "//li[text()='Admin Console']")private WebElement admincons;
	
	
	
	
	
	
	
	
	
	

}
