package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import Utils.PropertyReaderHelper;
import io.github.bonigarcia.wdm.WebDriverManager;





public class SetupDriver {
	
	public WebDriver driver;
	public String browserName;
	public String downloadDir="C:\\Users\\Ramita\\Downloads";
	
	public WebDriver intializeBrowser(String browser) throws IOException {
		
		// browserName=	PropertyReaderHelper.getConfigPropertyData("browser");
		 System.out.println(browserName);
		 
		 // Check if browser parameter is passed from TestNG, else fallback to properties file
	       browserName = (browser != null) ? browser : PropertyReaderHelper.getConfigPropertyData("browser");
		 
		if(browserName.equalsIgnoreCase("chrome")) {
			
			ChromeOptions options= new ChromeOptions();
			Map<String,Object> map= new HashMap<>();
			map.put("credentials_enable_service", false);  // Disabling password manager service
			map.put("profile.password_manager_enabled", false);
			   // Disable autofill for addresses
		    map.put("autofill.profile_enabled", false);
		    map.put("profile.managed_default_content_settings.images", 2);
			options.setExperimentalOption("prefs", map);
			 options.addArguments("download.default_directory=" + downloadDir);
			
		//	options.addArguments("--Incognito");
			WebDriverManager.chromedriver();
			 driver= new ChromeDriver(options);
			 driver.manage().window().maximize();
			
		}

		else if(browserName.equals("firefox")) {
			  FirefoxOptions options = new FirefoxOptions();
		    //    options.addArguments("-private");
			WebDriverManager.firefoxdriver();
			driver= new FirefoxDriver();
			  FirefoxProfile profile = new FirefoxProfile();
			// Set Firefox preferences for file downloads
		        profile.setPreference("browser.download.folderList", 2); // Use custom download path
		        profile.setPreference("browser.download.dir", downloadDir); // Set download directory
		        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf"); 
		        options.setProfile(profile);
		}
			
		else if(browserName.equals("edge")) {
			 // Configure Edge options to enable InPrivate browsing
	        EdgeOptions options = new EdgeOptions();
	    //    options.addArguments("inprivate");
			WebDriverManager.edgedriver();
			 driver= new  EdgeDriver();
		//	 driver.get("https://www.amazon.com/ref=nav_logo");
		}
		
		return driver;
		
		}
		
}
