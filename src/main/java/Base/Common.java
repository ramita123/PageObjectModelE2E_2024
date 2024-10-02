package Base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Common {
	public  WebDriver driver;

	public Common (WebDriver driver) {
		this.driver=driver;
	}
	
	public  void alertHandling() {
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
	}
	
	public  void scrollPage( int x, int y) {
	    JavascriptExecutor exe = (JavascriptExecutor) driver;
	    exe.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
	}
	
	public   String retrieveValidationMessage(WebElement emailInput) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", emailInput);
    
    return validationMessage;
}
	
	public void hoverOnItem( WebElement element) {
		
		Action action= new Actions(driver).moveToElement(element).build();
		action.perform();
		//Actions actions= new Actions(driver);
		//actions.moveToElement(element).build().perform();
	}
	
	
	public String getScreenshotsOnFailure(String testcaseName) {
		
		TakesScreenshot screenShot=(TakesScreenshot)driver;
	File srcFile=	screenShot.getScreenshotAs(OutputType.FILE);
	File desFile= new File(System.getProperty("user.dir")+"//reports//"+ testcaseName +".png");
	try {
		FileUtils.copyFile(srcFile, desFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return System.getProperty("user.dir")+"//reports//"+testcaseName +".png";
		
	}
}