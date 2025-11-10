package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaignspage {

	WebDriver driver;
	public Campaignspage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//span[text()='Create Campaign']")private WebElement addcreatecampaignbtn;
	public WebElement getAddcreatecampaignbtn() {
		return addcreatecampaignbtn;
	}
	

}
