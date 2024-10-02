package PageTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import testConfig.BaseTest;

public class AddToCartFromRecommended extends BaseTest {
	
	@Test(description="verify item is added to cart from recommended carousel")
	
	public void testAddToCartFromRecommendedCarousel() {
		homepage.loadHomePage();
		Assert.assertEquals(homepage.isHomePageLoaded(),"Automation Exercise");
		homepage.addToCartRecommendedProduct();
		homepage.clickOnViewCart();
	Assert.assertTrue(cartPage.isRecommendedItemIncart(),"recommended item is not in the cart");
	}


}
