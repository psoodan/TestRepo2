package packtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Class1 {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@Test
	void testMethod1(){
		System.setProperty("webdriver.gecko.driver", "C:/Users/msharma13/workspace/JenkinsTest/Drivers/geckodriver.exe");
		
		report = new ExtentReports("C:/Users/msharma13/workspace/JenkinsTest/Reports/ExtentReport.html",true);
		logger = report.startTest("Test Started", "First Test Case started to run");
		logger.log(LogStatus.INFO, "Open the browser");
		driver = new FirefoxDriver();
		logger.log(LogStatus.INFO, "Maximize the browser");
		driver.manage().window().maximize();
		logger.log(LogStatus.INFO, "Implicit wait of 10 sec to wait for  the element");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.log(LogStatus.INFO, "Enter the url in browser");
		driver.navigate().to("http://www.google.com");
		logger.log(LogStatus.INFO, "Close the browser");
		driver.close();
		report.endTest(logger);
		report.flush();
		report.close();
	}
	
	
	/*public static void main(String[] args) {
	
		System.setProperty("webdriver.gecko.driver", "C:/Users/msharma13/workspace/JenkinsTest/Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://www.google.com");
		driver.close();
	}*/
}
