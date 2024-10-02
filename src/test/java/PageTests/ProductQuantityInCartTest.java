package PageTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AllProductsAndDetailPage;
import testConfig.BaseTest;

public class ProductQuantityInCartTest  extends BaseTest{
	int quantity=4;
	
	@Test(description="verify product quantity")
	
	public void verifyProductQuantityTest() {
		homepage.loadHomePage();
		Assert.assertEquals(homepage.isHomePageLoaded(),"Automation Exercise");
		AllProductsAndDetailPage productDetails=	homepage.clickOnViewProduct();
		Assert.assertEquals(productDetails.isUserOnProductDetailPage(),"Automation Exercise - Product Details");
		productDetails.increaseQuantity(4);
		productDetails.clickAddToCartProuctDetails();
		productDetails.clickViewCartOnProductDetails();
		
		Assert.assertEquals(cartPage.verifyProductQuantityOnDeatilsPage(),String.valueOf(quantity));
	}
}
