package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteAccount {

	public WebDriver driver;
	public DeleteAccount(WebDriver driver) {
		this.driver=	driver;
		PageFactory.initElements(driver, this);
		
		
		}
	
	@FindBy(xpath="//h2[@data-qa='account-deleted']")
	private WebElement deleteAccountMessage;
	
	
	public String accountDeletedConfirmation() {
		return deleteAccountMessage.getText();
	}
}
