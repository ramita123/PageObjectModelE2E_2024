package PageTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import testConfig.BaseTest;

public class ViewCategoryProductsTest extends BaseTest{
	
	
	
	@Test(priority=1,description="verify user is on sub category page")
	public void testViewCategoryProducts() {
		homepage.loadHomePage();
		Assert.assertEquals(homepage.isHomePageLoaded(),"Automation Exercise");
		Assert.assertTrue(homepage.isCategoryoptionVisisble());
		homepage.clickWomenDressCategory();
		String womenDressTitle=homepage.verifyWomenDressCategoryPage();
		Assert.assertEquals(homepage.verifyWomenDressCategoryPage(),womenDressTitle);
		
		homepage.clickMenTshirtCategory();
		String menShirtTitle=homepage.verifyMenTshirtCategoryPage();
		Assert.assertEquals(homepage.verifyMenTshirtCategoryPage(),menShirtTitle);
		
	}

}
