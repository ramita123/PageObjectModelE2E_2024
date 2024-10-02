package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Common;
import Base.CustomWaits;

public class CartPage  {

	
public WebDriver driver;
	
	public CartPage(WebDriver driver) {
		
	this.driver=	driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//td[@class='cart_description'])[1]/h4/a")
	WebElement firstProduct;
	
	
	@FindBy(xpath="(//td[@class='cart_description'])[2]/h4/a")
	WebElement secondProduct;
	
	@FindBy(xpath="(//td[@class='cart_price'])[1]/p")
	WebElement firstProductPrice;
	
	@FindBy(xpath="(//td[@class='cart_price'])[2]/p")
	WebElement secondProductPrice;
	
	@FindBy(xpath="(//td[@class='cart_quantity'])[1]/button")
	WebElement firstProductQuantity;
	
	@FindBy(xpath="(//td[@class='cart_quantity'])[2]/button")
	WebElement secondProductQuantity;
	
	@FindBy(xpath="(//td[@class='cart_total'])[1]/p")
	WebElement firstProductTotalPrice;
	
	@FindBy(xpath="(//td[@class='cart_total'])[2]/p")
	WebElement secondProductTotalPrice;
	
	@FindBy(css=".btn.btn-default.check_out")
	WebElement checkoutBtn;
	
	
	@FindBy(xpath="//div[@class='modal-body']/p/a")
	WebElement registerOrlogin;
	
	@FindBy(xpath="//table[@id='cart_info_table']/tbody/tr/td[6]/a")
	List<WebElement> listOfCartItemsToDelete;
	
	@FindBy(xpath="//span[@id='empty_cart']/p/b")
	WebElement emptyCartMessage;
	
	@FindBy(xpath="//table[@id='cart_info_table']/tbody/tr/td/h4")
	List<WebElement> allCartItems;
	
	@FindBy(xpath="//table[@id='cart_info_table']/tbody/tr")
	WebElement recommendedItemIncart;
	
	
	public boolean areProductAddedToCart() {
		return firstProduct.isDisplayed() && secondProduct.isDisplayed();
	}
	
	public boolean verifyProductDetails() {
		System.out.println(firstProductPrice.getText());
		return firstProductPrice.getText().equals("Rs. 500") && secondProductPrice.getText().equals("Rs. 400") && firstProductQuantity.getText().equals("1") && secondProductQuantity.getText().equals("1")
			&&	firstProductTotalPrice.getText().equals("Rs. 500")
				 && secondProductTotalPrice.getText().equals("Rs. 400");		
	}
	

	public String verifyProductQuantityOnDeatilsPage() {
	return 	firstProductQuantity.getText();
	}
	
	public void clickCheckoutBtn() {
		checkoutBtn.click();
	}
	
	public void clickOnRegisterLoginBtn() {
		registerOrlogin.click();
	}
	
	
	public void deleteProductFromCart() {
		 for(WebElement product:listOfCartItemsToDelete) {
			 product.click();		 }
		
	}
	
	public String isCartEmpty() {
		CustomWaits.staticWait(2);
		return emptyCartMessage.getText();
	}
	
	public boolean productsAreVisisbleInCart(List<String> ExpectedCartItems) {
		for(String produtc:ExpectedCartItems) {
			boolean isItemPresent=false;
			for(WebElement item:allCartItems) {
				System.out.println(item.getText());
				if(item.getText().equalsIgnoreCase(produtc)) {
					isItemPresent=true;
				}
			}
			
			if(!isItemPresent) {
				return false;
			}
		}
		return true;
		
		
	}
	
	public boolean isRecommendedItemIncart() {
		return recommendedItemIncart.isDisplayed();
	}
	
}
