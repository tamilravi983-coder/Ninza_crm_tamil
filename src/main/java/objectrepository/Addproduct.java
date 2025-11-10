package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addproduct {

	WebDriver driver;
	public Addproduct(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//span[text()='Add Product']")private WebElement addproductBTN;
	@FindBy(name="productName")private WebElement productnameTF;
	@FindBy(name="quantity")private WebElement qunatityTF;
	@FindBy(name="price")private WebElement priceTF;
	@FindBy(name="productCategory")private WebElement catagoryDD;
	@FindBy(name="vendorId")private WebElement vendorDD;
	@FindBy(xpath="//button[text()='Add']")private WebElement addBTN;
	public WebElement getAddproductBTN() {
		return addproductBTN;
	}
	public WebElement getProductnameTF() {
		return productnameTF;
	}
	public WebElement getQunatityTF() {
		return qunatityTF;
	}
	public WebElement getPriceTF() {
		return priceTF;
	}
	public WebElement getcatagoryDD() {
		return catagoryDD;
	}
	public WebElement getvendorDD() {
		return vendorDD;
	}
	
	public WebElement getaddBTN() {
		return addBTN;
	}
	
	
	
	
	

}
