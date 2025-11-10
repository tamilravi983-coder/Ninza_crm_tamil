package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Createcampaignpage {
	WebDriver driver;
	public Createcampaignpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//@FindAll({@FindBy(id="name"),@FindBy(name="campaignName")})private WebElement campaignnameTF;
	@FindBy(name="campaignName")private WebElement campaignnameTF;
	@FindBy(name="targetSize")private WebElement targetsizeTF;
	@FindBy(name="campaignStatus")private WebElement campaignstatusTF;
	@FindBy(name="expectedCloseDate")private WebElement expectedclosedateTF;
	@FindBy(name="targetAudience")private WebElement targetaudianceeTF;
	@FindBy(name="description")private WebElement descriptionTF;
	@FindBy(xpath="//button[text()='Create Campaign']")private WebElement createcampaignbtn;
	public WebElement getCampaignnameTF() {
		return campaignnameTF;
	}
	public WebElement getTargetsizeTF() {
		return targetsizeTF;
	}
	public WebElement getCampaignstatusTF() {
		return campaignstatusTF;
	}
	public WebElement getExpectedclosedateTF() {
		return expectedclosedateTF;
	}
	public WebElement getTargetaudianceeTF() {
		return targetaudianceeTF;
	}
	public WebElement getDescriptionTF() {
		return descriptionTF;
	}
	public WebElement getCreatecampaignbtn() {
		return createcampaignbtn;
	}
	
	
	
	
	

}
