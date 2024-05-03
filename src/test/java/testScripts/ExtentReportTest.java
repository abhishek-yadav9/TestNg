package testScripts;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import commonUtils.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExtentReportTest {
	WebDriver driver;
	ExtentReports extentReports;
	ExtentSparkReporter spark;
	ExtentTest extentTest;
	
	@BeforeTest
	public void initExtent() {
		extentReports = new ExtentReports();
		spark = new ExtentSparkReporter("test-output/SparkReport.html")
				.viewConfigurer()
				.viewOrder()
				.as(new ViewName[] {
						ViewName.DASHBOARD,
						ViewName.TEST,
						ViewName.AUTHOR,
						ViewName.LOG,
						ViewName.DEVICE
				}).apply();
		extentReports.attachReporter(spark);
	}
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
  @Test()
  public void javaSearchTest() {
	  extentTest = extentReports.createTest("Java Search Test");
	  driver.get("https://google.com/");
	  WebElement srchBox = driver.findElement(By.className("gLFyf"));
	  srchBox.sendKeys("Java Tutorial");
	  srchBox.submit();
	  Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
	  
  }
	  
  @Test()
  public void seleniumSearchTest() {
	  extentTest = extentReports.createTest("Selenium Search Test");
	  driver.get("https://google.com/");
	  WebElement srchBox = driver.findElement(By.className("gLFyf"));
	  srchBox.sendKeys("Selenium Tutorial");
	  srchBox.submit();
	  Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search");
  }
  
  @Test(retryAnalyzer = RetryAnalyzerImpl.class)
  public void cucumberSearchTest() {
	  extentTest = extentReports.createTest("Cucumber Search Test");
	  driver.get("https://google.com/");
	  WebElement srchBox = driver.findElement(By.className("gLFyf"));
	  srchBox.sendKeys("Cucumber Tutorial");
	  srchBox.submit();
	  Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search");
  }
  
  @Test()
  public void appiumSearchTest() {
	  extentTest = extentReports.createTest("Appium Search Test");
	  driver.get("https://google.com/");
	  WebElement srchBox = driver.findElement(By.className("gLFyf"));
	  srchBox.sendKeys("Appium Tutorial");
	  srchBox.submit();
	  Assert.assertEquals(driver.getTitle(), "Appium Tutorial - Google Search");
  }
  
  @AfterTest
  public void finishExtent() {
	  extentReports.flush();
	  
  }
  
  @AfterMethod
  public void teardown(ITestResult result) {
	  extentTest.assignAuthor("AutomationTester1")
	  .assignCategory("Regression")
	  .assignDevice(System.getProperty("os.name"))
	  .assignDevice(System.getProperty("os.version"));
	  if(ITestResult.FAILURE == result.getStatus()) {
		  extentTest.log(Status.FAIL, result.getThrowable().getMessage());
		  String strPath = utility.getScreenshotPath(driver);
		  extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(strPath).build());
	  } 
	  else if(ITestResult.SKIP == result.getStatus()) {
		  extentTest.log(Status.SKIP, result.getThrowable().getMessage());
	  }
	  driver.close();
}
}


