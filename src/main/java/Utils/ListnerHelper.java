package Utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;

import Base.Common;

public class ListnerHelper  implements ITestListener{
	
public WebDriver driver;
	public ExtentReports extent=ExtentReportHelper.getExtentReportObject();
	public ExtentTest extentTest;
	
	
	ThreadLocal<ExtentTest> local= new ThreadLocal();
	
	
	@Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
        //your driver will always come when ever we start @Test method
        //so we can create the extentReports class object here 
      extentTest=   extent.createTest(result.getName());
      System.out.println("the value of extent test"+ extentTest);
      local.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
        System.out.println("the value it is getting from thread local"+ local.get());
        local.get().log(Status.PASS, "Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        local.get().log(Status.FAIL, result.getThrowable());
        
        try {
	driver=		(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
        Common common= new Common(driver);
   String filePath=   common. getScreenshotsOnFailure(result.getMethod().getMethodName());
   local.get().addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
        
        
        
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
       
    }
    
    @Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}
}
