package PageTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.TestCasesPage;
import testConfig.BaseTest;

public class TestCasesPageTests extends BaseTest {
	
	@Test(description="verify the testcase button is clickable and redirecting to testCases page")
	public void testTestCasesPage() {
		homepage.loadHomePage();
		Assert.assertEquals(homepage.isHomePageLoaded(),"Automation Exercise");
	TestCasesPage testcasesPage=	homepage.clickOnTestCasesBtn();
	Assert.assertEquals(testcasesPage.getTestcasesPageTitle(), "Automation Practice Website for UI Testing - Test Cases");
	
	}
	
}
