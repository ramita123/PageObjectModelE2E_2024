package PageTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.PropertyReaderHelper;
import testConfig.BaseTest;

public class HomePageTest extends BaseTest {
	
	@Test(priority=1,description="subscribed to news letter with valid cred")
	public void testNewsLetter() {
		homepage.loadHomePage();
		Assert.assertEquals(homepage.isHomePageLoaded(),"Automation Exercise");
		subscriptionOption.scroolingPage();
		Assert.assertEquals(subscriptionOption.getTitleMessage(),"SUBSCRIPTION");
	String successMessage=	subscriptionOption.fillSubscriptionForm(PropertyReaderHelper.getConfigPropertyData("email"));
	Assert.assertEquals(successMessage, "You have been successfully subscribed!");
		
	}
	
	@Test(priority=2,description="check subscribe to newletter with invalid email validations")
	public void testWithInvalidEmailValidations() {
		homepage.loadHomePage();
		Assert.assertEquals(homepage.isHomePageLoaded(),"Automation Exercise");
		subscriptionOption.scroolingPage();
		Assert.assertEquals(subscriptionOption.getTitleMessage(),"SUBSCRIPTION");
	    String expectedMessage=subscriptionOption.fillSubscriptionFormWithInvalidEmail(PropertyReaderHelper.getConfigPropertyData("invalidEmail"));
	    String validationMessage=subscriptionOption.javaScriptMessageHandling();
	  Assert.assertEquals(validationMessage,  expectedMessage);
	
	}

}
