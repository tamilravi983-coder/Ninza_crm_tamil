package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Selectcampaignpage {
	WebDriver driver;
	public Selectcampaignpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="search-criteria")private WebElement campaignDD;
	@FindBy(id = "search-input")private WebElement searchTF;
	
	@FindBy(className  ="select-btn")private WebElement selectbtn;
	public WebElement getCampaignDD() {
		return campaignDD;
	}

	public WebElement getSearchTF() {
		return searchTF;
	}

	public WebElement getSelectbtn() {
		return selectbtn;
	}
	
	
	
	
}
