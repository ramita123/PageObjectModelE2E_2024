package PageTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.PropertyReaderHelper;
import pages.AllProductsAndDetailPage;
import testConfig.BaseTest;

public class CartPageTest extends BaseTest{
	
	
	public AllProductsAndDetailPage productDetails;

	
	@Test(enabled=false ,priority=1,description="subscribed to news letter with valid cred")
	public void testNewsLetter() {
		homepage.loadHomePage();
		Assert.assertEquals(homepage.isHomePageLoaded(),"Automation Exercise");
		homepage.clickOnCartBtn();
		subscriptionOption.scroolingPage();
		Assert.assertEquals(subscriptionOption.getTitleMessage(),"SUBSCRIPTION");
	String successMessage=	subscriptionOption.fillSubscriptionForm(PropertyReaderHelper.getConfigPropertyData("email"));
	Assert.assertEquals(successMessage, "You have been successfully subscribed!");
		
	}
	
	@Test(enabled=false ,priority=2,description="check subscribe to newletter with invalid email validations")
	public void testWithInvalidEmailValidations() {
		homepage.loadHomePage();
		Assert.assertEquals(homepage.isHomePageLoaded(),"Automation Exercise");
		homepage.clickOnCartBtn();
		subscriptionOption.scroolingPage();
		Assert.assertEquals(subscriptionOption.getTitleMessage(),"SUBSCRIPTION");
	    String expectedMessage=subscriptionOption.fillSubscriptionFormWithInvalidEmail(PropertyReaderHelper.getConfigPropertyData("invalidEmail"));
	    String validationMessage=subscriptionOption.javaScriptMessageHandling();
	  Assert.assertEquals(validationMessage,  expectedMessage);
	
	}
	
	
	@Test(enabled=false,priority=3,description="add to cart and verify the product details ")
	public void testAddProductsToCart() {
		homepage.loadHomePage();
		Assert.assertEquals(homepage.isHomePageLoaded(),"Automation Exercise");
		 productDetails=	homepage.clickOnProductsBtn();
		 productDetails.clickOnAddCartBtnOfFirstProduct();
		 productDetails.clickOnContinueShopping();
		 productDetails.clickOnAddCartBtnOfSecondProduct();
		 
		 productDetails.clickOnViewCartBtnSecondItem();
		Assert.assertTrue(cartPage.areProductAddedToCart(),"item are not present in cart");
	    Assert.assertTrue( cartPage.verifyProductDetails()," details are not matching");
	
	
		
	}
	
	@Test(priority=4,description="remove items from cart")
	public void testRemoveProductFromCart() {
		
		homepage.loadHomePage();
		Assert.assertEquals(homepage.isHomePageLoaded(),"Automation Exercise");
		homepage.clickOnAddCartBtnOfFirstProduct();
		homepage.clickOnContinueShoppingHomePage();		
		homepage.clickOnAddCartBtnOfSecondProduct();
		homepage.clickOnContinueShoppingHomePage();	
		homepage.scrollHomePageVerticallyUp();
		homepage.clickOnCartBtn();
		Assert.assertEquals(homepage.isCartPageLoaded(),"Automation Exercise - Checkout") ;
		cartPage.deleteProductFromCart();
		Assert.assertEquals(cartPage.isCartEmpty(),"Cart is empty!");
		
		
		
		
	}

	
	
	
	
}
