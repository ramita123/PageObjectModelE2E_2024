package PageTests;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.PropertyReaderHelper;
import Utils.RetryHelper;
import pages.AllProductsAndDetailPage;
import testConfig.BaseTest;

public class SearchProductTest extends BaseTest {
	
 
	
	public static String productName="top";
	public static String productFullName="blue top";
	
	@Test(priority=1,enabled=true)
	public void testSearchProduct() {
		homepage.loadHomePage();
		Assert.assertEquals(homepage.isHomePageLoaded(),"Automation Exercise");
		AllProductsAndDetailPage productDetails=	homepage.clickOnProductsBtn();
		Assert.assertTrue(productDetails.isUserRoutedToProductPage(),"user is not on product page");
		
		searchtab.searchProduct(productName);
		searchtab.searchBtnClick();
		List<WebElement> totalSearchedProducts=searchtab.getAllSearchedProducts();
	
	   for(WebElement product:totalSearchedProducts) {
		   System.out.println(product.getText().toLowerCase());
	  softAssert.assertTrue(product.getText().toLowerCase().contains(productName), "list does not contain the searched product");
	  
	  softAssert.assertAll();
	}
	}
	
	
	//same like listeners we cannot pass this in xml file so the method whcih has chncaes of getting falied
	//we can pass this argument with @Test annotation
	
	@Test(priority=2,retryAnalyzer=RetryHelper.class)
	public void testSearchProductAndVerifyCartAfterLogin() {
		homepage.loadHomePage();
		Assert.assertEquals(homepage.isHomePageLoaded(),"Automation Exercise");
		AllProductsAndDetailPage productDetails=	homepage.clickOnProductsBtn();
		Assert.assertTrue(productDetails.isUserRoutedToProductPage(),"user is not on product page");
		
		searchtab.searchProduct(productFullName);
		searchtab.searchBtnClick();
		
		List<WebElement> totalSearchedProducts=searchtab.getAllSearchedProducts();
		
		for(WebElement product:totalSearchedProducts) {
			   System.out.println(product.getText().toLowerCase());
		  softAssert.assertTrue(product.getText().toLowerCase().contains(productFullName), "list does not contain the searched product");
		  
		  softAssert.assertAll();
		}
		
		
	Assert.assertEquals(searchtab.verifySearchPageTitle(),"SEARCHED PRODUCTS");
	searchtab.addAllSearchedProductsToCart();
	searchtab.scrollSaerchPageVerticallyUp();
	homepage.clickOnCartBtn();
	
	List<String> expectedCartItems=Arrays.asList(productFullName);
	
	Assert.assertTrue(cartPage.productsAreVisisbleInCart(expectedCartItems),"itema are not in the cart");
	homepage.loginSignupPageRouting();
	loginpage.userLogin(PropertyReaderHelper.getConfigPropertyData("email"), PropertyReaderHelper.getConfigPropertyData("password"));
	homepage.clickOnCartBtn();
	Assert.assertTrue(cartPage.productsAreVisisbleInCart(expectedCartItems),"itema are not in the cart");
}
}
