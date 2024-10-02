package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Common;
import Base.CustomWaits;

public class SearchProductPage extends Common  {
	
	public WebDriver driver;
	public SearchProductPage(WebDriver driver) {
		super(driver);
		this.driver =	driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id="search_product")
  private	WebElement productId;
	
	@FindBy(id="submit_search")
  private	WebElement searchBtn;
	
	
	@FindBy(xpath="//div[contains(@class,'productinfo')]/p")
	List <WebElement> totalProductsOnSearchPage;
	
	@FindBy(xpath="//h2[@class='title text-center']")
	WebElement PageTitle;
	
	@FindBy(xpath="//div[@class='single-products']")
	List<WebElement> hoverOnSearchedItems;
	
	
	@FindBy(xpath="//div[contains(@class,'overlay-content')]/a")
	List<WebElement> addToCartSearchedItems;
	
	@FindBy(xpath="//button[contains(@class,'btn btn-success close-modal btn-block')]")
	WebElement continueShoppingBtnSearchPage;
	
	public void searchProduct(String productName) {
		productId.sendKeys(productName);
		
	}
	
	public void searchBtnClick() {
		searchBtn.click();
	}
	
	public List<WebElement> getAllSearchedProducts() {
	return	totalProductsOnSearchPage;
	}
	
	public String verifySearchPageTitle() {
		return PageTitle.getText();
	}
	
	public void addAllSearchedProductsToCart() {
		
		for(WebElement item:hoverOnSearchedItems) {
			
			CustomWaits.staticWait(1);
			hoverOnItem(item);
			System.out.println(addToCartSearchedItems.size());
		for(WebElement product:addToCartSearchedItems) {
			CustomWaits.staticWait(1);
			product.click();
			CustomWaits.staticWait(1);
			continueShoppingBtnSearchPage.click();;
		}
	}}
	
	public void scrollSaerchPageVerticallyUp() {
		CustomWaits.staticWait(1);
		scrollPage(0,-1200);
	}
	
	
	
	
}
