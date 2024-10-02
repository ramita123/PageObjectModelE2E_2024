package Base;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWaits {
	
	
	

	
	public static void staticWait(int sleepTimeInSeconds)
    {
        try {
            Thread.sleep(sleepTimeInSeconds* 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
	
	public  void explicitWaitForAlert(WebDriver driver,int time) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.alertIsPresent());
		
	}
	
	
	public  void explicitWait(WebDriver driver,int time,WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public  void explicitWaitElementToInvisible(WebDriver driver,int time,WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.invisibilityOf(element));
		
	}
}
