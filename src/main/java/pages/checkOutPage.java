package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Common;

public class checkOutPage extends Common{

	
public WebDriver driver;
	
	public checkOutPage(WebDriver driver) {
		super(driver);
	this.driver=	driver;
	
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@id='address_delivery']/li[1]")
	WebElement addressTitle;
	
	@FindBy(xpath="(//h2[@class='heading'])[2]")
	WebElement reviewOrder;
	
	
	@FindBy(xpath="//*[@name='message']")
	WebElement description;
	
	
	@FindBy(css=".btn.btn-default.check_out")
	WebElement placeOrder;
	
	
	
	public String addressTilte() {
		return addressTitle.getText();
	}
	
	public String reviewOrderTilte() {
		scrollPage(0,300);
		return reviewOrder.getText();
	}
	
	public void writeDescription(String des) {
		scrollPage(0,500);
		description.sendKeys(des);
	}
	
	public PaymentPage placeOrderBtn() {
		placeOrder.click();
		PaymentPage paymentPage= new PaymentPage(driver);
		return paymentPage;
	}
}
