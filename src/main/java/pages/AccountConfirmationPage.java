package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.CustomWaits;

import static Base.CustomWaits.staticWait;

public class AccountConfirmationPage {
public WebDriver driver;
	
	public AccountConfirmationPage(WebDriver driver) {
	this.driver=	driver;
	PageFactory.initElements(driver, this);
	
	
	}
	
	
	@FindBy(xpath="//h2[@data-qa='account-created']/b")
	private WebElement confirmationMessage;
	
	
	@FindBy(xpath="//a[@data-qa='continue-button']")
	private WebElement continueBtnClick;
	
	//Account Created!
	
	
	public String IsAccountCreated() {
		CustomWaits.staticWait(2);
	return	confirmationMessage.getText();
	}
	
	public void clickOnContinueBtn() {
		continueBtnClick.click();
	}
	
	
	
	
	
	
	
	
}
