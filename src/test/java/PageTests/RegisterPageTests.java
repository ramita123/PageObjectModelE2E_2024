package PageTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AccountConfirmationPage;
import pages.DeleteAccount;
import testConfig.BaseTest;


public class RegisterPageTests extends BaseTest{
	

	
	
	@Test(priority=1,description="Register a new user and verify the deletion of the account")
	public void testRegisterUser() {
		homepage.loadHomePage();
		Assert.assertEquals(homepage.isHomePageLoaded(),"Automation Exercise");
		
		homepage.loginSignupPageRouting();
		
		Assert.assertEquals(registerPage.isNewUserSignupVisible(),"New User Signup!");
		registerPage.enterEmailAndName("ramita","riyj@yopmail.com");
		registerPage.clickOnSignupBtn();
		AccountConfirmationPage accountpage= registerPage.fillAccountInformation("ramita","sam","12345","mohali" ,"chnadigarh","chandigarh","12345","4534534");
	
		Assert.assertEquals(accountpage.IsAccountCreated(),"ACCOUNT CREATED!");
	
		accountpage.clickOnContinueBtn();
		Assert.assertEquals(homepage.isLoggedInUserNameVisisble(), "Logged in as "+"ramita");
		DeleteAccount deleteAccount=	homepage.deleteBtn();
		Assert.assertEquals(deleteAccount.accountDeletedConfirmation(),"ACCOUNT DELETED!");
	
		accountpage.clickOnContinueBtn();
	
		
	}
	
	@Test(priority=2,description="Register with already existing user")
	public void testAlreadyRegisterUser() {
		homepage.loadHomePage();
		Assert.assertEquals(homepage.isHomePageLoaded(),"Automation Exercise");
		
		homepage.loginSignupPageRouting();
		
		Assert.assertEquals(registerPage.isNewUserSignupVisible(),"New User Signup!");
		registerPage.enterEmailAndName("ramita","anjali@yopmail.com");
		registerPage.clickOnSignupBtn();
		
		Assert.assertEquals(registerPage.alreadyExistingErrorMessage(), "Email Address already exist!");
	}

} 
