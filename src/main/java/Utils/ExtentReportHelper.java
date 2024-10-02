package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportHelper {
	
	public static  ExtentReports getExtentReportObject() {
		
		String reportPath=System.getProperty("user.dir")+"//reports//extent.html";
		System.out.println(reportPath);
		ExtentSparkReporter reporter= new ExtentSparkReporter(reportPath);
		
		reporter.config().setDocumentTitle("E commerce Report");
		reporter.config().setReportName("Ramita Sambyal");
		reporter.config().setTheme(Theme.DARK);
		
		
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Ramita Sambyal");
		
		return extent;
	}

}
