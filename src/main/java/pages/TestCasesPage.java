package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TestCasesPage {
public WebDriver driver;
	
	public TestCasesPage(WebDriver driver) {
	this.driver=	driver;
	PageFactory.initElements(driver, this);
	
	
	}
	
	
	public String getTestcasesPageTitle() {
	return	driver.getTitle();
	}
}
