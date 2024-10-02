package pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Common;
import Base.CustomWaits;

public class AllProductsAndDetailPage extends Common{
public WebDriver driver;

public CustomWaits wait;
	
	public AllProductsAndDetailPage(WebDriver driver) {
		super(driver);
		 wait= new CustomWaits();
	this.driver=	driver;
	PageFactory.initElements(driver, this);
	
	
	}
	
	@FindBy(xpath="//h2[@class='title text-center']")
	WebElement allProductsTextIsVisisble;
	
	@FindBy(xpath="//div[@class='single-products']")
	List<WebElement> allProductsList;
	
	@FindBy(xpath="(//div[@class='single-products'])[1]/following-sibling::div/ul/li/a")
	WebElement clickFirstProductViewCart;
	
	
	@FindBy(xpath="//div[@class='modal-content']/div[2]/p/a")
	WebElement clickViewCart;
	
	
	@FindBy(xpath="(//div[@class='single-products'])[1]")
	WebElement hoverOnFirstProduct;
	
	@FindBy(xpath="(//div[@class='single-products'])[2]")
	WebElement hoverOnSecondProduct;
	
	@FindBy(xpath="(//div[@class='single-products'])[1]/div[2]/div/a")
	WebElement clickFirstProductAddCartBtn;
	
	@FindBy(xpath="(//div[@class='single-products'])[2]/div[2]/div/a")
	WebElement clickSecondProductAddCartBtn;
	
	@FindBy(xpath="//div[@class='product-information']/h2")
	WebElement productName;
	
	@FindBy(xpath="//div[@class='product-information']/p[1]")
	WebElement productCategory;
	
	@FindBy(xpath="//div[@class='product-information']/span/span")
	WebElement productPrice;
	
	@FindBy(xpath="//div[@class='product-information']/p[2]")
	WebElement productAvailabilty;
	
	@FindBy(xpath="//div[@class='product-information']/p[3]")
	WebElement productCondition;
	
	@FindBy(xpath="//div[@class='product-information']/p[4]")
	WebElement productBrand;
	
	@FindBy(xpath="//button[contains(@class,'btn btn-success close-modal btn-block')]")
	WebElement continueShoppingBtn;
	
	@FindBy(id="quantity")
	WebElement increaseProductQuantity;
	
	@FindBy(css=".btn.btn-default.cart")
	WebElement addToCartBtnDetailsPage;
	
	
	@FindBy(css=".brands_products h2")
	WebElement brandHeading;
	
	@FindBy(xpath="//div[@class='brands-name']/ul/li/a")
	List<WebElement> brandsList;
	
	@FindBy(xpath="//h2[@class='title text-center']")
	WebElement PageTitle;
	
	@FindBy(xpath="//div[@class='single-products']")
	List<WebElement> productsList;
	
	
	@FindBy(xpath="//ul[@class='nav nav-tabs']/li/a")
	WebElement writeYourReview;
	
	@FindBy(id="name")
	WebElement userName;
	
	
	@FindBy(id="email")
	WebElement userEmail;
	
	@FindBy(id="review")
	WebElement addReview;;
	
	
	@FindBy(id="button-review")
	WebElement reviewSubmitBtn;
	
	
	
	
	
	public boolean isUserRoutedToProductPage() {
		return allProductsTextIsVisisble.isDisplayed();
		
	}
	
	public List<WebElement> getAllProducts() {
		return allProductsList;
		
	}
	
	public void clickOnViewCartOfFirstItem() {
		scrollPage(0,300);
		clickFirstProductViewCart.click();
	}
	
	public String isUserOnProductDetailPage() {
	return	driver.getTitle();
	}
	
	public Map<String, WebElement> getAllProductDetails() {
		Map<String,WebElement> map= new HashMap<>();
		map.put("ProductName",productName );
		map.put("ProductCategory",productCategory);
		map.put("ProductPrice",productPrice);
		map.put("ProductAvailable",productAvailabilty);
		map.put("ProductCondition",productCondition);
		map.put("ProductBrand",productBrand);
	return map;
	}
	
	public void clickOnAddCartBtnOfFirstProduct() {
		CustomWaits.staticWait(3);
		scrollPage(0,300);
		//CustomWaits.staticWait(3);
		hoverOnItem(hoverOnFirstProduct);
		wait.explicitWait(driver,2,clickFirstProductAddCartBtn);
		clickFirstProductAddCartBtn.click();
		
		
			
	}
	
	public void clickOnContinueShopping() {
		CustomWaits.staticWait(2);
		continueShoppingBtn.click();	
	}
	
	
	public void clickOnAddCartBtnOfSecondProduct() {
		hoverOnItem(hoverOnSecondProduct);
		wait.explicitWait(driver,2,clickSecondProductAddCartBtn);
		clickSecondProductAddCartBtn.click();
		
				
	}
	
	public void clickOnViewCartBtnSecondItem() {
		CustomWaits.staticWait(3);
		clickViewCart.click();
	}
	
	public void increaseQuantity(int quantity) {
		increaseProductQuantity.clear();
		increaseProductQuantity.sendKeys(String.valueOf(quantity));
	}
	
	public void clickAddToCartProuctDetails() {
		addToCartBtnDetailsPage.click();
	}
	
	public void clickViewCartOnProductDetails() {
		CustomWaits.staticWait(3);
		clickViewCart.click();
	}
	
	public String verifyBrandTitleVisible() {
		scrollPage(0,300);
		return brandHeading.getText();
	}
	
	public boolean verifyBrandsVisisble() {
		CustomWaits.staticWait(1);
		return brandsList.size()>0?true:false;
	}
	
	public void clickAnyBrandOption(String brandName) {
		System.out.println("brand name " +" "+brandName);
		for(WebElement brand:brandsList) {
			CustomWaits.staticWait(1);
			 String brandText = brand.getText().trim(); // Trim any extra spaces
		        System.out.print("Brand text: " + brandText);
			if(brandText.contains(brandName)) {
				
				brand.click();
				break;
			}
			
		}
	}
	
	public String verifyBrandPageIsVisible() {
		CustomWaits.staticWait(1);
		return PageTitle.getText();
	}
	
	public boolean verifyBrandPageProductsVisible() {
		CustomWaits.staticWait(1);
		return productsList.size()>0?true:false;
	}
	
	
	
	public String verifyWriteReviewTitleVisisble() {
		scrollPage(0,300);
	return	writeYourReview.getText();
	}
	
	public void addReview(String name, String email, String review) {
		userName.sendKeys(name);
		userEmail.sendKeys(name);
		addReview.sendKeys(review);
		reviewSubmitBtn.click();
	}
	
	
}
