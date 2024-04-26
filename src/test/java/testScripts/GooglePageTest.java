package testScripts;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GooglePageTest {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
  @Test(priority=1)
  public void javaSearchTest() {
	  driver.get("https://google.com/");
	  WebElement srchBox = driver.findElement(By.className("gLFyf"));
	  srchBox.sendKeys("Java Tutorial");
	  srchBox.submit();
	  Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
	  
  }
	
	
  
  /*@Test
  public void javaSearchTest() {
	  driver.get("https://google.com/");
	  SoftAssert softAssert = new SoftAssert();
	  softAssert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
	  WebElement srchBox = driver.findElement(By.className("gLFyf"));
	  srchBox.sendKeys("Java Tutorial");
	  srchBox.submit();
	  Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
  }  */
	
	  
  @Test(priority=2)
  public void seleniumSearchTest() {
	  driver.get("https://google.com/");
	  WebElement srchBox = driver.findElement(By.className("gLFyf"));
	  srchBox.sendKeys("Selenium Tutorial");
	  srchBox.submit();
	  Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search");
  }
  
  @Test(priority=3)
  public void cucumberSearchTest() {
	  driver.get("https://google.com/");
	  WebElement srchBox = driver.findElement(By.className("gLFyf"));
	  srchBox.sendKeys("Cucumber Tutorial");
	  srchBox.submit();
	  Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search");
  }
  
  @Test(priority=4)
  public void appiumSearchTest() {
	  driver.get("https://google.com/");
	  WebElement srchBox = driver.findElement(By.className("gLFyf"));
	  srchBox.sendKeys("Appium Tutorial");
	  srchBox.submit();
	  Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search");
  }
  
  @AfterTest
  public void teardown() {
	  driver.close();
	  
  }
}
