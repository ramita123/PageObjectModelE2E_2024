package PageTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.PropertyReaderHelper;
import pages.AllProductsAndDetailPage;
import testConfig.BaseTest;

public class AddReviewTest extends BaseTest{

	
	
	@Test(description="add review on a product")
	public void testSubmitReviewForm() {
		homepage.loadHomePage();
		Assert.assertEquals(homepage.isHomePageLoaded(),"Automation Exercise");
		AllProductsAndDetailPage productDetails=	homepage.clickOnProductsBtn();
		Assert.assertTrue(productDetails.isUserRoutedToProductPage(),"user is not on product page");
		productDetails.clickOnViewCartOfFirstItem();
	Assert.assertEquals(productDetails.verifyWriteReviewTitleVisisble().toLowerCase(),"write your review");
	productDetails.addReview(PropertyReaderHelper.getConfigPropertyData("username") ,PropertyReaderHelper.getConfigPropertyData("email"), 
			PropertyReaderHelper.getConfigPropertyData("review"));
	
	}
}
