package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.CustomWaits;

import static Base.CustomWaits.staticWait;

public class LoginPage {
	
	public WebDriver driver;
	
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@data-qa='login-email']")
	WebElement enterLoginEmail;
	
	@FindBy(name="password")
	WebElement enterPassword;
	
	
	@FindBy(xpath="//button[@data-qa='login-button']")
	WebElement loginBtn;
	
	@FindBy(xpath="//div[@class='login-form']/h2")
	WebElement loginToYouAccount;
	
	@FindBy(xpath="//input[@type='password']/following-sibling::p")
	WebElement invalidCredMessage;
	
	public void userLogin(String email, String password) {
		enterLoginEmail.sendKeys(email);
		enterPassword.sendKeys(password);
		loginBtn.click();
		CustomWaits.staticWait(3);
		
	}
	
	
	
	public String isLoginToAccountVisisble() {
		return loginToYouAccount.getText();
	}
	
	public String getIncorrectLoginWarning() {
	return 	invalidCredMessage.getText();
	}
	
	
public void isUserRoutedToLoginPage() {
		
	}

}
