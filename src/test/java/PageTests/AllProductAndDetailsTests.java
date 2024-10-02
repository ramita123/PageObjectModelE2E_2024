package PageTests;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AllProductsAndDetailPage;
import testConfig.BaseTest;

public class AllProductAndDetailsTests extends BaseTest {
	public static int totalProductsList=34;
	
	public Map<String,WebElement> map;
	
	@Test(description="Verify that detail  is visible: product name, category, price, availability, condition, brand" )
	public void testGetAllProductAndDetails() {
		homepage.loadHomePage();
		Assert.assertEquals(homepage.isHomePageLoaded(),"Automation Exercise");
		AllProductsAndDetailPage productDetails=	homepage.clickOnProductsBtn();
	Assert.assertTrue(productDetails.isUserRoutedToProductPage(),"user is not on product page");
	int totalProducts=productDetails.getAllProducts().size();
	Assert.assertEquals(totalProducts, totalProductsList);
	productDetails.clickOnViewCartOfFirstItem();
	
	Assert.assertEquals(productDetails.isUserOnProductDetailPage(),"Automation Exercise - Product Details");
	
    map=productDetails.getAllProductDetails();
 
    for (String key : map.keySet()) {  // Use ':' for iteration
        WebElement element = map.get(key);  // Get the WebElement corresponding to the key
        Assert.assertTrue(element.isDisplayed(), key + " is not visible");
    }
 
	}
}
