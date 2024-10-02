package PageTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import testConfig.BaseTest;

public class ScrollUpAndScrollDownFunctioanlityTest extends BaseTest{

	
	@Test(priority=1)
	public void testScrollUpAndDown() {
		homepage.loadHomePage();
		Assert.assertEquals(homepage.isHomePageLoaded(),"Automation Exercise");
		homepage.verifyScrollDown();
		Assert.assertEquals(subscriptionOption.getTitleMessage(),"SUBSCRIPTION");
		homepage.verifyScrollUpWithArrowBtn();
		Assert.assertEquals(homepage.verifyFullFledgeTextVisible(),"Full-Fledged practice website for Automation Engineers");
	}
	
	@Test(priority=2)
	public void testScrollUpWithoutArrowBtnAndScrollDown() {
		
		homepage.loadHomePage();
		Assert.assertEquals(homepage.isHomePageLoaded(),"Automation Exercise");
		homepage.verifyScrollDown();
		Assert.assertEquals(subscriptionOption.getTitleMessage(),"SUBSCRIPTION");
		homepage.verifyScrollUpWithoutArrowBtn();
		Assert.assertEquals(homepage.verifyFullFledgeTextVisible(),"Full-Fledged practice website for Automation Engineers");
		
	}
}
