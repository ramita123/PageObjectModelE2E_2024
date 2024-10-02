package PageTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.PropertyReaderHelper;
import pages.ContactUsFormPage;
import testConfig.BaseTest;

public class ContactUsFormTests extends BaseTest {
	
	
	@Test(priority=1,description="fill the contact us form and verify after form sub user redirects to homepage")
	public void testContactUsForm() {
	homepage.loadHomePage();
	Assert.assertEquals(homepage.isHomePageLoaded(),"Automation Exercise");
	
	ContactUsFormPage contactFormPage =homepage.clickOnContactFormBtn();
	String text=contactFormPage.fillContactUsForm(PropertyReaderHelper.getConfigPropertyData("username"), PropertyReaderHelper.getConfigPropertyData("email"), PropertyReaderHelper.getConfigPropertyData("subject"), PropertyReaderHelper.getConfigPropertyData("message"), PropertyReaderHelper.getConfigPropertyData("filePath"));
	Assert.assertEquals(text, "Success! Your details have been submitted successfully.");
	Assert.assertEquals(homepage.isHomePageLoaded(),"Automation Exercise");
	}
}
