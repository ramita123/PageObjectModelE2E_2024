package PageTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.PropertyReaderHelper;
import pages.DeleteAccount;
import testConfig.BaseTest;

public class LoginPageTests extends BaseTest{


	
	@Test(priority=1,description="login with Valid credentials")
	public void testLoginWithValidCredentials() {
		homepage.loadHomePage();
		Assert.assertEquals(homepage.isHomePageLoaded(),"Automation Exercise");
		homepage.loginSignupPageRouting();
		Assert.assertEquals(loginpage.isLoginToAccountVisisble(),"Login to your account");
		loginpage.userLogin(PropertyReaderHelper.getConfigPropertyData("email"), PropertyReaderHelper.getConfigPropertyData("password"));
		
		Assert.assertEquals(homepage.isLoggedInUserNameVisisble(),"Logged in as "+PropertyReaderHelper.getConfigPropertyData("username"));
	//	DeleteAccount deleteAccount=	homepage.deleteBtn();
	//	Assert.assertEquals(deleteAccount.accountDeletedConfirmation(),"ACCOUNT DELETED!");
		
	
	}
	
	
	@Test(priority=2,description="login with Invalid credentials")
	public void testLoginWithInvalidCredentials() {
		homepage.loadHomePage();
		Assert.assertEquals(homepage.isHomePageLoaded(),"Automation Exercise");
		
		homepage.loginSignupPageRouting();
		loginpage.userLogin(PropertyReaderHelper.getConfigPropertyData("incorrectUserEmail"), PropertyReaderHelper.getConfigPropertyData("password"));
		
		System.out.println(loginpage.getIncorrectLoginWarning());
		Assert.assertEquals(loginpage.getIncorrectLoginWarning(),"Login to your account");
	}
}
