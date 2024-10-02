package PageTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.PropertyReaderHelper;
import pages.HomePage;
import testConfig.BaseTest;

public class LogoutUserTests extends BaseTest{

	@Test(description="verify logout button is working and user is redirected to login page")
	public void logoutUserTest() {
		
		homepage.loadHomePage();
		Assert.assertEquals(homepage.isHomePageLoaded(),"Automation Exercise");
		homepage.loginSignupPageRouting();
		Assert.assertEquals(loginpage.isLoginToAccountVisisble(),"Login to your account");
		loginpage.userLogin(PropertyReaderHelper.getConfigPropertyData("email"), PropertyReaderHelper.getConfigPropertyData("password"));
		
		Assert.assertEquals(homepage.isLoggedInUserNameVisisble(),"Logged in as "+PropertyReaderHelper.getConfigPropertyData("username"));
	 homepage.clickOnLogoutBtn();
	 Assert.assertEquals(loginpage.isLoginToAccountVisisble(),"Login to your account");
		
	}

}
