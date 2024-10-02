package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.CustomWaits;
import java.io.File;
import java.io.FilenameFilter;

public class PaymentPage extends CustomWaits{
	
	public WebDriver driver;
	public  File dir ;
	
	public PaymentPage(WebDriver driver) {
	this.driver=	driver;
	PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="name_on_card")
	WebElement nameOnCard;
	
	@FindBy(name="card_number")
	WebElement cardNumber;
	
	@FindBy(name="cvc")
	WebElement cvc;
	
	@FindBy(name="expiry_month")
	WebElement expiryMonth;
	
	@FindBy(name="expiry_year")
	WebElement expiryYear;
	
	@FindBy(id="submit")
	WebElement submitBtn;
	
	@FindBy(xpath="//a[@class='btn btn-default check_out']")
	WebElement downloadInvoice;
	
	public void paymentCardDetails(String name,String cardnumber,String cv,String expirymonth,String expiryyear) {
		 nameOnCard.sendKeys(name);
		 cardNumber.sendKeys(cardnumber);
		 cvc.sendKeys(cv);
		 expiryMonth.sendKeys(expirymonth);
		 expiryYear.sendKeys(expiryyear);
		
		 
	}
	
	public void payAndConfirmOrder() {
		 submitBtn.click();
	}
	
	public boolean downloadInvoiceBtn(String filePath,String fileName) {
		boolean isFileDownaloded=false;
		downloadInvoice.click();
		explicitWait(driver,3,downloadInvoice);
		
		
		// Define the extension you are looking for
        FilenameFilter pdfFilter = (dir, name) -> name.startsWith("invoice");
		  dir = new File(filePath);
		File files[]=  dir.listFiles(pdfFilter);
		
		if(files!=null) {
			for(File file:files) {
				System.out.println(file.getName());
			if(	file.getName().equals(fileName)){
				isFileDownaloded=true;
			}
			}
			return isFileDownaloded;
		}
		
		return isFileDownaloded;
		
		
	}
	

}
