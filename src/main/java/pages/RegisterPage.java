package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.CustomWaits;

import static Base.CustomWaits.staticWait;;

public class RegisterPage {

	WebDriver driver;
	
	
	
	//the message on sign up page for a new user
	@FindBy(xpath="//div[@class='signup-form']/h2")
	private WebElement newUserSignUpMessage;
	
	@FindBy(xpath="//button[@data-qa='signup-button']")
	private WebElement signUpBtn;
	
	
	@FindBy(name="name")
	private WebElement name;
	
	
	@FindBy(xpath="//input[@data-qa='signup-email']")
	private WebElement email;
	
	
	@FindBy(id="id_gender1")
	private WebElement title;
	
	@FindBy(id="password")
	private WebElement passwordField;
	
	@FindBy(xpath="//label[@for='newsletter']")
	private WebElement newletterCheckbox;
	
	
	@FindBy(xpath="//label[@for='optin']")
	private WebElement receiveSpecialOfferCheckbox;
	
	@FindBy(id="first_name")
	private WebElement firstName;
	
	@FindBy(id="last_name")
	private WebElement lastName;
	
	
	@FindBy(id="address1")
	private WebElement address;
	
	@FindBy(id="state")
	private WebElement state;
	
	@FindBy(id="city")
	private WebElement city;
	
	@FindBy(id="zipcode")
	private WebElement zipcode;
	
	@FindBy(id="mobile_number")
	private WebElement mobileNumber;
	
	
	@FindBy(xpath="//button[@data-qa='create-account']")
	private WebElement createAccount;
	
	@FindBy(xpath="//input[@value='signup']/following-sibling::p")
	WebElement alreadyExistingUser;
	
	public RegisterPage(WebDriver driver) {
		this.driver=	driver;
		PageFactory.initElements(driver, this);
	}
	
	public String isNewUserSignupVisible() {
	String text=	newUserSignUpMessage.getText();
	return text;
	}
	
	
	
	
	public void enterEmailAndName(String Username, String Useremail) {
		System.out.println(Useremail);
		name.sendKeys(Username);
		staticWait(2);
		email.sendKeys(Useremail);
	}
	
	public void clickOnSignupBtn() {
		 signUpBtn.click();
	}
	
	public AccountConfirmationPage fillAccountInformation(String name,String lastname,String password,String Useraddress,String userState,
		String	userCity,String userZipcode,String mobile) {
		CustomWaits.staticWait(2);
		title.click();
		passwordField.sendKeys(password);
		newletterCheckbox.click();		
		receiveSpecialOfferCheckbox.click();
		firstName.sendKeys(name);
		lastName.sendKeys(lastname);
		address.sendKeys(Useraddress);	
		state.sendKeys(userState);
		city.sendKeys(userCity);
		zipcode.sendKeys(userZipcode);
		mobileNumber.sendKeys(mobile);
		createAccount.click();
		AccountConfirmationPage account= new AccountConfirmationPage(driver);
		return account;
		
	}
	
	public String alreadyExistingErrorMessage() {
	return	alreadyExistingUser.getText();
	}
	
	
	
}
