package testConfig;

import java.io.IOException;
import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import Base.Common;
import Base.SetupDriver;
import pages.CartPage;
import pages.CommonSubscriptionPage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import pages.SearchProductPage;
import pages.checkOutPage;


public class BaseTest extends SetupDriver {

	public WebDriver driver;
    public	RegisterPage  registerPage;
    public HomePage homepage;
    public   LoginPage loginpage;
    public  Common common;
    public  SearchProductPage searchtab;
    public SoftAssert softAssert;
    public  CommonSubscriptionPage subscriptionOption;
    public  CartPage cartPage; 
    public checkOutPage checkoutPage;
   protected String email;
	
    @Parameters("browserName")
	@BeforeMethod()
	public void setUp(String browserName) throws IOException {
	driver=	intializeBrowser(browserName);
	 registerPage= new RegisterPage(driver);;
	 homepage =new HomePage(driver);;
	 
	loginpage= new LoginPage(driver);
	common= new Common(driver);
	searchtab= new SearchProductPage(driver);
	 softAssert= new SoftAssert();
	 
	 subscriptionOption= new CommonSubscriptionPage(driver);
	 
	 cartPage= new CartPage(driver);
	
	checkoutPage= new checkOutPage(driver);
	 email = "testuser_" + UUID.randomUUID().toString() + "@yop.com";
	 
	 
		    
	}
	
	
	
	@AfterMethod()
	public void driverQuit() {
	driver.quit();
	}
}
