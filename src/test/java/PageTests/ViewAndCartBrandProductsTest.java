package PageTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AllProductsAndDetailPage;
import testConfig.BaseTest;

public class ViewAndCartBrandProductsTest extends BaseTest {
	public String brandProduct="MADAME";
	public String brandProduct2="H&M";

	@Test(priority=1,description="verify brand and thier products")
	public void testViewAndCartBrandProducts() {
		homepage.loadHomePage();
		Assert.assertEquals(homepage.isHomePageLoaded(),"Automation Exercise");
		AllProductsAndDetailPage productPage=	homepage.clickOnProductsBtn();
		Assert.assertEquals(productPage.verifyBrandTitleVisible(),"BRANDS");
		productPage.clickAnyBrandOption(brandProduct);
	Assert.assertEquals(productPage.verifyBrandPageIsVisible(),"BRAND - "+brandProduct+" PRODUCTS");
	
	productPage.clickAnyBrandOption(brandProduct2);
	Assert.assertEquals(productPage.verifyBrandPageIsVisible(),"BRAND - "+brandProduct2+" PRODUCTS");
		
	}
}
