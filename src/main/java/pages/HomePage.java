package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static Base.CustomWaits.staticWait;

import java.util.List;

import Base.Common;
import Base.CustomWaits;
import Utils.PropertyReaderHelper;

public class HomePage extends Common{

	public WebDriver driver;
	public String expectedMessage;
	public CustomWaits wait;
	
	public HomePage(WebDriver driver) {
		super(driver);
		wait= new CustomWaits();
	this.driver=	driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-lock']")
	private WebElement loginBtn;
	
	
	@FindBy(xpath="//header[@id='header']//li[10]//a[1]")
	private WebElement LoggedInUserName;
	
	@FindBy(xpath="//i[@class='fa fa-trash-o']")
	private WebElement deleteBtn;
	
	@FindBy(xpath="//header[@id='header']//li[4]//a[1]")
	private WebElement logoutBtn;
	
	@FindBy(xpath="//header[@id='header']//li[8]//a[1]")
	private WebElement contactUsBtn;
	
	@FindBy(xpath="//header[@id='header']//li[5]//a[1]")
	WebElement testCasesBtn;
	
	@FindBy(css="header[id='header'] li:nth-child(2) a:nth-child(1)")
	WebElement productsBtn;
	
	
	@FindBy(css="header[id='header'] li:nth-child(3) a:nth-child(1)")
	WebElement cartBtn;
	
	
	@FindBy(xpath="(//div[@class='single-products'])[1]/following-sibling::div/ul/li/a")
	WebElement viewProductBtn;
	
	
	@FindBy(xpath="(//div[@class='single-products'])[1]")
	WebElement hoverOnFirstProductHomePage;
	
	@FindBy(xpath="(//div[@class='single-products'])[2]")
	WebElement hoverOnSecondProductHomepage;
	
	@FindBy(xpath="(//div[@class='single-products'])[1]/div[2]/div/a")
	WebElement firstProductAddCartBtnHomePage;
	
	
	@FindBy(xpath="(//div[@class='single-products'])[2]/div[2]/div/a")
	WebElement secondProductAddCartBtnHomePage;
	
	
	@FindBy(xpath="//button[contains(@class,'btn btn-success close-modal btn-block')]")
	WebElement continueShoppingBtnHomePage;
	
	@FindBy(xpath="//div[@class='left-sidebar']/h2")
	WebElement category;
	
	@FindBy(xpath="(//div[@class='panel panel-default']/div/h4/a)[1]")
	WebElement womenCategory;
	
	@FindBy(xpath="//div[@id='Women']/div/ul/li[1]/a")
	WebElement womenDressCategory;
	
	
	@FindBy(xpath="//h2[@class='title text-center']")
	WebElement womenDressCategoryPageHeading;
	
	@FindBy(xpath="(//div[@class='panel panel-default']/div/h4/a)[2]")
	WebElement menCategory;
	
	@FindBy(xpath="//div[@id='Men']/div/ul/li[1]/a")
	WebElement menTshirtCategory;
	
	
	
	@FindBy(xpath="//h2[@class='title text-center']")
	WebElement menTshirtCategoryPageHeading;
	
	@FindBy(xpath="//div[@id='recommended-item-carousel'] //div[@class='single-products']/div/a")
	List<WebElement> addToCartRecommendedItem;
	
	@FindBy(xpath="//p[@class='text-center']/a")
	WebElement viewCartBtn;
	
	
	@FindBy(xpath="//div[@id='recommended-item-carousel'] //div[@class='item active left']")
	WebElement elementToDisAppear;
	
	@FindBy(xpath="//div[@class='carousel-inner'] //div[@class='item active left']")
	WebElement homePageCarousel;
	
	@FindBy(id="scrollUp")
	WebElement scrollUp;
	
	@FindBy(xpath="//div[@class='carousel-inner']/div/div[1]/h2")
	WebElement fullFledgeText;
	
	
	public void clickOnCartBtn() {
		cartBtn.click();
	}
	
	public void loadHomePage() {
		System.out.println(PropertyReaderHelper.getConfigPropertyData("url"));
		driver.get(PropertyReaderHelper.getConfigPropertyData("url"));
	}
	
	public String isHomePageLoaded() {
	String text=	driver.getTitle();
	return text;
	}
	
	
	public String isCartPageLoaded() {
		staticWait(1);
		String text=	driver.getTitle();
		return text;
		}
	
	
	public void loginSignupPageRouting() {
		loginBtn.click();
	}
	
	public String isLoggedInUserNameVisisble() {
		return LoggedInUserName.getText();
	}
	
	public DeleteAccount deleteBtn() {
		deleteBtn.click();
		
		DeleteAccount deleteAccount= new DeleteAccount(driver);
		return deleteAccount;
	}
	
	public void clickOnLogoutBtn() {
		logoutBtn.click();
	}
	
	public ContactUsFormPage clickOnContactFormBtn() {
		contactUsBtn.click();
		ContactUsFormPage contactFormPage= new ContactUsFormPage(driver);
		return contactFormPage;
	}
	
	public TestCasesPage clickOnTestCasesBtn() {
		testCasesBtn.click();
		TestCasesPage testCasesPage= new TestCasesPage(driver);
		return testCasesPage;
	}
	
	public AllProductsAndDetailPage clickOnProductsBtn() {
		productsBtn.click();
		AllProductsAndDetailPage productPage= new AllProductsAndDetailPage(driver);
		return productPage;
	}
	
	public AllProductsAndDetailPage clickOnViewProduct() {
		
		scrollPage(0,1200);
		viewProductBtn.click();
		staticWait(1);
		AllProductsAndDetailPage productPage= new AllProductsAndDetailPage(driver);
		return productPage;
	}
	
	
	
	
	public void clickOnAddCartBtnOfFirstProduct() {
		CustomWaits.staticWait(3);
		scrollPage(0,300);
		//CustomWaits.staticWait(3);
		hoverOnItem(hoverOnFirstProductHomePage);
		wait.explicitWait(driver,2,firstProductAddCartBtnHomePage);
		firstProductAddCartBtnHomePage.click();
		
		
			
	}
	
	public void clickOnContinueShoppingHomePage() {
		CustomWaits.staticWait(2);
		continueShoppingBtnHomePage.click();	
	}
	
	
	public void scrollHomePageVerticallyUp() {
		CustomWaits.staticWait(1);
		scrollPage(0,-1200);
	}
	
	
	public void clickOnAddCartBtnOfSecondProduct() {
		hoverOnItem(hoverOnSecondProductHomepage);
		wait.explicitWait(driver,2,secondProductAddCartBtnHomePage);
		secondProductAddCartBtnHomePage.click();
		
				
	}
	
	
	public boolean isCategoryoptionVisisble() {
		
		scrollPage(0,300);
		CustomWaits.staticWait(1);
		return category.isDisplayed();
	}
	
	public void clickWomenDressCategory() {
		womenCategory.click();
		CustomWaits.staticWait(2);
		 womenDressCategory.click();
	}
	
	public String verifyWomenDressCategoryPage() {
		//CustomWaits.staticWait(2);
	return	womenDressCategoryPageHeading.getText();
	}
	
	
	public void clickMenTshirtCategory() {
		menCategory.click();
		CustomWaits.staticWait(1);
		 menTshirtCategory.click();
	}
	
	
	public String verifyMenTshirtCategoryPage() {
		return	menTshirtCategoryPageHeading.getText();
		}
	
	public void addToCartRecommendedProduct() {
		scrollPage(0,3500);
		CustomWaits.staticWait(5);
		
	for(WebElement item:addToCartRecommendedItem) {
		wait.explicitWaitElementToInvisible(driver,3,elementToDisAppear);
		System.out.println(item.getAttribute("data-product-id"));
		if(item.getAttribute("data-product-id").equals("2")) {
			item.click();
			break;
		}
	}
	}
	
	public void clickOnViewCart() {
		CustomWaits.staticWait(2);
		viewCartBtn.click();
	}
	
	public void verifyScrollDown() {
		scrollPage(0,4000);
		
	}
	
	public void verifyScrollUpWithArrowBtn() {
		scrollUp.click();
	}
	
	public void verifyScrollUpWithoutArrowBtn() {
		scrollPage(0,-11000);
	}
	
	public String verifyFullFledgeTextVisible() {
		
		wait.explicitWaitElementToInvisible(driver, 2, homePageCarousel);
		return fullFledgeText.getText();
	}
	
}
