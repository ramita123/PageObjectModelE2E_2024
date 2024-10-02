package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Common;
import Base.CustomWaits;




public class ContactUsFormPage extends CustomWaits{

	public WebDriver driver;
	public CustomWaits wait;
	
	public  ContactUsFormPage(WebDriver driver) {
		
		this.driver=	driver;
		PageFactory.initElements(driver, this);
		
		
		}
	
	@FindBy(xpath="//div[@class='contact-form']/h2")
	WebElement getInTouchMessage;
		
	@FindBy(name="name")
	WebElement name;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="subject")
	WebElement subject;
	
	
	@FindBy(name="message")
	WebElement message;
	
	@FindBy(xpath="//input[@type='file']")
	WebElement uploadFile;
	
	@FindBy(xpath="//input[@data-qa='submit-button']")
	WebElement submitBtn;
	
	@FindBy(xpath="//div[@class='status alert alert-success']")
	WebElement getSuccessMessage;
	
	@FindBy(css=".btn.btn-success")
	WebElement homeBtn;
	
	public String isGetInTouchVisible() {
		return getInTouchMessage.getText();
	}
	
	public String fillContactUsForm(String userName, String userEmail,String formSubject,String userMessage,String filePath) {
		name.sendKeys(userName);
		email.sendKeys(userEmail);
		subject.sendKeys(formSubject);
		message.sendKeys(userMessage);
		uploadFile.sendKeys(filePath);
		submitBtn.click();
	   explicitWaitForAlert(driver,5);
		Common obj= new Common(driver);
		obj.alertHandling();
	    String text=	getSuccessMessage.getText();
	    homeBtn.click();
	
		return text;
	}
	
	
	
	
}
