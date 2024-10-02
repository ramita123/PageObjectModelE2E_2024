package PageTests;


import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.PropertyReaderHelper;
import pages.AccountConfirmationPage;
import pages.DeleteAccount;
import pages.PaymentPage;
import testConfig.BaseTest;

public class PlaceOrderTest extends BaseTest {

	public PaymentPage paymentPage;
	public DeleteAccount deleteAccount;
	public AccountConfirmationPage accountpage;
	
	@Test(priority=1,description="verify order is placed and Register the user while checkout ")
	
	public void placeOrderRegisterWhileCheckout() {
		homepage.loadHomePage();
		Assert.assertEquals(homepage.isHomePageLoaded(),"Automation Exercise");
		homepage.clickOnAddCartBtnOfFirstProduct();
		homepage.clickOnContinueShoppingHomePage();		
		homepage.clickOnAddCartBtnOfSecondProduct();
		homepage.clickOnContinueShoppingHomePage();	
		homepage.scrollHomePageVerticallyUp();
		homepage.clickOnCartBtn();
		Assert.assertEquals(homepage.isCartPageLoaded(),"Automation Exercise - Checkout") ;
		cartPage.clickCheckoutBtn();
		cartPage.clickOnRegisterLoginBtn();
		registerPage.enterEmailAndName("roobina",email);
		registerPage.clickOnSignupBtn();
		 accountpage= registerPage.fillAccountInformation("ramita","sam","12345","mohali" ,"chnadigarh","chandigarh","12345","4534534");
		
		Assert.assertEquals(accountpage.IsAccountCreated(),"ACCOUNT CREATED!");
	
		accountpage.clickOnContinueBtn();
		Assert.assertEquals(homepage.isLoggedInUserNameVisisble(), "Logged in as roobina");
		homepage.clickOnCartBtn();
		cartPage.clickCheckoutBtn();
		
	Assert.assertEquals(checkoutPage.addressTilte(),"YOUR DELIVERY ADDRESS");
	Assert.assertEquals(checkoutPage.reviewOrderTilte(), "Review Your Order");
	checkoutPage.writeDescription("HHIII HJJhgjsahdasnd jhsdjabs asbdkjas");
	paymentPage=checkoutPage.placeOrderBtn();
	paymentPage.paymentCardDetails("ramita", "122131", "12", "5", "2026");
	paymentPage.payAndConfirmOrder();
	
	 deleteAccount=	homepage.deleteBtn();
	 Assert.assertEquals(deleteAccount.accountDeletedConfirmation(),"ACCOUNT DELETED!");
		
		accountpage.clickOnContinueBtn();
	
	}
	
	
	@Test(priority=2,description="verify order is placed and Register before checkout ")
	public void placeOrderRegisterBeforeCheckout() {
		homepage.loadHomePage();
		Assert.assertEquals(homepage.isHomePageLoaded(),"Automation Exercise");
		homepage.loginSignupPageRouting();
		registerPage.enterEmailAndName("roobina",email);
		registerPage.clickOnSignupBtn();
		 accountpage= registerPage.fillAccountInformation("ramita","sam","12345","mohali" ,"chnadigarh","chandigarh","12345","4534534");
		
		Assert.assertEquals(accountpage.IsAccountCreated(),"ACCOUNT CREATED!");
	
		accountpage.clickOnContinueBtn();
		Assert.assertEquals(homepage.isLoggedInUserNameVisisble(), "Logged in as roobina");
		homepage.clickOnAddCartBtnOfFirstProduct();
		homepage.clickOnContinueShoppingHomePage();		
		homepage.clickOnAddCartBtnOfSecondProduct();
		homepage.clickOnContinueShoppingHomePage();	
		homepage.scrollHomePageVerticallyUp();
		homepage.clickOnCartBtn();
		Assert.assertEquals(homepage.isCartPageLoaded(),"Automation Exercise - Checkout") ;
		cartPage.clickCheckoutBtn();
		Assert.assertEquals(checkoutPage.addressTilte(),"YOUR DELIVERY ADDRESS");
		Assert.assertEquals(checkoutPage.reviewOrderTilte(), "Review Your Order");
		checkoutPage.writeDescription("HHIII HJJhgjsahdasnd jhsdjabs asbdkjas");
		paymentPage=checkoutPage.placeOrderBtn();
		paymentPage.paymentCardDetails("ramita", "122131", "12", "5", "2026");
		paymentPage.payAndConfirmOrder();
		
		 deleteAccount=	homepage.deleteBtn();
		 Assert.assertEquals(deleteAccount.accountDeletedConfirmation(),"ACCOUNT DELETED!");
			
			accountpage.clickOnContinueBtn();
	}
	

	@Test(priority=3,description="verify order is placed and Login before checkout ")
	public void placeOrderLoginBeforeCheckout() {
		homepage.loadHomePage();
		Assert.assertEquals(homepage.isHomePageLoaded(),"Automation Exercise");
		homepage.loginSignupPageRouting();
        loginpage.userLogin(PropertyReaderHelper.getConfigPropertyData("email"), PropertyReaderHelper.getConfigPropertyData("password"));
		
		Assert.assertEquals(homepage.isLoggedInUserNameVisisble(),"Logged in as "+PropertyReaderHelper.getConfigPropertyData("username"));
		homepage.clickOnAddCartBtnOfFirstProduct();
		homepage.clickOnContinueShoppingHomePage();		
		homepage.clickOnAddCartBtnOfSecondProduct();
		homepage.clickOnContinueShoppingHomePage();	
		homepage.scrollHomePageVerticallyUp();
		homepage.clickOnCartBtn();
		Assert.assertEquals(homepage.isCartPageLoaded(),"Automation Exercise - Checkout") ;
		cartPage.clickCheckoutBtn();
		Assert.assertEquals(checkoutPage.addressTilte(),"YOUR DELIVERY ADDRESS");
		Assert.assertEquals(checkoutPage.reviewOrderTilte(), "Review Your Order");
		checkoutPage.writeDescription("HHIII HJJhgjsahdasnd jhsdjabs asbdkjas");
		paymentPage=checkoutPage.placeOrderBtn();
		paymentPage.paymentCardDetails("ramita", "122131", "12", "5", "2026");
		paymentPage.payAndConfirmOrder();
	}
}
