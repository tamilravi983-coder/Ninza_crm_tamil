package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Createcontactspage {
	WebDriver driver;
	public Createcontactspage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="organizationName")private WebElement organisationTF;
	@FindBy(name="title")private WebElement titleTF;
	@FindBy(name="contactName")private WebElement contactnameTF;
	@FindBy(name="mobile")private WebElement mobileTF;
	@FindBy(xpath="//*[name()='svg' and @data-icon='plus']")private WebElement plusBTN;
	@FindBy(xpath="//button[text()='Create Contact']")private WebElement createcontactBTN;
	public WebElement getOrganisationTF() {
		return organisationTF;
	}
	public WebElement getTitleTF() {
		return titleTF;
	}
	public WebElement getContactnameTF() {
		return contactnameTF;
	}
	public WebElement getMobileTF() {
		return mobileTF;
	}
	public WebElement getPlusBTN() {
		return plusBTN;
	}
	public WebElement getCreatecontactBTN() {
		return createcontactBTN;
	}
	

}
