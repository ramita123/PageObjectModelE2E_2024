package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Common;

public class CommonSubscriptionPage extends Common {
	
	
	public WebDriver driver;
	public String expectedMessage;
	
	public CommonSubscriptionPage(WebDriver driver) {
		super(driver);
	this.driver=	driver;
	PageFactory.initElements(driver, this);
	
	
	}
	@FindBy(id="susbscribe_email")
	WebElement enterid;
	
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//div[@class='single-widget']/h2")
	WebElement subscriptionText;
	
	@FindBy(css=".alert-success.alert")
	WebElement successMessgae;
	
	public void scroolingPage() {
		
		scrollPage( 0, 1600);
	}
	
	public String getTitleMessage() {
		return subscriptionText.getText();
	}
	
	
	public String fillSubscriptionForm(String email) {
		
		enterid.sendKeys(email);
		submitBtn.click();
	   return	successMessgae.getText();
       	}
	
	
	public String fillSubscriptionFormWithInvalidEmail(String email) {
		enterid.sendKeys(email);
		submitBtn.click();
	
	
	if(driver instanceof ChromeDriver ) {
		expectedMessage = "Please include an '@' in the email address. 'you' is missing an '@'.";
	}
	else if (driver instanceof FirefoxDriver) {
        expectedMessage = "Please enter an email address.";
    }
	
	return expectedMessage;
	
	}
	
	public String javaScriptMessageHandling() {
		String message=	retrieveValidationMessage(enterid);
		return message;
	}
}
